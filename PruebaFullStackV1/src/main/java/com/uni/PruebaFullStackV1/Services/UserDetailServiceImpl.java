package com.uni.PruebaFullStackV1.Services;

import com.uni.PruebaFullStackV1.Controllers.DTO.AuthCreateUser;
import com.uni.PruebaFullStackV1.Controllers.DTO.AuthLoginRequest;
import com.uni.PruebaFullStackV1.Controllers.DTO.AuthResponse;
import com.uni.PruebaFullStackV1.Models.RolesAndPermissions.RoleEntity;
import com.uni.PruebaFullStackV1.Models.RolesAndPermissions.RoleEnum;
import com.uni.PruebaFullStackV1.Models.UserEntity;
import com.uni.PruebaFullStackV1.Repositories.RoleRepository;
import com.uni.PruebaFullStackV1.Repositories.UserRepository;
import com.uni.PruebaFullStackV1.Util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userEntity.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name()))));

        userEntity.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getIsEnabled(),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isAccountNonLocked(),
                authorities);
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest){
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();
        Authentication auth = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String accessToken = jwtUtils.createToken(auth);

        return new AuthResponse(username, "User logged successfully", accessToken, true);
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if(userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

    public AuthResponse createUser(AuthCreateUser createUser){
        String username = createUser.username();
        String password = createUser.password();
        String email = createUser.email();
        String address = createUser.address();
        String name = createUser.name();
        String lastName = createUser.lastName();
        String idUser = createUser.idUser();
        String numberPhone = createUser.numberPhone();

        List<RoleEnum> roles = createUser.roleRequest().roleListName();

        Set<RoleEntity> roleEntities = roleRepository.findRoleEntitiesByRoleIn(roles)
                .stream()
                .collect(Collectors.toSet());

        if (roleEntities.isEmpty()) {
            throw new IllegalArgumentException("No roles found");
        }

        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .email(email)
                .name(name)
                .lastName(lastName)
                .address(address)
                .password(passwordEncoder.encode(password))
                .idUser(idUser)
                .numberPhone(numberPhone)
                .createdAt(LocalDateTime.now())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .isEnabled(true)
                .roles(roleEntities)
                .build();

        userRepository.save(userEntity);

        ArrayList<SimpleGrantedAuthority> authorityArrayList = new ArrayList<>();

        userEntity.getRoles().forEach(role -> authorityArrayList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name()))));

        userEntity.getRoles()
                .stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> authorityArrayList.add(new SimpleGrantedAuthority(permission.getName())));

        Authentication auth = new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword(), authorityArrayList);

        String accessToken = jwtUtils.createToken(auth);

        return new AuthResponse(userEntity.getUsername(), "User created successfully", accessToken, true);
    }
}
