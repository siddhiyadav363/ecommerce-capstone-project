package com.example.order_service.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.order_service.client.InventoryClient;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;


import org.springframework.security.crypto.password.PasswordEncoder;



@Service

public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository,
                        InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public Order createOrder(UUID userId, UUID productId, int quantity) {

        var inventory = inventoryClient.getInventory(productId);

        if (inventory.availableQuantity < quantity) {
            throw new RuntimeException("Insufficient inventory");
        }

        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setUserId(userId);
        // order.setUsername(username);
        order.setOrderStatus("CREATED");
        order.setTotalAmount(0.0);
        order.setCurrency("INR");
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }

    
}
