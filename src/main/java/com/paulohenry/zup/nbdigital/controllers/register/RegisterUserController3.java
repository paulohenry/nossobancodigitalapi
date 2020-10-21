package com.paulohenry.zup.nbdigital.controllers.register;



import org.springframework.http.HttpHeaders;


import com.paulohenry.zup.nbdigital.entities.LocalRegisterEntity1;
import com.paulohenry.zup.nbdigital.repositories.LocalRegisterRepository1;
import com.paulohenry.zup.nbdigital.repositories.LocalRegisterRepository3;
import com.paulohenry.zup.nbdigital.utils.UpDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import lombok.Data;


@Data
@RestController
public class RegisterUserController3 {
 
	
	private final LocalRegisterRepository1 storage1;
	private final UpDataService storage3;
  private final LocalRegisterRepository3 entity3;
   
  
	
	@PostMapping("/user/new/step3")
	public ResponseEntity<String> uploadFile(
			@RequestParam("cpf")String cpf,
			@RequestParam("image") MultipartFile file) {	
	LocalRegisterEntity1 res =  storage1.findOneByCpf(cpf);
	if(res.getCpf()==null){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("location", "/user/new/step1");  
		return 
		ResponseEntity.status(201)
									.headers(responseHeaders)
									.body("Você deve iniciar a proposta pelo passo 1");           
		}else{ 	
			try{
				System.out.println(file);
				storage3.store(file, cpf);
			HttpHeaders responseHeaders = new HttpHeaders();
						responseHeaders.set("location", "/user/check?cpf=Seu Cpf Cadastrado");          
				return  ResponseEntity.status(201)
													.headers(responseHeaders)
													.body("Avance para o próximo passo confirme sua proposta envie um GET, url no header location");
			}catch(Exception e){			
				return ResponseEntity.status(400).body("Erro ao tentar salvar a imagem");
			}
		
		}
 }
}