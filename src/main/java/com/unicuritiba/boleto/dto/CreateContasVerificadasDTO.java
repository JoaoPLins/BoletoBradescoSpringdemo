package com.unicuritiba.boleto.dto;

public record CreateContasVerificadasDTO(
        String nome,
        Integer agencia,
        Integer Carteira,
        Integer ContaVerificada
) {

}
