package br.com.kentec.atendetec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.kentec.atendetec.domain.Orgao;
import br.com.kentec.atendetec.domain.Servico;
import br.com.kentec.atendetec.repository.OrgaoRepository;
import br.com.kentec.atendetec.repository.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository sr;
	
	@Autowired
	private OrgaoRepository or;
	
	public Iterable<Servico> listarServico(){
		return sr.findAll();
	}
	
	public Optional<Servico> listarServicoById(Long id){
		return sr.findById(id);
	}
	
	public Page<Servico> listarServico(Integer page, Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		return sr.findAll(pageRequest) ;
	}
	
	public void gravar(Servico servico) {
		Orgao orgao = or.findById(servico.getOrgao().getId()).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Orgão não Encontrado"));
		servico.setOrgao(orgao);
		
		sr.save(servico);
	}
	
	public void alterar(Servico servico) {
		Optional<Servico> s = sr.findById(servico.getId());
		
		Orgao orgao = or.findById(servico.getOrgao().getId()).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Orgão não Encontrado"));
		
		servico.setOrgao(orgao);
		
		
		if(s.isPresent()) {
			sr.save(servico);
		}
		
	}
}
