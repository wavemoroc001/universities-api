package com.wavemoroc.appmanInterPractices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class})
    public final ResponseEntity<?> HandleStudentNotFoundException(StudentNotFoundException ex) {
        ExceptionRes res = new ExceptionRes(HttpStatus.NOT_FOUND, LocalDateTime.now().toString(), ex.getLocalizedMessage());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidFormException.class})
    public final ResponseEntity<?> HandleInvalidAddFormException(InvalidFormException ex) {
        ExceptionRes res = new ExceptionRes(HttpStatus.BAD_REQUEST, LocalDateTime.now().toString(), ex.getLocalizedMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
