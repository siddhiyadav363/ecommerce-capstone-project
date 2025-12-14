package com.example.order_service.controller;


import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order placeOrder(
            @RequestParam UUID userId,
            @RequestParam UUID productId,
            @RequestParam int quantity
    ) {
        return service.createOrder(userId, productId, quantity);
    }
}

