package br.com.kentec.atendetec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Acesso;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Long>{
	
	@Query("FROM Acesso WHERE UPPER(servidor) = UPPER(:matricula)")
	public Optional<Acesso> findByServidor(@Param("matricula") String matricula);
	
	
	@Query("SELECT a FROM Acesso a "
			+ "JOIN a.servidor s "
			+ "WHERE UPPER(s.matricula) = UPPER(:matricula) AND UPPER(a.senha) = UPPER(:senha)")
	public Acesso logar(@Param("matricula") String matricula, @Param("senha") String senha);
}
