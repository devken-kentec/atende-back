package br.com.kentec.atendetec.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import br.com.kentec.atendetec.domain.Acesso;
import br.com.kentec.atendetec.service.AcessoService;

@RestController
@RequestMapping("/atendeTec/api/acesso")
public class AcessoController {
	
	@Autowired
	private AcessoService as;
	
	@GetMapping()
	public ResponseEntity<Iterable<Acesso>> listarAcesso(){
		return ResponseEntity.ok(as.listarAcesso());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Acesso> listarAcesso(@PathVariable("id") Long id){
		Optional<Acesso> acesso = as.listAcessoById(id);
		return acesso.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/logar")
	public ResponseEntity<Acesso> login(
			@RequestParam(value="matricula", required = true) String matricula,
			@RequestParam(value="senha", required = true) String senha){
		
		Optional<Acesso> acesso = Optional.ofNullable(as.logar(matricula, senha));
		
		return acesso.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/acessoPage")
	public Page<Acesso> acessoPaginado(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return as.listarAcesso(page, size);
	}
	
	@GetMapping("/alterarSenha")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarSenha(
			@RequestParam(value="matricula", required = true) String matricula,
			@RequestParam(value="senha", required = true) String senha,
			@RequestParam(value="novaSenha", required = true) String novaSenha,
			@RequestParam(value="confirmarNovaSenha", required = true) String confirmarNovaSenha) {
		as.alterarSenha(matricula, senha, novaSenha, confirmarNovaSenha);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Acesso acesso) {
		as.gravar(acesso);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Acesso acesso) {
		as.alterar(acesso);
	}
}
