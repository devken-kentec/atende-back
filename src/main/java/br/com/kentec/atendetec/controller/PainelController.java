package br.com.kentec.atendetec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.atendetec.domain.Painel01;
import br.com.kentec.atendetec.domain.Painel02;
import br.com.kentec.atendetec.domain.Painel03;
import br.com.kentec.atendetec.domain.Painel04;
import br.com.kentec.atendetec.domain.Painel05;
import br.com.kentec.atendetec.domain.Painel06;
import br.com.kentec.atendetec.service.PainelService;

@RestController
@RequestMapping("/atendeTec/api/painel")
public class PainelController {
	
	@Autowired
	private PainelService ps;

	
	@GetMapping("/01")
	public ResponseEntity<Iterable<Painel01>> listarPainel01(){
		return ResponseEntity.ok(ps.listarPainel01());
	}
	
	@GetMapping("/01/chamada")
	public ResponseEntity<Optional<Painel01>> listarChamada01(){
		return ResponseEntity.ok(ps.listarChamada());
	}
	
	@GetMapping("/02")
	public ResponseEntity<Iterable<Painel02>> listarPainel02(){
		return ResponseEntity.ok(ps.listarPainel02());
	}
	
	@GetMapping("/02/chamada")
	public ResponseEntity<Optional<Painel02>> listarChamada02(){
		return ResponseEntity.ok(ps.listarChamada2());
	}
	
	@GetMapping("/03")
	public ResponseEntity<Iterable<Painel03>> listarPainel03(){
		return ResponseEntity.ok(ps.listarPainel03());
	}
	
	@GetMapping("/03/chamada")
	public ResponseEntity<Optional<Painel03>> listarChamada03(){
		return ResponseEntity.ok(ps.listarChamada03());
	}
	
	@GetMapping("/04")
	public ResponseEntity<Iterable<Painel04>> listarPainel04(){
		return ResponseEntity.ok(ps.listarPainel04());
	}
	
	@GetMapping("/04/chamada")
	public ResponseEntity<Optional<Painel04>> listarChamada04(){
		return ResponseEntity.ok(ps.listarChamada04());
	}
	
	@GetMapping("/05")
	public ResponseEntity<Iterable<Painel05>> listarPainel05(){
		return ResponseEntity.ok(ps.listarPainel05());
	}
	
	@GetMapping("/05/chamada")
	public ResponseEntity<Optional<Painel05>> listarChamada05(){
		return ResponseEntity.ok(ps.listarChamada05());
	}
	
	@GetMapping("/06")
	public ResponseEntity<Iterable<Painel06>> listarPainel06(){
		return ResponseEntity.ok(ps.listarPainel06());
	}
	
	@GetMapping("/06/chamada")
	public ResponseEntity<Optional<Painel06>> listarChamada06(){
		return ResponseEntity.ok(ps.listarChamada06());
	}
}
