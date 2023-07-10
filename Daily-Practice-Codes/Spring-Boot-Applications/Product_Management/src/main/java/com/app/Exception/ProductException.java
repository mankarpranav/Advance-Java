package com.app.Exception;

public class ProductException extends RuntimeException {
    
    public ProductException(String msg) {
        super(msg); // Calls the constructor of the parent class (RuntimeException) with the specified error message
    }
}
