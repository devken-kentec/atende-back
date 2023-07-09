package br.com.kentec.atendetec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.atendetec.domain.Mural;

@Repository
public interface MuralRepository extends JpaRepository<Mural, Long> {

}
