package com.davinchicoder.spring_boot_web_template_community.common.mediator;

public interface RequestHandler<T extends Request<R>, R> {
    R handle(T request);

    Class<T> getRequestType();
}

