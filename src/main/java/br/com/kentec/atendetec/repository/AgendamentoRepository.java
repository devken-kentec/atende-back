package br.com.kentec.atendetec.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.kentec.atendetec.domain.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
	
	@Query("SELECT a FROM Agendamento a "
			+ "JOIN a.grade g "
			+ "WHERE UPPER(g.unidade.descricao) LIKE UPPER(:unidade) "
			+ "AND g.calendario.dia BETWEEN :dataInicial AND :dataFinal "
			+ "AND UPPER(g.servico.descricao) LIKE UPPER(:servico) "
			+ "AND UPPER(a.statusAgendamento) LIKE UPPER(:statusAgendamento) ORDER BY a.horario ASC ")
	public List<Agendamento> buscaAvancada(
			@Param("unidade") String unidade,
			@Param("dataInicial") String dataInicial,
			@Param("dataFinal") String dataFinal,
			@Param("servico") String servico,
			@Param("statusAgendamento") String statusAgendamento);
	
	
	@Query("SELECT a FROM Agendamento a "
			+ "JOIN a.grade g "
			+ "WHERE UPPER(g.unidade.descricao) LIKE UPPER(:unidade) "
			+ "AND UPPER(g.calendario.dia) LIKE UPPER(:calendario) "
			+ "AND a.statusAgendamento = 'Em espera' ")
	public List<Agendamento> agendaContribuinte(
			@Param("calendario") String calendario,
			@Param("unidade") String unidade);
	
	@Query("SELECT a FROM Agendamento a "
			+ "JOIN a.contribuinte c "
			+ "WHERE UPPER(c.cpfCnpj) = UPPER(:cpfCnpj) ORDER BY a.id DESC ")
	public List<Agendamento> findByAgendamentoCpfCnpj(@Param("cpfCnpj") String cpfCnpj);
	
	
	@Query("SELECT a FROM Agendamento a "
			+ "JOIN a.contribuinte c "
			+ "WHERE UPPER(c.cpfCnpj) = UPPER(:cpfCnpj) AND a.statusAgendamento = 'Ativado'  ")
	public List<Agendamento> findByAgendamentoCpfCnpjAtivado(@Param("cpfCnpj") String cpfCnpj);
	
	@Query(nativeQuery=true, value="DELETE FROM agendamento WHERE grade_id = (:gradeId) AND aceite is NULL ")
	public void excluirAgendamento(@Param("gradeId") Long gradeId);
	
}
