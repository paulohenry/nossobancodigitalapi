package com.paulohenry.zup.nbdigital.controllers.register;




import javax.validation.Valid;

import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity2;
import com.paulohenry.zup.nbdigital.repositories.LocalRegisterRepository1;
import com.paulohenry.zup.nbdigital.repositories.LocalRegisterRepository2;
import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/new/step2")
public class RegisterUserController2 {
  
  private final LocalRegisterRepository2 storage2;
  private final LocalRegisterRepository1 storage1;


  @Autowired
  public RegisterUserController2(
    LocalRegisterRepository2 storage2, 
    LocalRegisterRepository1 storage1) 
    {
      this.storage2 = storage2;
      this.storage1=storage1;    
    }


   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<String> stepRegister2(@RequestParam(name="cpf") String cpf,@RequestBody @Valid LocalRegisterEntity2 user){         
          
    LocalRegisterEntity1 res =  storage1.findOneByCpf(cpf);
          if(res.getCpf()==null){
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("location", "/user/new/step1");  
            return 
            ResponseEntity.status(201)
                          .headers(responseHeaders)
                          .body("Você deve iniciar a proposta pelo passo 1");           
          }else{  
          user.setCpf(res.getCpf());       
          storage2.save(user);   
          HttpHeaders responseHeaders = new HttpHeaders();
          responseHeaders.set("location", "/user/new/step3?cpf=Seu Cpf Cadastrado");  
          return 
          ResponseEntity.status(201)
                        .headers(responseHeaders)
                        .body("Avance para o próximo passo na proposta, url no header location");       
              
          } 
 }
}
