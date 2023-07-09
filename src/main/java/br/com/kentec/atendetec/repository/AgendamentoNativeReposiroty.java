package br.com.kentec.atendetec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Agendamento;

@Repository
public class AgendamentoNativeReposiroty {
	
    @PersistenceContext
    private EntityManager em;
	
	@Transactional
	public void saveQueryNative(Agendamento agendamento) {
		
		em.createNativeQuery("INSERT INTO agendamento (horario, sequencial, senha, status_agendamento, grade_id) VALUES (?,?,?,?,?)")
		.setParameter(1, agendamento.getHorario())
		.setParameter(2, agendamento.getSequencial())
		.setParameter(3, agendamento.getSenha())
		.setParameter(4, agendamento.getStatusAgendamento())
		.setParameter(5, agendamento.getGrade())
		.executeUpdate();
	}

}
