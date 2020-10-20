package com.paulohenry.zup.nbdigital.exceptions;




import java.util.stream.Collectors;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;




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

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleMaxSizeException(MaxUploadSizeExceededException exc) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao tentar fazer upload tamanho maximo 2MB");
    }

   @ExceptionHandler(DataIntegrityViolationException.class)
   public ResponseEntity<String> integrityViolationException(DataIntegrityViolationException exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro interno 500");
   }


}
