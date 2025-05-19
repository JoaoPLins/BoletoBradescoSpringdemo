package com.unicuritiba.boleto.domain.repositories;

import com.unicuritiba.boleto.domain.models.ContasVerificadas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContasVerificadasRepository extends JpaRepository<ContasVerificadas, Long> {
    Optional <ContasVerificadas>  findByNome(String nome);
}
