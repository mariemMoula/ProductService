package com.MoulaMeriame.ProductService.command.api.events;

import com.MoulaMeriame.ProductService.command.api.data.ProductEntity;
import com.MoulaMeriame.ProductService.command.api.data.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ProcessingGroup("product-group")
@Component
public class ProductEventsHandler {
    //This component will handle
    @Autowired
    private ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) throws Exception {
        ProductEntity product = new ProductEntity();
        product.setProductId(productCreatedEvent.getProductId());
        product.setName(productCreatedEvent.getName());
        product.setPrice(productCreatedEvent.getPrice());
        product.setQuantity(productCreatedEvent.getQuantity());
        productRepository.save(product);
        System.out.println("Product Created Event received for Product Id: " + productCreatedEvent.getProductId());
        throw new Exception("Exception thrown");
    }
/*The @ExceptionHandler method in this class is used to handle exceptions that occur within the event handler methods.
This allows you to define custom logic for handling exceptions specific to this event handler.*/
    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        // Custom logic, e.g., logging the exception
        System.err.println("Exception in Product Microservice event handler: " + exception.getMessage());

        // Rethrow the exception to propagate it
        throw exception;
    }
}

