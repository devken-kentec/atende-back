package br.com.kentec.atendetec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.kentec.atendetec.domain.Guiche;
import br.com.kentec.atendetec.service.GuicheService;

@RestController
@RequestMapping("/atendeTec/api/guiche")
public class GuicheController {
	
	@Autowired
	private GuicheService gs;
	
	@GetMapping()
	public ResponseEntity<Iterable<Guiche>> listarGuiche(){
		return ResponseEntity.ok(gs.listarGuiche());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Guiche> listarGuiche(@PathVariable("id") Long id) {
		Optional<Guiche> guiche = gs.listGuicheById(id);
		return guiche.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/guichePage")
	public Page<Guiche> guichePaginado(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return gs.listarGuiche(page, size);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Guiche guiche) {
		gs.gravar(guiche);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Guiche guiche) {
		gs.alterar(guiche);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {	
		gs.delete(id);
	}
}
