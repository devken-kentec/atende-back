package br.com.kentec.atendetec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.atendetec.domain.Servidor;
import br.com.kentec.atendetec.repository.ServidorRepository;

@Service
public class ServidorService {
	
	@Autowired
	private ServidorRepository sr;
	
	public Iterable<Servidor> listarServidor(){
		return sr.findAll();
	}
	
	public Optional<Servidor> findByMatricula(String matricula){
		return sr.findByMatricula(matricula);
	}
	
	public List<Servidor> buscaAvancada(String matricula, String nome, String cpf){
		return sr.findByMatriculaNomeCpf(matricula, nome, cpf);
	}
	
	public void mudarSattus(String matricula) {
		Servidor servidor = sr.findByMatricula(matricula).orElseThrow(()->
				new ResponseStatusException(HttpStatus.BAD_REQUEST, "Servidor não encontrado"));
		
		servidor.setStatusServidor("Inativo");
		sr.save(servidor);
	}
	
	public void gravar(Servidor servidor) {
		sr.save(servidor);
	}
	
	public void alterar(Servidor servidor) {
		Optional<Servidor> s = sr.findByMatricula(servidor.getMatricula());
		
		if(s.isPresent()) {
			sr.save(servidor);
		}
	}
	
}


