package com.MoulaMeriame.ProductService.command.api.exception;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.EventMessageHandler;
import org.axonframework.eventhandling.ListenerInvocationErrorHandler;

import javax.annotation.Nonnull;
/*This class implements ListenerInvocationErrorHandler and is used to handle exceptions that occur during event handling*/
public class ProductServiceEventsErrorHandler implements ListenerInvocationErrorHandler {
/*The onError method is overridden to provide custom logic for handling exceptions. In this case, it simply rethrows the exception after logging i*/

    @Override
    public void onError(@Nonnull Exception exception, @Nonnull EventMessage<?> event, @Nonnull EventMessageHandler eventHandler) throws Exception {
        throw exception;
    }
}
