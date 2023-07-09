package br.com.kentec.atendetec.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.atendetec.domain.Acesso;
import br.com.kentec.atendetec.domain.DetalhamentoServico;
import br.com.kentec.atendetec.domain.PerfilAtendimento;
import br.com.kentec.atendetec.dto.PerfilAtendimentoDto;
import br.com.kentec.atendetec.repository.AcessoRepository;
import br.com.kentec.atendetec.repository.DetalhamentoServicoRepository;
import br.com.kentec.atendetec.repository.PerfilAtendimentoRepository;



@Service
public class PerfilAtendimentoService {


	@Autowired
	private PerfilAtendimentoRepository par;
	
	@Autowired
	private AcessoRepository ar;
	
	@Autowired
	private DetalhamentoServicoRepository dsr;
	
	
	public Iterable<PerfilAtendimento> listarPerfilAtendimento(){
		return par.findAll();
	}
	
	public List<PerfilAtendimentoDto> listarPerfil(String matricula){
		return par.listarPerfil(matricula).stream().map(PerfilAtendimentoDto:: new).collect(Collectors.toList());
	}	
	
	public void gerarPerfil(String matricula, Long servico) {
		
		PerfilAtendimento perfilAtendimento = new PerfilAtendimento();
		
		Acesso acesso = ar.findByServidor(matricula).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Acesso não encontrado")); 
		
		DetalhamentoServico detalhamentoServico =  dsr.findById(servico).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Detalhamento não encontrado"));
		
		perfilAtendimento.setAcesso(acesso);
		
		perfilAtendimento.setDetalhamentoServico(detalhamentoServico);
		
		par.save(perfilAtendimento);
	}
	
	public void delete(Long id) {
		Optional<PerfilAtendimento> pa = par.findById(id);
		
		if(pa.isPresent()) {
			par.deleteById(id);
		}
	}

}
