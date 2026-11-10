package com.fiap.mecatronica.estacaoapi.repository;

import com.fiap.mecatronica.estacaoapi.model.Estacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacaoRepository extends JpaRepository<Estacao, Long> {
}