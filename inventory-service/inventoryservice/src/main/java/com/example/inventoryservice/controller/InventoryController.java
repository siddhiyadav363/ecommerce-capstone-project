package com.example.inventoryservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;
import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return service.create(inventory);
    }

    @GetMapping("/{productId}")
    public Inventory getInventory(@PathVariable UUID productId) {
        return service.getByProductId(productId);
    }
}