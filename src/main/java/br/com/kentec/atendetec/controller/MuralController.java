package br.com.kentec.atendetec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.atendetec.domain.Mural;
import br.com.kentec.atendetec.service.MuralService;

@RestController
@RequestMapping("/atendeTec/api/mural")
public class MuralController {
	
	@Autowired
	private MuralService ms;
	
	@GetMapping()
	public ResponseEntity<Iterable<Mural>> findByAll(){
		return ResponseEntity.ok(ms.findByAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Mural>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(ms.findById(id));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Mural mural) {
		ms.create(mural);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Mural mural) {
		ms.update(mural);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		ms.delete(id);
	}
}
