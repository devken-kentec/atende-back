package br.com.kentec.atendetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Grade;

@Repository
public interface RelatoriosGradeRepository extends JpaRepository<Grade, Long>{
	
	
	@Query(nativeQuery=true, value="SELECT u.descricao , sum(g.quantidade) FROM grade AS g "
			+ "JOIN unidade AS u "
			+ "ON g.unidade_id = u.id "
			+ "JOIN calendario AS c "
			+ "ON c.id = g.calendario_id "
			+ "JOIN servico AS s " 
			+ "ON s.id = g.servico_id "
			+ "WHERE UPPER(u.descricao) LIKE UPPER(:unidade) "
			+ "AND c.dia BETWEEN :dataInicial AND :dataFinal "
			+ "AND UPPER(s.descricao) LIKE UPPER(:servico) "
			+ "GROUP BY u.descricao ")
	public Object[] relGradeUnidade(
			@Param("unidade") String unidade,
			@Param("dataInicial") String dataInicial,
			@Param("dataFinal") String dataFinal,
			@Param("servico") String servico); 
	
	@Query(nativeQuery=true, value="SELECT s.descricao , sum(g.quantidade) FROM grade AS g "
			+ "JOIN unidade AS u "
			+ "ON g.unidade_id = u.id "
			+ "JOIN calendario AS c "
			+ "ON c.id = g.calendario_id "
			+ "JOIN servico AS s " 
			+ "ON s.id = g.servico_id "
			+ "WHERE UPPER(u.descricao) LIKE UPPER(:unidade) "
			+ "AND c.dia BETWEEN :dataInicial AND :dataFinal "
			+ "AND UPPER(s.descricao) LIKE UPPER(:servico) "
			+ "GROUP BY s.descricao ")
	public Object[] relGradeServico(
			@Param("unidade") String unidade,
			@Param("dataInicial") String dataInicial,
			@Param("dataFinal") String dataFinal,
			@Param("servico") String servico); 
}
