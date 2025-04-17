package com.davinchicoder.spring_boot_web_template_community.common.mediator;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Mediator {

    private final Map<Class<?>, RequestHandler<?, ?>> handlers;

    public Mediator(List<RequestHandler<?, ?>> handlerList) {
        handlers = handlerList.stream().collect(Collectors.toMap(RequestHandler::getRequestType, Function.identity()));
    }

    public <R, T extends Request<R>> R dispatch(T request) {
        RequestHandler<T, R> handler = (RequestHandler<T, R>) handlers.get(request.getClass());
        if (handler == null) {
            throw new RuntimeException("No handler found for request type: " + request.getClass());
        }
        return handler.handle(request);
    }
}
