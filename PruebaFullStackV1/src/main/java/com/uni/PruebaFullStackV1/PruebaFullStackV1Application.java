package com.uni.PruebaFullStackV1;

import com.uni.PruebaFullStackV1.Models.RolesAndPermissions.PermissionsEntity;
import com.uni.PruebaFullStackV1.Models.RolesAndPermissions.RoleEntity;
import com.uni.PruebaFullStackV1.Models.RolesAndPermissions.RoleEnum;
import com.uni.PruebaFullStackV1.Models.UserEntity;
import com.uni.PruebaFullStackV1.Repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class PruebaFullStackV1Application {

	public static void main(String[] args) {
		SpringApplication.run(PruebaFullStackV1Application.class, args);
	}

	/*@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			//Create permissions
			PermissionsEntity createPermissionEntity = PermissionsEntity.builder()
					.name("CREATE").build();
			PermissionsEntity updatePermissionEntity = PermissionsEntity.builder()
					.name("UPDATE").build();
			PermissionsEntity readPermissionEntity = PermissionsEntity.builder()
					.name("READ").build();
			PermissionsEntity deletePermissionEntity = PermissionsEntity.builder()
					.name("DELETE").build();

			//Create roles
			RoleEntity roleAdmin = RoleEntity.builder()
					.role(RoleEnum.ADMIN)
					.permissions(Set.of(createPermissionEntity, readPermissionEntity, updatePermissionEntity, deletePermissionEntity)).build();

			RoleEntity roleUser = RoleEntity.builder()
					.role(RoleEnum.USER)
					.permissions(Set.of(createPermissionEntity, readPermissionEntity)).build();

			RoleEntity roleInvited = RoleEntity.builder()
					.role(RoleEnum.INVITED)
					.permissions(Set.of(readPermissionEntity)).build();

			RoleEntity roleDevp = RoleEntity.builder()
					.role(RoleEnum.DEVELOPER)
					.permissions(Set.of(createPermissionEntity, readPermissionEntity, updatePermissionEntity, deletePermissionEntity)).build();

			//Create users

			UserEntity userDiego = UserEntity.builder()
					.username("diego01")
					.password("$2a$10$BTjR0v3z/CBv8lTzh4mzwubxPhcGDfg3qsoQurBSQ1F6Uc/iGzZDm")
					.email("diego@gmail.com")
					.address("Calle 1")
					.name("Diego")
					.lastName("Leon")
					.numberPhone("3007511826")
					.createdAt(LocalDateTime.now())
					.idUser("1234567899")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roles(Set.of(roleAdmin, roleUser, roleDevp))
					.build();

			userRepository.saveAll(List.of(userDiego));
		};
	}*/
}
