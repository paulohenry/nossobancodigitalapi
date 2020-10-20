package com.paulohenry.zup.nbdigital.controllers.register;



import org.springframework.http.HttpHeaders;


import com.paulohenry.zup.nbdigital.entities.local.LocalRegisterEntity1;
import com.paulohenry.zup.nbdigital.localstorage.LocalRegisterRepository1;
import com.paulohenry.zup.nbdigital.localstorage.LocalRegisterRepository3;
import com.paulohenry.zup.nbdigital.utils.UpDataService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Data;


@Data
@RequestMapping("/user/new/step3")
@CrossOrigin("http://localhost:8081")
public class RegisterUserController3 {
 
	
	private final LocalRegisterRepository1 storage1;
	private final UpDataService storage3;
  private final LocalRegisterRepository3 entity3;
   
  
	
	@PostMapping
	public ResponseEntity<String> uploadFile(
			@RequestParam("cpf")String cpf,
			@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {	

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
				storage3.store(file, entity3);
			HttpHeaders responseHeaders = new HttpHeaders();
						responseHeaders.set("location", "/user/new/confirm?cpf=Seu Cpf Cadastrado");          
				return  ResponseEntity.status(201)
													.headers(responseHeaders)
													.body("Avance para o próximo passo confirme sua proposta, url no header location");
			}catch(Exception e){			
				return ResponseEntity.status(400).body("Erro ao tentar salvar a imagem");
			}
		
		}
 }
}