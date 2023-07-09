package br.com.kentec.atendetec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Servidor;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, String> {
	
	@Query("FROM Servidor WHERE UPPER(matricula) LIKE UPPER(:matricula)"
			+ "AND UPPER(nome) LIKE UPPER(:nome) AND UPPER(cpf) LIKE UPPER(:cpf)")
	public List<Servidor> findByMatriculaNomeCpf(
			@Param("matricula") String matricula,
			@Param("nome") String nome,
			@Param("cpf") String cpf);
	
	@Query("FROM Servidor WHERE UPPER(matricula) = UPPER(:matricula)")
	public Optional<Servidor> findByMatricula(@Param("matricula") String matricula);
	
}
