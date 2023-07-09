package br.com.kentec.atendetec.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Painel05;

@Repository
public interface Painel05Repository extends JpaRepository<Painel05, Long>{
	
	 @Query("FROM Painel05 WHERE fila_id = (:filaId) ")
	 public Optional<Painel05> findByFilaId(@Param("filaId") Long filaId);
	 
	 @Query(nativeQuery=true, value ="SELECT TOP 5 * FROM Painel_05 WHERE chamada > (:chamada) ORDER BY chamada DESC ")
	 public Iterable<Painel05> findByfive(@Param("chamada") LocalDateTime chamada);
	 
	 @Query("FROM Painel05 WHERE chamada = (SELECT MAX(chamada) FROM Painel05) ")
	 public Optional<Painel05> findByChamada();

}