package br.com.kentec.atendetec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
	
	@Query("SELECT u FROM Unidade u")
	public List<Unidade> unidadeGeral();
	
	@Query("SELECT u FROM Unidade u WHERE u.id = :unidadeId ")
	public List<Unidade> unidadeId(@Param("unidadeId") Long unidadeId);
}

