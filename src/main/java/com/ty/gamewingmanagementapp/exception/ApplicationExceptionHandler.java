package com.ty.gamewingmanagementapp.exception;

import com.ty.gamewingmanagementapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException exception)
    {
        ResponseStructure<String > responseStructure= new ResponseStructure<String>();

        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage("User DoesNot Exist For Given Id");


        return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
    }

}
