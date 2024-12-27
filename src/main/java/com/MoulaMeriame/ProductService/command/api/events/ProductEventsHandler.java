package com.MoulaMeriame.ProductService.command.api.events;

import com.MoulaMeriame.ProductService.command.api.data.ProductEntity;
import com.MoulaMeriame.ProductService.command.api.data.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {
    //This component will handle
    @Autowired
    private ProductRepository productRepository;
    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        ProductEntity product = new ProductEntity();
        product.setName(productCreatedEvent.getName());
        product.setPrice(productCreatedEvent.getPrice());
        product.setQuantity(productCreatedEvent.getQuantity());
        productRepository.save(product);
        System.out.println("Product Created Event received for Product Id: " + productCreatedEvent.getProductId());
    }
}
