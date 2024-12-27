package com.MoulaMeriame.ProductService.query.api.projection;

import com.MoulaMeriame.ProductService.command.api.data.ProductEntity;
import com.MoulaMeriame.ProductService.command.api.data.ProductRepository;
import com.MoulaMeriame.ProductService.command.api.model.ProductRestModel;
import com.MoulaMeriame.ProductService.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {
    @Autowired
    private ProductRepository productRepository;
    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
        List<ProductEntity> products =productRepository.findAll();
        List<ProductRestModel> productRestModels =
                products.stream()
                .map(productEntity -> ProductRestModel
                        .builder()
                        .name(productEntity.getName())
                        .price(productEntity.getPrice())
                        .quantity(productEntity.getQuantity())
                        .build())
                .collect(Collectors.toList());
        return productRestModels ;
    }
}
