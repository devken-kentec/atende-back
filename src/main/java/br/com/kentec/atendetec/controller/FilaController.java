package br.com.kentec.atendetec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.atendetec.domain.Fila;
import br.com.kentec.atendetec.dto.FilaDto;
import br.com.kentec.atendetec.service.FilaService;


@RestController
@RequestMapping("/atendeTec/api/fila")
public class FilaController {
	
	@Autowired
	private FilaService fs;
	
	@GetMapping()
	public Iterable<Fila> listarFila(){
		return fs.filaFindByAll();
	}
	
	@GetMapping("/ativados/{unidade}")
	public ResponseEntity<Iterable<Fila>> listarFila(@PathVariable("unidade") String unidade){
		return ResponseEntity.ok(fs.listarFilaAtivados(unidade));
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<Fila> listarFilaId(@PathVariable("id") Long id){
		Optional<Fila> fila = fs.findById(id);
		return fila.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/mobile/avaliar/{identificador}")
	public ResponseEntity<List<Fila>> findByIdentificador(@PathVariable("identificador") Long identificador){
		return ResponseEntity.ok(fs.findByIdentificador(identificador));
	}
	
	@GetMapping("/mobile/finalizado")
	public ResponseEntity<List<Fila>> findByFinalizado(){
		return ResponseEntity.ok(fs.findByFinalizado());
	}
	
	@GetMapping("/verifica/{identificador}")
	public ResponseEntity<Optional<Fila>> findByFilaFinalizado(@PathVariable("identificador") Long identificador){
		return ResponseEntity.ok(fs.findByFilaFinalizado(identificador));
	}
	
	@GetMapping("/mobile/avaliando")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void avaliar(@RequestParam("idFila") Long idFila, 
						@RequestParam("idAgenda") Long idAgenda, 
						@RequestParam("nota") String nota) {
		fs.avaliar(idFila, idAgenda, nota);
	}
	
	@GetMapping("/consultar/avaliar/{cpfCnpj}")
	public List<FilaDto> findByFilaAgendamentoCpfCnpj(@PathVariable("cpfCnpj") String cpfCnpj){
		return fs.findByFilaAgendamentoCpfCnpj(cpfCnpj);
	}
	
	@GetMapping("/espera/{matricula}/{unidade}")
	public ResponseEntity<List<Fila>> listarFilaEspera(@PathVariable("matricula") String matricula,
													   @PathVariable("unidade") String unidade) {
		return ResponseEntity.ok(fs.listarFilaEspera(matricula, unidade));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Fila fila) {
		fs.gravar(fila);
	}
	
	@GetMapping("/contarAvaliacao/{cpfCnpj}")
	public ResponseEntity<Object[]> contarAvaliacao(@PathVariable("cpfCnpj") String cpfCnpj) {
		return ResponseEntity.ok(fs.contarAvaliacao(cpfCnpj));
	}
}
