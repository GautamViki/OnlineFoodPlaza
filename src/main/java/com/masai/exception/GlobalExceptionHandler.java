package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FoodPlazaException.class)
    public static ResponseEntity<MyErrorDetails> myExceptionHandler(FoodPlazaException fpe, WebRequest wr) {
        MyErrorDetails err = new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(fpe.getMessage());
        err.setDescription(wr.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public static ResponseEntity<MyErrorDetails> myExHandel2(Exception ie, WebRequest wr) {
        System.out.println("inside my handler ");

        MyErrorDetails err = new MyErrorDetails();
        err.setTimestamp(LocalDateTime.now());
        err.setMessage(ie.getMessage());
        err.setDescription(wr.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidId.class)
    public ResponseEntity<MyErrorDetails> myNotFoundHandler(InvalidId ii, WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ii.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullValueException.class)
    public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(NullValueException nve,WebRequest req) {
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nve.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
