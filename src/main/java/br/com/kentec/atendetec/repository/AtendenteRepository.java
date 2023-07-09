package br.com.kentec.atendetec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Atendente;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long>{
	
	@Query("SELECT a FROM Atendente a "
			+ "JOIN a.acesso ac "
			+ "WHERE UPPER(ac.servidor.matricula) = UPPER(:matricula) ")
	public Optional<Atendente> findByAtendenteMatricula(@Param("matricula") String matricula);
	
	@Query("SELECT a FROM Atendente a "
			+"JOIN a.acesso ac "
			+"JOIN ac.servidor s "
			+"JOIN ac.unidade u "
			+"JOIN ac.role r "
			+"JOIN a.guiche g "
			+"WHERE  u.descricao = :unidade ")
	public List<Atendente> findAtendentes(@Param("unidade") String unidade);
}
