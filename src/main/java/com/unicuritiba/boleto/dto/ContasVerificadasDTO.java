package com.unicuritiba.boleto.dto;

public record ContasVerificadasDTO(
        Long id,
        String nome,
        Integer agencia,
        Integer Carteira,
        Integer ContaVerificada
) {

}
