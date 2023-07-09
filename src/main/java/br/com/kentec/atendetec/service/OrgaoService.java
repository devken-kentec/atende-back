package br.com.kentec.atendetec.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.kentec.atendetec.domain.Orgao;
import br.com.kentec.atendetec.repository.OrgaoRepository;

@Service
public class OrgaoService {
	
	@Autowired
	private OrgaoRepository or;
	
	public Iterable<Orgao> listarOrgao(){
		return or.findAll();
	}
	
	public Optional<Orgao> listOrgaoById(Long id) {
		return or.findById(id);
	}
	
	public Page<Orgao> listarOrgaoPage(Integer page, Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		return or.findAll(pageRequest);
	}

	public void gravar(Orgao orgao) {
		or.save(orgao);
	}

	public void alterar(Orgao orgao) {
		Optional<Orgao> o = or.findById(orgao.getId());
		if(o.isPresent()) {
			or.save(orgao);
		}
	}
	public void delete(Long id) {
		Optional<Orgao> o = this.listOrgaoById(id);
		if(o.isPresent()) {
			or.deleteById(id);
		}
	}
}
