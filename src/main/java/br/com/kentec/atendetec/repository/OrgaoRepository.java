package br.com.kentec.atendetec.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Orgao;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Long> {

}
