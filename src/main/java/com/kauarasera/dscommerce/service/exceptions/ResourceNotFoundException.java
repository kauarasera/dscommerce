package com.kauarasera.dscommerce.service.exceptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
