package br.com.kentec.atendetec.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kentec.atendetec.domain.Contribuinte;
import br.com.kentec.atendetec.repository.ContribuinteRepository;

@Service
public class ContribuinteService {
	
	Contribuinte vaidaContribuinte;
	
	@Autowired
	private ContribuinteRepository cr;
	
	
	public Iterable<Contribuinte> listarContribuinte(){
			return cr.findAll();
	}
	
	public Optional<Contribuinte> contribuinteById(Long id){
		return cr.findById(id);
	}
	
	public List<Contribuinte> buscaAvancada(String nome, String cpfCnpj){
		return cr.findByNomeCpfCnpj(nome, cpfCnpj);
	}
	
	public Contribuinte login(String cpfCnpj, String senha) {	
		
		Contribuinte c = cr.findByLogin(cpfCnpj, senha);
		
		if(c.getCpfCnpj().equals(cpfCnpj) && c.getSenha().equals(senha)) {
			this.vaidaContribuinte = c;
		}
		return c;
	}
	
	public void gravar(Contribuinte contribuinte) {
		cr.save(contribuinte);
	}
	
	public void alterar(Contribuinte contribuinte) {
		Optional<Contribuinte> c = cr.findById(contribuinte.getId());
		if(c.isPresent()) {
			cr.save(contribuinte);
		}
	}
	
	public void alterarSenha(String cpfCnpj, String senha, String novaSenha, String confirmarNovaSenha) {
		
		Contribuinte c = cr.findByLogin(cpfCnpj, senha);
		
		if(c.getCpfCnpj().equals(cpfCnpj) && c.getSenha().equals(senha)) {
			if(novaSenha.equals(confirmarNovaSenha)) {
				c.setSenha(novaSenha);
				cr.save(c);
			}
		}
	}
}
