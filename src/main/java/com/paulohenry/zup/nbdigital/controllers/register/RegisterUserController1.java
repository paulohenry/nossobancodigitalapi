package com.paulohenry.zup.nbdigital.controllers.register;

import javax.validation.Valid;

import com.paulohenry.zup.nbdigital.entities.local.LocalRegisterEntity1;
import com.paulohenry.zup.nbdigital.localstorage.LocalRegisterRepository1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/user/new/step1")
public class RegisterUserController1 {
  
  private final LocalRegisterRepository1 storage;
  

  @Autowired
  public RegisterUserController1(LocalRegisterRepository1 storage) {
    this.storage = storage;    
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> step1Register(@RequestBody @Valid LocalRegisterEntity1 user){      
       storage.save(user); 
       HttpHeaders responseHeaders = new HttpHeaders();
       responseHeaders.set("location", "/user/new/step2?cpf=Seu Cpf Cadastrado");  
       return 
       ResponseEntity.status(201)
                     .headers(responseHeaders)
                     .body("Avance para o próximo passo na proposta, url no header location");      
      
       
   }    

}
