package br.com.kentec.atendetec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.atendetec.domain.Mural;
import br.com.kentec.atendetec.repository.MuralRepository;

@Service
public class MuralService {
	
		@Autowired
		private MuralRepository mr;
		
		public Iterable<Mural> findByAll(){
			return mr.findAll();
		}	
		
		public Optional<Mural> findById(Long id){
			return mr.findById(id);
		}
		
		public void create(Mural mural) {
			mr.save(mural);
		}
		
		public void update(Mural mural) {
			Optional<Mural> mu = mr.findById(mural.getId());
			
			if(mu.isPresent()) {
				mr.save(mural);
			}
		}
		
		public void delete(Long id) {
		
			Optional<Mural> mu = mr.findById(id);
			
			if(mu.isPresent()) {
				mr.deleteById(id);
			}
		}
}
