package br.com.kentec.atendetec.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.atendetec.service.DataService;

@RestController
@RequestMapping("/teste")
public class Controller {
	
	@Autowired
	private DataService ds;
	
	@GetMapping
	public String teste() {
		return ds.now().toString();
	}
}
