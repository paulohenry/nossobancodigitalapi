package com.paulohenry.zup.nbdigital.controllers.root;

import com.paulohenry.zup.nbdigital.utils.WelcomeHtml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {
    
    @Autowired
    private WelcomeHtml welcome;

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String starter(){
     return  welcome.show();
    }

}
