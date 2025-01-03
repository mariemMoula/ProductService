package com.MoulaMeriame.ProductService.query.api.controller;

import com.MoulaMeriame.ProductService.command.api.model.ProductRestModel;
import com.MoulaMeriame.ProductService.query.api.queries.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductRestModel> getAllProducts() {
        return queryGateway.query(new GetProductsQuery(), ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
    }

}
