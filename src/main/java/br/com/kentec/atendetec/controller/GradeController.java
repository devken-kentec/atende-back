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

import br.com.kentec.atendetec.domain.Grade;
import br.com.kentec.atendetec.dto.GradeDto;
import br.com.kentec.atendetec.service.GradeService;

@RestController
@RequestMapping("/atendeTec/api/grade")
public class GradeController {
	
	@Autowired
	private GradeService gs;
	
	@GetMapping()
	public ResponseEntity<Iterable<Grade>> listarGrade(){
		return ResponseEntity.ok(gs.listarGrade());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Grade> gradeById(@PathVariable("id") Long id) {
		Optional<Grade> grade = gs.gradeById(id);
		return grade.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Grade>> buscaAvancada(
			@RequestParam(value ="unidade", required = true) String unidade,
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="servico", required = false, defaultValue="") String servico){
		
		return ResponseEntity.ok(gs.buscaAvancada( unidade ,  dataInicial ,  dataFinal , "%" + servico + "%"));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Grade grade) {
		gs.gravar(grade);
	}
	
	@PostMapping("/multipla")
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody GradeDto gradeDto) {
		gs.gravarGradeDemanda(gradeDto);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@RequestBody Grade grade) {
		gs.alterar(grade);
	}
	
	@GetMapping("/liberarGrade/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterar(@PathVariable("id") Long Id) {
		gs.liberarGrade(Id);
	}
}
