package br.com.kentec.atendetec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
	
	@Query("SELECT g FROM Grade g "
			+ "JOIN g.unidade u "
			+ "JOIN g.servico s "
			+ "JOIN g.calendario c "
			+ "WHERE UPPER(u.descricao) = UPPER(:unidade) "
			+ "AND c.dia BETWEEN :dataInicial AND :dataFinal "
			+ "AND UPPER(s.descricao) LIKE UPPER(:servico) ORDER BY c.dia ASC ")
	public List<Grade> buscaAvancada(
			@Param("unidade") String unidade,
			@Param("dataInicial") String dataInicial,
			@Param("dataFinal") String dataFinal,
			@Param("servico") String servico);
}
