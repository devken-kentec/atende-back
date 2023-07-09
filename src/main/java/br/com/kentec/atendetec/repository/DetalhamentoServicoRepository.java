package br.com.kentec.atendetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.DetalhamentoServico;

@Repository
public interface DetalhamentoServicoRepository extends JpaRepository<DetalhamentoServico, Long>{
	
	@Query("SELECT ds FROM DetalhamentoServico ds "
			+ "WHERE ds.vinculo = 'Atendimento' ")
	public Iterable<DetalhamentoServico> detalheServicoAtendimento();
	
	@Query("SELECT ds FROM DetalhamentoServico ds "
			+ "WHERE ds.vinculo = 'Perfil' ")
	public Iterable<DetalhamentoServico> detalheServicoAll();
	
	@Query("SELECT ds FROM DetalhamentoServico ds "
			+ "JOIN ds.servico s "
			+ "WHERE UPPER(s.descricao) = UPPER(:servico) AND ds.vinculo = 'Perfil' ")
	public Iterable<DetalhamentoServico> selDetServico(
			@Param("servico") String servico);
}
