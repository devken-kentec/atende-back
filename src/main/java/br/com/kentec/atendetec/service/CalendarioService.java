package br.com.kentec.atendetec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.atendetec.domain.Calendario;
import br.com.kentec.atendetec.repository.CalendarioRepository;

@Service
public class CalendarioService {
	
	@Autowired
	private CalendarioRepository cr;
	
	@Autowired
	private DataService ds;

	public Iterable<Calendario> listarDiasAtivos(){
		String hoje = ds.dataHoje().toString();
		return cr.listarDiasAtivo(hoje);
	}
	
	public List<Calendario> pesquisaAvancada(String dataInicial, String dataFinal, String statusCalendario, String observacao){
		return cr.buscaAvancada(dataInicial, dataFinal, statusCalendario, observacao);
	}
	
	public Iterable<Calendario> listarCalendario(){
		return cr.findAll();
	}
	
	public Optional<Calendario> listCalendarioById(Long id){
		return cr.findById(id);
	}
	
	public void inativarDias(String dataInicial, String dataFinal) {
		cr.inativarDias(dataInicial, dataFinal);
	}
	
	public void gravar(Calendario calendario) {
		cr.save(calendario);
	}
	
	public void alterar(Calendario calendario) {
		Optional<Calendario> c = cr.findById(calendario.getId());
		if(c.isPresent()) {
			cr.save(calendario);
		}
	}
	
	public void delete(Long id) {
		Optional<Calendario> c = this.listCalendarioById(id);
		if(c.isPresent()) {
			cr.deleteById(id);
		}
	}
}
