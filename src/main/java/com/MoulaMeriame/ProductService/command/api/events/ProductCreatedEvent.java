package com.MoulaMeriame.ProductService.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductCreatedEvent {
    private String productId;
    private String name;
    private double price;
    private int quantity;
}
