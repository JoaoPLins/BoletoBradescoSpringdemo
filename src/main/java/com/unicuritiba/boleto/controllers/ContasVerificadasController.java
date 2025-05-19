package com.unicuritiba.boleto.controllers;


import com.unicuritiba.boleto.dto.ContasVerificadasDTO;
import com.unicuritiba.boleto.dto.CreateContasVerificadasDTO;
import com.unicuritiba.boleto.infrastructure.mappers.ContasVerificadasMapper;
import com.unicuritiba.boleto.services.ContasVerificadasService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/contasverificadas")
@RequiredArgsConstructor
public class ContasVerificadasController {

    @Autowired
    private ContasVerificadasService service;

    @Autowired
    private ContasVerificadasMapper mapper;

    @PostMapping("/add")
    public ResponseEntity<?> cadastrar(@RequestBody CreateContasVerificadasDTO body){
        return ResponseEntity.ok(service.cadastro(body));
    }

    @GetMapping
    public ResponseEntity<List<ContasVerificadasDTO>> getAllContasVerificadas(){
        return ResponseEntity.ok(service.getallContasVerificadas().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEntity<?>> getContasVerificadas(@PathVariable long id){
        return ResponseEntity.ok(service.getContaVerficada(id));
    }

}
