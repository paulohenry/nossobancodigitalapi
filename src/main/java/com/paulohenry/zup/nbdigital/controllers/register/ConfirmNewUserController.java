package com.paulohenry.zup.nbdigital.controllers.register;



import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity1;
import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity2;
import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity3;
import com.paulohenry.zup.nbdigital.entities.UserEntity;
import com.paulohenry.zup.nbdigital.repositories.UsersRepository;


import com.paulohenry.zup.nbdigital.repositories.LocalRegisterRepository1;
import com.paulohenry.zup.nbdigital.repositories.LocalRegisterRepository2;
import com.paulohenry.zup.nbdigital.repositories.LocalRegisterRepository3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user/new/confirmation")
public class ConfirmNewUserController {
  
  private final UsersRepository user;
  private final LocalRegisterRepository1 storage1;
  private final LocalRegisterRepository2 storage2;
  private final LocalRegisterRepository3 storage3;

  @Autowired
  public ConfirmNewUserController(
    LocalRegisterRepository1 storage1,
    LocalRegisterRepository2 storage2,
    LocalRegisterRepository3 storage3,
    UsersRepository user
    ) {
    this.storage1 = storage1; 
    this.storage2 = storage2; 
    this.storage3 = storage3;  
    this.user = user;  
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> sendConfirmation(
    @RequestParam(name="code") Integer code,
    @RequestParam(name="cpf") String cpf,
    UserEntity userRequest
    ){      
      if(code==123456){
        LocalRegisterEntity1 step1 =  storage1.findOneByCpf(cpf);  
        if(step1.getCpf()==null){
          HttpHeaders responseHeaders = new HttpHeaders();
          responseHeaders.set("location", "/user/new/step1");  
          return 
          ResponseEntity.status(201)
                        .headers(responseHeaders)
                        .body("Você deve iniciar a proposta pelo passo 1");  

        }else{
          LocalRegisterEntity2 step2 =  storage2.findOneByCpf(cpf);
          LocalRegisterEntity3 step3 =  storage3.findOneByCpf(cpf);

          

          userRequest.setNome(step1.getNome());
          userRequest.setSobrenome(step1.getSobrenome());
          userRequest.setCpf(step1.getCpf());
          userRequest.setEmail(step1.getEmail());
          userRequest.setNascimento(step1.getNascimento());
          userRequest.setCep(step2.getCep());
          userRequest.setBairro(step2.getBairro());
          userRequest.setRua(step2.getRua());
          userRequest.setComplemento(step2.getComplemento());
          userRequest.setCidade(step2.getCidade());
          userRequest.setEstado(step2.getEstado());
          userRequest.setName(step3.getNameImage());
          userRequest.setType(step3.getTypeImage());
          userRequest.setData(step3.getData());

          user.save(userRequest);
          return 
          ResponseEntity.status(201)
                        .body("Voce é um novo correntista, parabens");  
          }
         
      }else{
        return 
          ResponseEntity.status(201)
                        .body("Insira o codigo de confirmacao");  
          }
      }
    
    
}
