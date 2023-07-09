package br.com.kentec.atendetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
