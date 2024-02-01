package com.uni.PruebaFullStackV1.Controllers;

import com.uni.PruebaFullStackV1.Models.DetailOrder;
import com.uni.PruebaFullStackV1.Models.Order;
import com.uni.PruebaFullStackV1.Services.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@Valid @RequestBody Order order){
        return orderService.createOrder(order);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestParam("id") Long id,@RequestBody List<DetailOrder> detailOrders){
        return orderService.updateOrder(id, detailOrders);
    }

    @GetMapping("/findById")
    public Order findOrderById(@RequestParam("id") Long id){
        return orderService.findOrderById(id);
    }

    @GetMapping("/allOrders")
    public List<Order> allOrders(){
        return orderService.allOrders();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOrder(@RequestParam("id") Long id){
        return ResponseEntity.ok(orderService.deletedOrder(id));
    }
}
