package com.effigo.hrms.api.config;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class HelloHandler implements RequestHandler<Object, String> {
    @Override
    public String handleRequest(Object input, Context context) {
        return "Hello from Lambda!";
    }
}

