package br.com.kentec.atendetec.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.atendetec.service.EmailService;

@RestController
@RequestMapping("/atendeTec/api/email")
public class EmailController {
	
	@Autowired
	private EmailService es; 

	    @GetMapping("/enviar")
	    public void enviar() { 
	    	es.enviar();
	    }
}
