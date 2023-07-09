package br.com.kentec.atendetec.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Painel02;

@Repository
public interface Painel02Repository extends JpaRepository<Painel02, Long>{
	
	 @Query("FROM Painel02 WHERE fila_id = (:filaId) ")
	 public Optional<Painel02> findByFilaId(@Param("filaId") Long filaId);
	 
	 @Query(nativeQuery =true, value ="SELECT TOP 5 * FROM Painel_02 WHERE chamada > (:chamada) ORDER BY chamada DESC ")
	 public Iterable<Painel02> findByfive(@Param("chamada") LocalDateTime chamada);
	 
	 @Query("FROM Painel02 WHERE chamada = (SELECT MAX(chamada) FROM Painel02) ")
	 public Optional<Painel02> findByChamada();

}
