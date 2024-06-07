package com.abhinsst.instagram_api.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobleException {
  @ExceptionHandler(UserException.class)
  public ResponseEntity<ErrorDetails> UserExceptionHandler(UserException e, WebRequest req) {

    ErrorDetails error = new ErrorDetails(e.getMessage(), req.getDescription(false), LocalDateTime.now());
    return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);

  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDetails> MethodArgumentNotValidException(MethodArgumentNotValidException me) {

    ErrorDetails error = new ErrorDetails(me.getBindingResult().getFieldError().getDefaultMessage(), "Validation error",
        LocalDateTime.now());
    return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);

  }

  // put this exception in last of the code .
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> OtherExceptionHandler(Exception e, WebRequest req) {

    ErrorDetails error = new ErrorDetails(e.getMessage(), req.getDescription(false), LocalDateTime.now());
    return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);

  }
}
