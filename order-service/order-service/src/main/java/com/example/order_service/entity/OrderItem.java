package com.example.order_service.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    private UUID id;

    private UUID orderId;
    private UUID productId;
    private Integer quantity;
    private Double price;
    private LocalDateTime createdAt;

    // getters & setters
}

