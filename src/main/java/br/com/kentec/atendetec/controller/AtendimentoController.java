package br.com.kentec.atendetec.controller;

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
import br.com.kentec.atendetec.domain.Atendente;
import br.com.kentec.atendetec.dto.AtendimentoDto;
import br.com.kentec.atendetec.service.AtendimentoService;

@RestController
@RequestMapping("/atendeTec/api/atendimento")
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService as;
	
	@GetMapping("/{matricula}")
	public ResponseEntity<Optional<Atendente>> atendente(@PathVariable("matricula") String matricula){
		return ResponseEntity.ok(as.findByAtendenteMatricula(matricula));
	}
	
	@GetMapping("/chamar")
	@ResponseStatus(HttpStatus.CREATED)
	public void chamar(@RequestParam("fila") Long fila, 
					   @RequestParam("servidor") String servidor) {
		as.chamar(fila, servidor);
	}
	
	@GetMapping("/reagendar")
	@ResponseStatus(HttpStatus.CREATED)
	public void chamar(@RequestParam("fila") Long fila, 
					   @RequestParam("servico") Long servico) {
		as.reagendar(fila, servico);
	}
	
	@GetMapping("/comecar")
	@ResponseStatus(HttpStatus.CREATED)
	public void comecar(@RequestParam("fila") Long fila) {
		as.comecar(fila);
	}
	
	@GetMapping("/finalizar")
	@ResponseStatus(HttpStatus.CREATED)
	public void finalizar(@RequestParam("fila") Long fila) {
		as.finalizar(fila);
	}
	

	@GetMapping("/gerarAtendente")
	@ResponseStatus(HttpStatus.CREATED)
	public void gerarAtendente(
			@RequestParam("matricula") String matricula, 
			@RequestParam("statusAtendimento") String statusAtendimento, 
			@RequestParam("guiche") String guiche) {
		
		as.gerarAtendente(matricula, statusAtendimento, guiche);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gerarAtendimento(@RequestBody AtendimentoDto atendimentoDto) {
		as.atendimento(atendimentoDto);
	}
}
