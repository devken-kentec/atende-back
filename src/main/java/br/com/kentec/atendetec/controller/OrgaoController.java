package br.com.kentec.atendetec.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.kentec.atendetec.domain.Orgao;
import br.com.kentec.atendetec.service.OrgaoService;


@RestController
@RequestMapping("/atendeTec/api/orgao")
public class OrgaoController {
	
	@Autowired
	private OrgaoService os; 
	
	@GetMapping()
	public ResponseEntity<Iterable<Orgao>> listarOrgao(){
		return ResponseEntity.ok(os.listarOrgao());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Orgao> listarOrgao(@PathVariable("id") Long id){
		Optional<Orgao> orgao = os.listOrgaoById(id);
		return orgao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	} 
	
	@GetMapping("/orgaoPage")
	public Page<Orgao> listarOrgaoPaginado(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="size", defaultValue = "10") Integer size
			){

		return os.listarOrgaoPage(page, size);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Orgao orgao) {
		os.gravar(orgao);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Orgao orgao) {
		os.alterar(orgao);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		os.delete(id);
	}
}
