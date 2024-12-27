package com.MoulaMeriame.ProductService.command.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//eq DTO
public class ProductRestModel {
    private String name;
    private double price;
    private int quantity;
}
