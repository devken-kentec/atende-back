package br.com.kentec.atendetec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.kentec.atendetec.domain.Servico;
import br.com.kentec.atendetec.service.ServicoService;

@RestController
@RequestMapping("/atendeTec/api/servico")
public class ServicoController {
	
	@Autowired
	private ServicoService ss;
	
	@GetMapping()
	public ResponseEntity<Iterable<Servico>> listarServico(){
		return ResponseEntity.ok(ss.listarServico());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Servico> listarServico(@PathVariable("id") Long id){
		Optional<Servico> servico = ss.listarServicoById(id);
		return servico.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/servicoPage")
	public Page<Servico> servicoPaginada(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return ss.listarServico(page, size);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Servico servico) {
			ss.gravar(servico);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Servico servico) {
		ss.alterar(servico);
	}
	
}
