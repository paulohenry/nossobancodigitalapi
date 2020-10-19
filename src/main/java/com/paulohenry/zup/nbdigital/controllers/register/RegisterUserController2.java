package com.paulohenry.zup.nbdigital.controllers.register;


import javax.validation.Valid;

import com.paulohenry.zup.nbdigital.entities.local.LocalRegisterEntity2;
import com.paulohenry.zup.nbdigital.localstorage.LocalRegisterRepository2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/new/step2")
public class RegisterUserController2 {
  
  private final LocalRegisterRepository2 storage;
  
  
   @Autowired
  public RegisterUserController2(LocalRegisterRepository2 storage) {
    this.storage = storage;
    
   }
   @RequestMapping(value="/passo2", method={RequestMethod.POST})
   @ResponseStatus(HttpStatus.CREATED)
   public LocalRegisterEntity2 register(@PathVariable("cpf") String cpf, @RequestBody @Valid LocalRegisterEntity2 user){
     return storage.save(user);
    }    

}
