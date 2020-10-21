package com.paulohenry.zup.nbdigital.utils;

import org.springframework.stereotype.Service;

@Service
public class MailSender {
  
   

  public String send(Integer code, String mail) {
    return "Enviamos um email foi enviado para você, seu codigo de confirmacao é"+code+"ficamos felizes em ter você como novo correntista";
  }
}


