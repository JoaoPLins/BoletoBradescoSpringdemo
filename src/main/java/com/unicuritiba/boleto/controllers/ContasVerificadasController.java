package com.unicuritiba.boleto.controllers;


import com.unicuritiba.boleto.dto.ContasVerificadasDTO;
import com.unicuritiba.boleto.infrastructure.mappers.ContasVerificadasMapper;
import com.unicuritiba.boleto.services.ContasVerificadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ContasVerificadasController {

    @Autowired
    private ContasVerificadasService service;

    @Autowired
    private ContasVerificadasMapper mapper;

    @GetMapping
    public ResponseEntity<List<ContasVerificadasDTO>> getAllContasVerificadas(){
        return ResponseEntity.ok(service.getallContasVerificadas().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntity<?>> getContasVerificadas(@PathVariable long id){
        return ResponseEntity.ok(service.getContaVerficada(id));
    }

}
