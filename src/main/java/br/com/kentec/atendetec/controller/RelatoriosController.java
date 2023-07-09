package br.com.kentec.atendetec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.kentec.atendetec.dto.AtendenteDto;
import br.com.kentec.atendetec.dto.AtendimentoDto;
import br.com.kentec.atendetec.service.RelatoriosService;

@RestController
@RequestMapping("/atendeTec/api/relatorios")
public class RelatoriosController {
	
	@Autowired
	private RelatoriosService rs;
	
	@GetMapping("/grade/unidade")
	public ResponseEntity<Object[]> listarUnidade(
			@RequestParam(value ="unidade", required = false, defaultValue="") String unidade,
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="servico", required = false, defaultValue="") String servico){
		return ResponseEntity.ok(rs.listarQuanUnidade("%" + unidade + "%",  dataInicial ,  dataFinal , "%" + servico + "%")); 
	}
	
	@GetMapping("/grade/servico")
	public  ResponseEntity<Object[]> listarServico(
			@RequestParam(value ="unidade", required = false, defaultValue="") String unidade,
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="servico", required = false, defaultValue="") String servico){
		return ResponseEntity.ok(rs.listarQuanServico("%" + unidade + "%",  dataInicial ,  dataFinal , "%" + servico + "%")); 
	}
	
	@GetMapping("/agendamento/unidade")
	public ResponseEntity<Object[]> listarAgendUnidade(
			@RequestParam(value ="unidade", required = false, defaultValue="") String unidade,
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="servico", required = false, defaultValue="") String servico,
			@RequestParam(value ="statusAgendamento", required = false, defaultValue="") String statusAgendamento) {
		return ResponseEntity.ok(rs.listarQuantAgendUnidade("%" + unidade + "%",  dataInicial ,  dataFinal , "%" + servico + "%", "%" + statusAgendamento + "%"));
	}
	
	@GetMapping("/agendamento/servico")
	public ResponseEntity<Object[]> listarAgendServico(
			@RequestParam(value ="unidade", required = false, defaultValue="") String unidade,
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="servico", required = false, defaultValue="") String servico,
			@RequestParam(value ="statusAgendamento", required = false, defaultValue="") String statusAgendamento) {
		return ResponseEntity.ok(rs.listarQuantAgendServico("%" + unidade + "%",  dataInicial ,  dataFinal , "%" + servico + "%", "%" + statusAgendamento + "%"));
	}
	
	@GetMapping("/atendimento/diario")
	public List<AtendimentoDto> listarAtendimentoDiario(
			@RequestParam(value ="unidade", required = true, defaultValue="") String unidade,
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="matricula", required = false, defaultValue="") String matricula,
			@RequestParam(value ="nome", required = false, defaultValue="") String nome) {
		
		return rs.listarAtendimentoDiario(unidade, dataInicial, dataFinal, matricula, nome);
	}
	
	@GetMapping("/atendimento/somar")
	public Object[] somar(
			@RequestParam(value ="unidade", required = true, defaultValue="") String unidade,
			@RequestParam(value ="dataInicial", required = false, defaultValue="") String dataInicial,
			@RequestParam(value ="dataFinal", required = false, defaultValue="") String dataFinal,
			@RequestParam(value ="matricula", required = false, defaultValue="") String matricula,
			@RequestParam(value ="nome", required = false, defaultValue="") String nome) {
		return rs.somarAtendementos(unidade, dataInicial, dataFinal, matricula, nome);
	}
	
	@GetMapping("/atendente/{unidade}")
	public ResponseEntity<List<AtendenteDto>> atendentes(@PathVariable("unidade") String unidade) {
		System.out.println(unidade);
		return ResponseEntity.ok(rs.listarAtendente(unidade));
	}
}
