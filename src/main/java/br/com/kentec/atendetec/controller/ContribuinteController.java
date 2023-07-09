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

import br.com.kentec.atendetec.domain.Contribuinte;
import br.com.kentec.atendetec.service.ContribuinteService;

@RestController
@RequestMapping("/atendeTec/api/contribuinte")
public class ContribuinteController {
	
	@Autowired
	private ContribuinteService cs;
	
	@GetMapping()
	public ResponseEntity<Iterable<Contribuinte>> listarContribuinte(){
		return ResponseEntity.ok(cs.listarContribuinte());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contribuinte> contribuinteById(@PathVariable("id")  Long id) {
		Optional<Contribuinte> contribuinte = cs.contribuinteById(id);
		return  contribuinte.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Contribuinte>> contribuinteById(
			@RequestParam(value="nome", required = false, defaultValue = "nome") String nome,
			@RequestParam(value="cpfCnpj", required = false, defaultValue = "999") String cpfCnpj){
		return ResponseEntity.ok(cs.buscaAvancada("%" + nome + "%","%" +  cpfCnpj + "%")) ;
	}
	
	@GetMapping("/login")
	public ResponseEntity<Contribuinte> login(
			@RequestParam(value="cpfCnpj", required = true) String cpfCnpj,
			@RequestParam(value="senha", required = true) String senha){
		Optional<Contribuinte> contribuinte = Optional.ofNullable(cs.login(cpfCnpj, senha));
		
		return contribuinte.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/alterarSenha")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarSenha(
			@RequestParam(value="cpfCnpj", required = true) String cpfCnpj,
			@RequestParam(value="senha", required = true) String senha,
			@RequestParam(value="novaSenha", required = true) String novaSenha,
			@RequestParam(value="confirmarNovaSenha", required = true) String confirmarNovaSenha) {
		
		cs.alterarSenha(cpfCnpj, senha, novaSenha, confirmarNovaSenha);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Contribuinte contribuinte) {
		cs.gravar(contribuinte);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Contribuinte contribuinte) {
		cs.alterar(contribuinte);
	}
}
