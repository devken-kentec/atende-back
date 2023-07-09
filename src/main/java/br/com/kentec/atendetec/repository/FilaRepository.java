package br.com.kentec.atendetec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Fila;

@Repository
public interface FilaRepository extends JpaRepository<Fila, Long> {
	
	@Query("FROM Fila WHERE data = (:data) AND statusFila = 'Aguardando' AND unidade = (:unidade) ")
	public Iterable<Fila> listarFilaAtivados(@Param("data") String data,
											 @Param("unidade") String unidade);
	
	@Query(nativeQuery=true, value ="SELECT * FROM fila as f WHERE f.data = (:data) AND f.status_Fila = 'Aguardando' "
					+ "AND unidade = (:unidade) "
					+ "AND f.detalhamento_Servico IN (SELECT ds.descricao FROM perfil_atendimento AS pa "
					+ "JOIN acesso AS a " 
					+ "ON a.id = pa.acesso_id "
					+ "JOIN detalhamento_servico AS ds "
					+ "ON ds.id = pa.detalhe_servico_id "
					+ "WHERE a.servidor_id = (:matricula)) ")
	public List<Fila> listarFilaEspera(@Param("data") String data, 
									   @Param("matricula") String matricula,
									   @Param("unidade") String unidade);
	
	@Query("SELECT f FROM Fila f WHERE f.identificador = :identificador AND f.statusAgendamento != 'Finalizado' ")
	public List<Fila> findByIdentificador(@Param("identificador") Long identificador);
	
	@Query(nativeQuery=true, value ="SELECT * FROM fila as f WHERE f.identificador IN (SELECT a.id FROM agendamento AS a "  
					+ "JOIN contribuinte AS c " 
			        + "ON c.id = a.contribuinte_id "  
			        + "WHERE c.cpf_cnpj = (:cpfCnpj)) AND f.status_agendamento <> 'Finalizado'" )
	public List<Fila> findByFilaAgendamentoCpfCnpj(@Param("cpfCnpj") String cpfCnpj);
	
	
	@Query("SELECT f FROM Fila f WHERE f.statusFila = 'Finalizado' ")
	public List<Fila> findByFinalizado();
	
	@Query("SELECT f FROM Fila f WHERE f.id = :identificador AND statusFila = 'Finalizado' ")
	public Optional<Fila> findByFilaFinalizado(@Param("identificador") Long identificador);
	
	@Query(nativeQuery=true, value="SELECT COUNT(*) FROM fila WHERE cpf_cnpj = (:cpfCnpj) AND  avaliacao is null AND status_fila = 'Finalizado' ")
	public Object[] contarAvaliacao(@Param("cpfCnpj") String cpfCnpj);
}
