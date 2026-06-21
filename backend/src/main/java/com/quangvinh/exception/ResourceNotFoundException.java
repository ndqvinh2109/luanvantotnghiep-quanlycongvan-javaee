package com.quangvinh.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Object id) {
        super("Không tìm thấy %s với id: %s".formatted(resource, id));
    }
}
