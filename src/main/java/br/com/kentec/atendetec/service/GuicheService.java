package br.com.kentec.atendetec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.kentec.atendetec.domain.Guiche;
import br.com.kentec.atendetec.repository.GuicheRepository;

@Service
public class GuicheService {
	
	@Autowired
	private GuicheRepository gr;
	
	public Iterable<Guiche> listarGuiche(){
		return gr.findAll();
	}

	public Optional<Guiche> listGuicheById(Long id) {
		return gr.findById(id);
	}
	
	public Page<Guiche> listarGuiche(Integer page, Integer size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		return gr.findAll(pageRequest) ;
	}
	
	public void gravar(Guiche guiche) {
		gr.save(guiche);
	}
	
	public void alterar(Guiche guiche) {
		Optional<Guiche> g = gr.findById(guiche.getId());
		if(g.isPresent()) {
			gr.save(guiche);
		}
	}

	public void delete(Long id) {
		Optional<Guiche> g = this.listGuicheById(id);
		if(g.isPresent()) {
			gr.deleteById(id);
		}
	}
}
