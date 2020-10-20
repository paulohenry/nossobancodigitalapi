package com.paulohenry.zup.nbdigital.utils;

import org.springframework.stereotype.Component;

@Component
public class WelcomeHtml {

  
  public String show(){    
      return 
       "<html>\n" +
          "<header>\n" +
          "</header>\n"+
          "<body style=\"display:flex; justify-content:center; align-items:center; flex-direction:column;\">\n"+
              "<h1>Bem vindo ao nosso banco digital</h1>\n"+
              "<h3>\n"+
                "Para utilizar nossa api utilize um serviço\n"+
                "client como <a href=\"https://postman.com\" target=\"_blank\">POSTMAN</a> ou <a <a href=\"https://insomnia.rest/\" target=\"_blank\">IMSOMNIA</a> \n"+
              "</h3>\n"+
              "<h2>Acesse nossa documentação para aprender como consumir nossa api no link abaixo</h2>\n"+
              "<h3><a href=\"https://swager.com\" target=\"_blank\">DOCUMENTAÇÃO</a></h3>\n"+
              "<h2>Acesse O código fonte da api no github</h2>\n"+
              "<h3><a href=\"https://github.com/paulohenry/nossobancodigitalapi\" target=\"_blank\">GITHUB</a></h3>\n"+
              "\n"+
          "</body>\n"+
        "</html>";    
  }
}
