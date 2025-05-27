package com.unicuritiba.boleto.services;

import com.unicuritiba.boleto.domain.models.ContasVerificadas;
import com.unicuritiba.boleto.domain.repositories.ContasVerificadasRepository;
import com.unicuritiba.boleto.dto.ContasVerificadasDTO;
import com.unicuritiba.boleto.dto.CreateContasVerificadasDTO;
import com.unicuritiba.boleto.infrastructure.exceptions.NotFoundException;
import com.unicuritiba.boleto.infrastructure.mappers.ContasVerificadasMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ContasVerificadasService {

    @Autowired
    private ContasVerificadasRepository repository;

    @Autowired
    private ContasVerificadasMapper mapper;

    public ResponseEntity<?> cadastro(CreateContasVerificadasDTO body){
        ContasVerificadas contasVerificadas = new ContasVerificadas();
        contasVerificadas.setContaVerificada(body.ContaVerificada());
        contasVerificadas.setAgencia(body.agencia());
        contasVerificadas.setCarteira(body.Carteira());
        contasVerificadas.setNome(body.nome());
        contasVerificadas.setAlltheinfo(body.alltheinfo());

        repository.save(contasVerificadas);

        return ResponseEntity.ok("ADDED!");
    }

    public ResponseEntity<List<ContasVerificadasDTO>> getallContasVerificadas() throws NotFoundException {
        return ResponseEntity.ok(repository.findAll().stream().map(mapper::toDTO).toList());
    }

    public ResponseEntity<?> getContaVerficada(Long id) throws NotFoundException{
        return ResponseEntity.ok(repository.findById(id).stream().map(mapper::toDTO));
    }

    public ResponseEntity<?> checkTheboleto(String boleto,String Nomedobeneficiario) throws NotFoundException{
        //estes valores assumem que outra parte do codigo ja teria somente cortado a regiao que precisamos.
        // tambem assume que outra parte do banco esta fazendo a verificação do "nosso Numero"
        String agencia = boleto.substring(0,3);
        String carteira = boleto.substring(3,4);
        String conta = boleto.substring(14,20);
        log.debug("Strings formadas");
        log.debug("agencia");
        log.debug(agencia);
        log.debug("carteira");
        log.debug(carteira);
        log.debug("conta");
        log.debug(conta);
        String pt1 = boleto.substring(0,4);
        String pt2 = boleto.substring(14,20);
        log.debug("Boletos");
        log.debug(pt1);
        log.debug(pt2);
        log.debug("join");
        String info = String.join("",pt1,pt2);
        log.debug(info);
        int agenciaInt = Integer.parseInt(agencia);
        log.debug("agencia made into Integer");
        int carteiraInt = Integer.parseInt(carteira);
        log.debug("carteira made into Integer");
        int contaInt = Integer.parseInt(conta);
        log.debug("conta made into Integer");

        int infoInt = Integer.parseInt(info);
        log.debug("info made into Integer");

        Optional<ContasVerificadas> TheInformed = repository.findByAlltheinfo(infoInt);

        if(TheInformed.isEmpty()){
            return ResponseEntity.ok("esse boleto nao corresponde a conta listada");
        }

        log.debug("found");
        boolean realname = Objects.equals(TheInformed.get().getNome(), Nomedobeneficiario);
        boolean realconta = TheInformed.get().getContaVerificada() == contaInt;
        boolean realcarteira = TheInformed.get().getCarteira() == carteiraInt;
        boolean realagencia = TheInformed.get().getAgencia() == agenciaInt;
        log.debug("Boleans");


        if (realname && realconta && realcarteira && realagencia){
            return ResponseEntity.ok(TheInformed);

        }
        return ResponseEntity.ok("Dados nao batem");


    }
}
