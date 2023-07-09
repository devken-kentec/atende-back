package br.com.kentec.atendetec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.kentec.atendetec.domain.DetalhamentoServico;
import br.com.kentec.atendetec.domain.Servico;
import br.com.kentec.atendetec.repository.DetalhamentoServicoRepository;
import br.com.kentec.atendetec.repository.ServicoRepository;

@Service
public class DetalhamentoServicoService {
	
	@Autowired
	private DetalhamentoServicoRepository dsr;
	
	@Autowired
	private ServicoRepository sr;
	
	public Iterable<DetalhamentoServico> listarServicoAtendimento(){
		return dsr.detalheServicoAtendimento();
	}
	
	public Iterable<DetalhamentoServico> listarServico(){
		return dsr.detalheServicoAll();
	}
	
	public Iterable<DetalhamentoServico> selectDetServico(String servico){
		return dsr.selDetServico(servico);
	}
	
	public Optional<DetalhamentoServico> listarDetServicoById(Long id){
		return dsr.findById(id);
	}
	
	public Page<DetalhamentoServico> listarDetServico(Integer page, Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		return dsr.findAll(pageRequest) ;
	}
	
	public void gravar(DetalhamentoServico detServico) {
		
		Servico servico = sr.findById(detServico.getServico().getId()).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Serviço não Encontrado"));
		
		detServico.setServico(servico);
		
		dsr.save(detServico);
		
	}
	
	public void alterar(DetalhamentoServico detServico) {
		Servico servico = sr.findById(detServico.getServico().getId()).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Serviço não Encontrado"));
		
		detServico.setServico(servico);
		
		dsr.save(detServico);
	}
}
