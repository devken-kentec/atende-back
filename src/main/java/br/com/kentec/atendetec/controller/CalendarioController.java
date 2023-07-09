package br.com.kentec.atendetec.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.atendetec.domain.Calendario;
import br.com.kentec.atendetec.service.CalendarioService;

@RestController
@RequestMapping("/atendeTec/api/calendario")
public class CalendarioController {
	
	@Autowired
	private CalendarioService cs;
	
	@GetMapping()
	public ResponseEntity<Iterable<Calendario>> listarCalendario() {
		return ResponseEntity.ok(cs.listarCalendario());
	}
	
	@GetMapping("/diasAtivos")
	public ResponseEntity<Iterable<Calendario>> listarDiasAtivos(){
		return ResponseEntity.ok(cs.listarDiasAtivos());
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Calendario>> pesquisaAvancada(
							@RequestParam(value="dataInicial", required = false, defaultValue="") String dataInicial, 
							@RequestParam(value="dataFinal", required = false, defaultValue = "") String dataFinal, 
							@RequestParam(value="statusCalendario", required = false, defaultValue = "")String statusCalendario, 
							@RequestParam(value="observacao", required = false, defaultValue = "") String observacao){
		return ResponseEntity.ok(cs.pesquisaAvancada(dataInicial,dataFinal,"%" + statusCalendario + "%","%" + observacao + "%"));
	}
	
	@GetMapping("/inativarDias")
	@ResponseStatus(HttpStatus.CREATED)
	public void  inativarDias  (
			@RequestParam(value="dataInicial", required = true, defaultValue="") String dataInicial, 
			@RequestParam(value="dataFinal", required = true, defaultValue = "") String dataFinal){
		 
		cs.inativarDias(dataInicial, dataFinal);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Calendario> listarCalendario(@PathVariable("id") Long id){
		Optional<Calendario> calendario = cs.listCalendarioById(id);
		return calendario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Calendario calendario) {
		cs.gravar(calendario);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Calendario calendario) {
		cs.alterar(calendario);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		cs.delete(id);
	}
}
