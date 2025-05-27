package com.unicuritiba.boleto.controllers;

import com.unicuritiba.boleto.dto.NumerodoBoletoDTO;
import com.unicuritiba.boleto.services.ContasVerificadasService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verificar")
@RequiredArgsConstructor
public class VerificarBoletoController {

    @Autowired
    private ContasVerificadasService service;

    @PostMapping()
    public ResponseEntity <?> enviarDado(@RequestBody NumerodoBoletoDTO body){
        return ResponseEntity.ok(service.checkTheboleto(body.numeroBoleto() ,body.nomeDoBeneficiario()));
    }


}
