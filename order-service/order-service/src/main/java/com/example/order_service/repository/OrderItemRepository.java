package com.example.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.order_service.entity.OrderItem;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {}
