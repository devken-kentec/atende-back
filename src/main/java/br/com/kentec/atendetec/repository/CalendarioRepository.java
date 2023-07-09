package br.com.kentec.atendetec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long>{
	
	@Query("SELECT c FROM Calendario c WHERE c.statusCalendario = 'Ativo' AND c.dia >= :hoje ORDER BY c.dia ASC ")
	public Iterable<Calendario> listarDiasAtivo(@Param("hoje") String hoje);
	
	
	@Query("SELECT c FROM Calendario c "
			+ "WHERE c.dia BETWEEN :dataInicial AND :dataFinal "
			+ "AND UPPER(c.statusCalendario) LIKE UPPER(:statusCalendario) "
			+ "AND UPPER(c.observacao) LIKE UPPER(:observacao) ")
	public List<Calendario> buscaAvancada(
			@Param("dataInicial") String dataInicial,
			@Param("dataFinal") String dataFinal, 
			@Param("statusCalendario") String statusCalendario,
			@Param("observacao") String observacao);
	
	@Query(nativeQuery=true, value="UPDATE calendario SET status_calendario = 'Inativo' WHERE dia BETWEEN (:dataInicial) AND (:dataFinal) ")
	public void inativarDias(			
			@Param("dataInicial") String dataInicial,
			@Param("dataFinal") String dataFinal);
	
}
