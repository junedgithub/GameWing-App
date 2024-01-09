package com.ty.gamewingmanagementapp.exception;

public class IdNotFoundException extends RuntimeException{
    private String message = "Id Not Found";

    public IdNotFoundException(){

    }
    public IdNotFoundException(String message) {
        super(message);
    }
}
