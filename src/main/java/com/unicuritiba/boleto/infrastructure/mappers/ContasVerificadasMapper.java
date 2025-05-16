package com.unicuritiba.boleto.infrastructure.mappers;

import com.unicuritiba.boleto.domain.models.ContasVerificadas;
import com.unicuritiba.boleto.dto.ContasVerificadasDTO;
import org.springframework.stereotype.Component;

@Component
public class ContasVerificadasMapper {

    public ContasVerificadasDTO toDTO(ContasVerificadas u){
        return new ContasVerificadasDTO(
                u.getId(),
                u.getNome(),
                u.getAgencia(),
                u.getCarteira(),
                u.getContaVerificada()
        );
    }

    public ContasVerificadas toEntity(ContasVerificadasDTO dto){
        ContasVerificadas contasverificadas = new ContasVerificadas();
        contasverificadas.setId(dto.id());
        contasverificadas.setNome(dto.nome());
        contasverificadas.setAgencia(dto.agencia());
        contasverificadas.setCarteira(dto.Carteira());
        contasverificadas.setContaVerificada(dto.ContaVerificada());
        return contasverificadas;
    }
}
