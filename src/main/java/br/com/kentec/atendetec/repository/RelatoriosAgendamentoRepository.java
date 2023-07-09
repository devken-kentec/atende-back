package br.com.kentec.atendetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Agendamento;

@Repository
public interface RelatoriosAgendamentoRepository extends JpaRepository<Agendamento, Long>{
	
	@Query(nativeQuery=true, value="SELECT u.descricao, COUNT(*) AS quant  FROM agendamento AS a " 
				+ "JOIN grade AS gr "  
				+ "ON a.grade_id = gr.id "  
				+ "JOIN servico AS s "  
				+ "ON gr.servico_id = s.id "  
				+ "JOIN unidade AS u "  
				+ "ON gr.unidade_id = u.id "  
				+ "JOIN calendario AS c "
				+ "ON c.id = gr.calendario_id "
				+ "WHERE UPPER(u.descricao) LIKE UPPER(:unidade) "
				+ "AND c.dia BETWEEN :dataInicial AND :dataFinal "
				+ "AND UPPER(s.descricao) LIKE UPPER(:servico) "
				+ "AND UPPER(a.status_agendamento) LIKE UPPER(:statusAgendamento) "
				+ "GROUP BY u.descricao  ")
	public Object[] relAgendUnidade(
					@Param("unidade") String unidade,
					@Param("dataInicial") String dataInicial,
					@Param("dataFinal") String dataFinal,
					@Param("servico") String servico,
					@Param("statusAgendamento") String statusAgendamento);
	
	@Query(nativeQuery=true, value="SELECT s.descricao, COUNT(*) AS quant  FROM agendamento AS a " 
			+ "JOIN grade AS gr "  
			+ "ON a.grade_id = gr.id "  
			+ "JOIN servico AS s "  
			+ "ON gr.servico_id = s.id "  
			+ "JOIN unidade AS u "  
			+ "ON gr.unidade_id = u.id "  
			+ "JOIN calendario AS c "
			+ "ON c.id = gr.calendario_id "
			+ "WHERE UPPER(u.descricao) LIKE UPPER(:unidade) "
			+ "AND c.dia BETWEEN :dataInicial AND :dataFinal "
			+ "AND UPPER(s.descricao) LIKE UPPER(:servico) "
			+ "AND UPPER(a.status_agendamento) LIKE UPPER(:statusAgendamento) "
			+ "GROUP BY s.descricao  ")
	public Object[] relAgendServico(
					@Param("unidade") String unidade,
					@Param("dataInicial") String dataInicial,
					@Param("dataFinal") String dataFinal,
					@Param("servico") String servico,
					@Param("statusAgendamento") String statusAgendamento);
}
