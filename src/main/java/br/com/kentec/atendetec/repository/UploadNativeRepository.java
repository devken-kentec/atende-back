package br.com.kentec.atendetec.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import br.com.kentec.atendetec.domain.Calendario;
import br.com.kentec.atendetec.domain.Orgao;
import br.com.kentec.atendetec.domain.Servidor;
import br.com.kentec.atendetec.domain.Unidade;

@Repository
public class UploadNativeRepository {
	
	  @PersistenceContext
	    private EntityManager em;
		
		@Transactional
		public void saveQueryNativeCalendario(Calendario calendario) {
			
			em.createNativeQuery("INSERT INTO calendario (dia, observacao, status_calendario) VALUES (?,?,?)")
			.setParameter(1, calendario.getDia())
			.setParameter(2, calendario.getObservacao())
			.setParameter(3, calendario.getStatusCalendario())
			.executeUpdate();
		}
		
		@Transactional
		public void saveQueryNativeGrade(String[] celulas) {
			
			em.createNativeQuery("INSERT INTO grade (configurado, corr_hora, gerado, hora_final, hora_incial, intervalo, quantidade, calendario_id,"
					+ " servico_id, unidade_id) VALUES (?,?,?,?,?,?,?,?,?,?)")
			.setParameter(1, celulas[0])
			.setParameter(2, Integer.parseInt(celulas[1]))
			.setParameter(3, celulas[2])
			.setParameter(4, celulas[3])
			.setParameter(5, celulas[4])
			.setParameter(6, Integer.parseInt(celulas[5]))
			.setParameter(7, Integer.parseInt(celulas[6]))
			.setParameter(8, Integer.parseInt(celulas[7]))
			.setParameter(9, Integer.parseInt(celulas[8]))
			.setParameter(10,Integer.parseInt(celulas[9]))
			.executeUpdate();
		}
		
		@Transactional
		public void saveQueryNativeServico(String[] celulas) {
			
			em.createNativeQuery("INSERT INTO servico (descricao, sigla, orgao_id) VALUES (?,?,? )")
			.setParameter(1, celulas[0])
			.setParameter(2, celulas[1])
			.setParameter(3, Integer.parseInt(celulas[2]))
			.executeUpdate();
		}
		
		@Transactional
		public void saveQueryNativeDetalheServico(String[] celulas) {
			
			em.createNativeQuery("INSERT INTO detalhamento_servico (descricao, detalhamento, servico_id) VALUES (?,?,? )")
			.setParameter(1, celulas[0])
			.setParameter(2, celulas[1])
			.setParameter(3, Integer.parseInt(celulas[2]))
			.executeUpdate();
		}
		
		@Transactional
		public void saveQueryNativeUnidade(Unidade unidade) {
			
			em.createNativeQuery("INSERT INTO unidade (codigo, descricao, endereco, sigla, telefone) VALUES (?,?,?,?,?)")
			.setParameter(1, unidade.getCodigo())
			.setParameter(2, unidade.getDescricao())
			.setParameter(3, unidade.getEndereco())
			.setParameter(4, unidade.getSigla())
			.setParameter(5, unidade.getTelefone())
			.executeUpdate();
		}
		
		@Transactional
		public void saveQueryNativeOrgao(Orgao orgao) {
			
			em.createNativeQuery("INSERT INTO orgao (codigo, descricao, sigla) VALUES (?,?,?)")
			.setParameter(1, orgao.getCodigo())
			.setParameter(2, orgao.getDescricao())
			.setParameter(3, orgao.getSigla())
			.executeUpdate();
		}
		
		@Transactional
		public void saveQueryNativeServidor(Servidor servidor) {
			
			em.createNativeQuery("INSERT INTO servidor (id, cpf, email, lotacao, nome, status_servidor, telefone) VALUES (?,?,?,?,?,?,?)")
			.setParameter(1, servidor.getMatricula())
			.setParameter(2, servidor.getCpf())
			.setParameter(3, servidor.getEmail())
			.setParameter(4, servidor.getLotacao())
			.setParameter(5, servidor.getNome())
			.setParameter(6, servidor.getStatusServidor())
			.setParameter(7, servidor.getTelefone())
			.executeUpdate();
		}
}
