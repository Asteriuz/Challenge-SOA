package br.com.blindspot.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blindspot.api.domain.FotoVeiculo;

@Repository
public interface FotoVeiculoRepository extends JpaRepository<FotoVeiculo, Long> {
    List<FotoVeiculo> findByVersaoId(Long versaoId);

    FotoVeiculo findByVersaoIdAndIsPrincipalTrue(Long versaoId);
}
