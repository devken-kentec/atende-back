package br.com.kentec.atendetec.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.kentec.atendetec.domain.Unidade;
import br.com.kentec.atendetec.service.UnidadeService;

@RestController
@RequestMapping("/atendeTec/api/unidade")
public class UnidadeController {
	
	@Autowired
	private UnidadeService us; 
	
	@GetMapping()
	public ResponseEntity<Iterable<Unidade>> listarUnidade(){
		return ResponseEntity.ok(us.listarUnidade());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Unidade> listarUnidade(@PathVariable("id") Long id){
		Optional<Unidade> unidade = us.listUnidadeById(id);
		return unidade.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/unidadeGenerica")
	public ResponseEntity<List<Unidade>> listarUnidade( 
			@RequestParam(value="role") String role, 
			@RequestParam(value="unidadeId") Long unidadeId){
		return ResponseEntity.ok(us.listarUnidadeGenerica(role, unidadeId));
	}
	
	@GetMapping("/unidadePage")
	public Page<Unidade> unidadePaginada(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return us.listarUnidade(page, size);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Unidade unidade) {
		us.gravar(unidade);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Unidade unidade){
		us.alterar(unidade);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		us.delete(id);
	}
}
