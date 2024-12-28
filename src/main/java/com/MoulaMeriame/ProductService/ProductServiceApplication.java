package com.MoulaMeriame.ProductService;

import com.MoulaMeriame.ProductService.command.api.exception.ProductServiceEventsErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	/*This method registers the ProductServiceEventsErrorHandler with the EventProcessingConfigurer to ensure that it is used for handling exceptions in the "product-group" processing group.*/
	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler("product-group", configuration -> new ProductServiceEventsErrorHandler());
	}
}
