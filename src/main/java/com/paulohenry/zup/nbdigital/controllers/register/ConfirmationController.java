package com.paulohenry.zup.nbdigital.controllers.register;


import com.paulohenry.zup.nbdigital.utils.ConfirmRegisterEntity;
import com.paulohenry.zup.nbdigital.utils.MailSender;
import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity1;
import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity2;
import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity3;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user/new/step4")
public class ConfirmationController {
  
  private final LocalRegisterRepository1 storage1;
  private final LocalRegisterRepository2 storage2;
  private final LocalRegisterRepository3 storage3;

  @Autowired
  public ConfirmationController(
    LocalRegisterRepository1 storage1,
    LocalRegisterRepository2 storage2,
    LocalRegisterRepository3 storage3
    ) {
    this.storage1 = storage1; 
    this.storage2 = storage2; 
    this.storage3 = storage3;    
  }

  @PostMapping("/confirm")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> sendConfirmation(
    @RequestParam(name="confirm") Boolean confirm,
    @RequestParam(name="cpf") String cpf
    ){      
      System.out.println("entrou no confirm");
      if(confirm==true){   
        LocalRegisterEntity1 res =  storage1.findOneByCpf(cpf);
        if(res.getCpf()==null){
          return ResponseEntity.status(400)
          .body("Vpcê precisa passar um cpf");  

        }else{
        MailSender sender = new MailSender() ;  

        String responseEmail = sender.send(123456, res.getEmail());   
        return 
        ResponseEntity.status(201)
                      .body(responseEmail);      
        }
      }else{
        return 
        ResponseEntity.status(201)
                 .body("Que pena, enviamos um email para você caso mude de ideia");    
     
      }       
   }  
   @GetMapping("/check")
   public ResponseEntity<ConfirmRegisterEntity> getConfirmation(
      @RequestParam(name="cpf") String cpf) {
     
        
        LocalRegisterEntity1 step1 =  storage1.findOneByCpf(cpf);
        if(step1==null){
          ConfirmRegisterEntity confirmacao = new ConfirmRegisterEntity("Você deve iniciar a proposta pelo passo 1");
          HttpHeaders responseHeaders = new HttpHeaders();
          responseHeaders.set("location", "/user/new/step1");  
          return 
          ResponseEntity.status(201)
                        .headers(responseHeaders)
                        .body(confirmacao);        
        }
        else{
        if(step1.getCpf()==null){
          ConfirmRegisterEntity confirmacao = new ConfirmRegisterEntity();
          confirmacao.setMessage("Você deve iniciar a proposta pelo passo 1");
          HttpHeaders responseHeaders = new HttpHeaders();
          responseHeaders.set("location", "/user/new/step1");  
          return 
          ResponseEntity.status(201)
                        .headers(responseHeaders)
                        .body(confirmacao);        
        }else{       
        LocalRegisterEntity2 step2 = storage2.findOneByCpf(cpf);
        LocalRegisterEntity3 step3 = storage3.findOneByCpf(cpf);

        ConfirmRegisterEntity confirmacao = new ConfirmRegisterEntity();

        confirmacao.setNome(step1.getNome());
        confirmacao.setSobrenome(step1.getSobrenome());
        confirmacao.setCpf(step1.getCpf());
        confirmacao.setEmail(step1.getEmail());
        confirmacao.setNascimento(step1.getNascimento());
        confirmacao.setCep(step2.getCep());
        confirmacao.setBairro(step2.getBairro());
        confirmacao.setRua(step2.getRua());
        confirmacao.setComplemento(step2.getComplemento());
        confirmacao.setCidade(step2.getCidade());
        confirmacao.setEstado(step2.getEstado());
        confirmacao.setNameImage(step3.getNameImage());
        confirmacao.setTypeImage(step3.getTypeImage());
        confirmacao.setData(step3.getData());
        confirmacao.setMessage("Confira seus dados e confirme se aceita ou não, Envie um POST para a mesma rota");
       

     return ResponseEntity.status(200)            
            .body(confirmacao);
     }
    }
   }  
}
