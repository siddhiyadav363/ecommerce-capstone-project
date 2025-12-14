package com.example.inventoryservice.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public Inventory create(Inventory inventory) {

    repository.findByProductId(inventory.getProductId())
        .ifPresent(existing -> {
            throw new RuntimeException("Inventory already exists for product");
        });

    inventory.setId(UUID.randomUUID());
    inventory.setReservedQuantity(0);
    inventory.setCreatedAt(LocalDateTime.now());

    return repository.save(inventory);
}


    public Inventory getByProductId(UUID productId) {
        return repository.findByProductId(productId)
                .orElseThrow(() ->
                        new RuntimeException("Inventory not found for productId: " + productId)
                );
    }
}
