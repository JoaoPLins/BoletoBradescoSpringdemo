package com.unicuritiba.boleto.services;

import com.unicuritiba.boleto.domain.repositories.ContasVerificadasRepository;
import com.unicuritiba.boleto.dto.ContasVerificadasDTO;
import com.unicuritiba.boleto.infrastructure.exceptions.NotFoundException;
import com.unicuritiba.boleto.infrastructure.mappers.ContasVerificadasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasVerificadasService {

    @Autowired
    private ContasVerificadasRepository repository;

    @Autowired
    private ContasVerificadasMapper mapper;

    public ResponseEntity<List<ContasVerificadasDTO>> getallContasVerificadas() throws NotFoundException {
        return ResponseEntity.ok(repository.findAll().stream().map(mapper::toDTO).toList());
    }

    public ResponseEntity<?> getContaVerficada(Long id) throws NotFoundException{
        return ResponseEntity.ok(repository.findById(id).stream().map(mapper::toDTO));
    }


}
