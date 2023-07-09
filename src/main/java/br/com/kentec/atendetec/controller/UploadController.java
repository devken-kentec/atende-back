package br.com.kentec.atendetec.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.atendetec.service.UploadService;

@RestController
@RequestMapping("/atendeTec/api/uploads")
public class UploadController {
	
	@Autowired
	private UploadService us;
	
	@PostMapping("/calendario")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadCalendario(@RequestBody String caminho) throws IOException {
		us.lerCalendario(caminho);
	}
	
	@PostMapping("/grade")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadGrade(@RequestBody String caminho) throws IOException {
		us.lerGrade(caminho);
	}
	
	@PostMapping("/servico")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadServico(@RequestBody String caminho) throws IOException {
		us.lerServico(caminho);
	}
	
	@PostMapping("/detalheServico")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadDetalheServico(@RequestBody String caminho) throws IOException {
		us.lerDetalheServico(caminho);
	}
	
	@PostMapping("/unidade")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadUnidade(@RequestBody String caminho) throws IOException {
		us.lerUnidade(caminho);
	}
	
	@PostMapping("/orgao")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadOrgao(@RequestBody String caminho) throws IOException {
		us.lerOrgao(caminho);
	}
	
	@PostMapping("/servidor")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadServidor(@RequestBody String caminho) throws IOException {
		us.lerServidor(caminho);
	}
}
