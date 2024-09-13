package com.uni.PruebaFullStackV1.Controllers;

import com.uni.PruebaFullStackV1.Models.DetailOrder;
import com.uni.PruebaFullStackV1.Models.Order;
import com.uni.PruebaFullStackV1.Services.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
@PreAuthorize("denyAll()")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Order createOrder(@Valid @RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Order updateOrder(@RequestParam("id") Long id,@RequestBody List<DetailOrder> detailOrders){
        return orderService.updateOrder(id, detailOrders);
    }

    @GetMapping("/findById")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Order> findOrderById(@RequestParam("id") Long id){
        try{
            return new ResponseEntity<>(orderService.findOrderById(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @GetMapping("/allOrders")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Order> allOrders(){
        return orderService.allOrders();
    }

    @GetMapping("/findByNumOrder")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> findByNumOrder(@RequestParam("numOrder") String numOrder) {
        try {
            return ResponseEntity.ok(orderService.findOrderByNumOrder(numOrder));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<String> deleteOrder(@RequestParam("id") Long id){
        return ResponseEntity.ok(orderService.deletedOrder(id));
    }
}
