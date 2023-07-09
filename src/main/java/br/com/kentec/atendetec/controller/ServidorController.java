package br.com.kentec.atendetec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import br.com.kentec.atendetec.domain.Servidor;
import br.com.kentec.atendetec.service.ServidorService;

@RestController
@RequestMapping("/atendeTec/api/servidor")
public class ServidorController {
	
	@Autowired
	private ServidorService ss;
	
	@GetMapping()
	public ResponseEntity<Iterable<Servidor>> listarServidor(){
		return ResponseEntity.ok(ss.listarServidor());
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<Servidor> listarServidor(@PathVariable("matricula") String matricula) {
		Optional<Servidor> servidor = ss.findByMatricula(matricula);
		return servidor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/status/{matricula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void mudarStatus(@PathVariable("matricula") String matricula){
		ss.mudarSattus(matricula);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Servidor>> buscaAvancada(
			@RequestParam(value="matricula",  required = false, defaultValue = "") String matricula,
			@RequestParam(value="nome", required = false, defaultValue = "") String nome,
			@RequestParam(value="cpf", required = false, defaultValue = "") String cpf){
		return ResponseEntity.ok(ss.buscaAvancada("%"+matricula+"%", "%"+nome+"%", "%"+cpf+"%"));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Servidor servidor) {
		ss.gravar(servidor);
	}
	
	@PutMapping("/{matricula}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Servidor servidor) {
		ss.alterar(servidor);
	}
}
