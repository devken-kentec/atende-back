package br.com.kentec.atendetec.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
	
	@Query("SELECT a FROM Atendimento a "
			+"JOIN a.detalhamentoServico ds "
			+"JOIN a.fila f "
			+"JOIN f.atendente at "
			+"JOIN at.acesso ac "
			+"JOIN ac.servidor s "
			+"WHERE a.realizado BETWEEN :dataInicial AND :dataFinal "
			+"AND UPPER(f.unidade) = UPPER(:unidade) "
			+"AND UPPER(s.matricula) LIKE UPPER(:matricula) "
			+"AND UPPER(s.nome) LIKE UPPER(:nome) ")
	public List<Atendimento> atendimentos(
							@Param("unidade") String unidade,
							@Param("dataInicial") String dataInicial,
							@Param("dataFinal") String dataFinal,
							@Param("matricula") String matricula,
							@Param("nome") String nome);
	
	@Query("SELECT COUNT(a) FROM Atendimento a "
			+"JOIN a.detalhamentoServico ds "
			+"JOIN a.fila f "
			+"JOIN f.atendente at "
			+"JOIN at.acesso ac "
			+"JOIN ac.servidor s "
			+"WHERE a.realizado BETWEEN :dataInicial AND :dataFinal "
			+"AND UPPER(f.unidade) = UPPER(:unidade) "
			+"AND UPPER(s.matricula) LIKE UPPER(:matricula) "
			+"AND UPPER(s.nome) LIKE UPPER(:nome) ")
	public Object[] somarAtendimentos(
							@Param("unidade") String unidade,
							@Param("dataInicial") String dataInicial,
							@Param("dataFinal") String dataFinal,
							@Param("matricula") String matricula,
							@Param("nome") String nome);
	
	

	
	
}
