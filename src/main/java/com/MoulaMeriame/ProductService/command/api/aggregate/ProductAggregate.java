package com.MoulaMeriame.ProductService.command.api.aggregate;
import com.MoulaMeriame.ProductService.command.api.commands.CreateProductCommand;
import com.MoulaMeriame.ProductService.command.api.events.ProductCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;


@Data
@NoArgsConstructor
@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String productId;
    private String name;
    private double price;
    private int quantity;
    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        //1.Validation Operations
        //2.Creation of the event
        ProductCreatedEvent productCreatedEvent =
                ProductCreatedEvent.builder()
                .productId(createProductCommand.getProductId())
                .name(createProductCommand.getName())
                .price(createProductCommand.getPrice())
                .quantity(createProductCommand.getQuantity())
                .build();
        //3.Publish the event
        apply(productCreatedEvent);
        //4.Updating the state of the aggregate using the event sourcing
    }
    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        //Updating the fields of the aggregate
        this.productId = productCreatedEvent.getProductId();
        this.name = productCreatedEvent.getName();
        this.price = productCreatedEvent.getPrice();
        this.quantity = productCreatedEvent.getQuantity();
    }
}
