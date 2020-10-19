package com.paulohenry.zup.nbdigital.controllers.register;


import javax.validation.Valid;

import com.paulohenry.zup.nbdigital.entities.local.LocalRegisterEntity1;
import com.paulohenry.zup.nbdigital.localstorage.LocalRegisterRepository1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/new/step1")
public class RegisterUserController1 {
  
  private final LocalRegisterRepository1 storage;
  
  
  @Autowired
  public RegisterUserController1(LocalRegisterRepository1 storage) {
    this.storage = storage;    
  }

  @RequestMapping(value="/passo1", method={RequestMethod.POST})
  @ResponseStatus(HttpStatus.CREATED)
  public LocalRegisterEntity1 step1Register(@RequestBody @Valid LocalRegisterEntity1 user){
        
    return storage.save(user);
   }

    
    // @RequestMapping(value="/confirm/{cpf}", method={RequestMethod.GET})
    // @ResponseStatus(HttpStatus.OK)
    // public String confirmProposal(@PathVariable("cpf") String cpf){
    //   return "aqui vai a confirmacao de email condicional de aceite de email";
    //  }

    //  @RequestMapping(value="/confirm/{cpf}", method={RequestMethod.POST})
    //  @ResponseStatus(HttpStatus.CREATED)
    //  public String sendEmail(@PathVariable("cpf") String cpf){
    //    return "aqui vai a confirmacao de email";
    //   }

}
