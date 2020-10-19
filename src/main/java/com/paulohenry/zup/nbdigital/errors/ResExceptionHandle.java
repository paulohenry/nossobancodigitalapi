package com.paulohenry.zup.nbdigital.errors;




import java.util.stream.Collectors;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ResExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationException(MethodArgumentNotValidException exception){
          BindingResult result = exception.getBindingResult();
           List<String> messages =result.getAllErrors()
           .stream()
           .map(errorObject ->  errorObject.getDefaultMessage())
           .collect(Collectors.toList());

          return new ApiErrors(messages);
    }
}
