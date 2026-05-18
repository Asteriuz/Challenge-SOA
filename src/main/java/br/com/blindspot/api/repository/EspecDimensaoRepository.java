package br.com.blindspot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blindspot.api.domain.EspecDimensao;

@Repository
public interface EspecDimensaoRepository extends JpaRepository<EspecDimensao, Long> {

}
