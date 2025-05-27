package com.unicuritiba.boleto.domain.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.Setter;



@Entity
@Table(name = "contasverificadas")
@Getter
@Setter
public class ContasVerificadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome" , nullable = false)
    @NotNull(message = "o nome da instituição verificada não pode estar nulo")
    private String nome;

    @Column(name= "agencia", nullable = false)
    @NotNull(message = "agencia da conta e esperada")
    private Integer agencia;

    @Column(name="Carteira", nullable = false)
    @NotNull(message = "tambem e necessario o tipo da conta")
    private Integer carteira;

    @Column(name="conta_Verificada")
    @NotNull(message = "A conta deve existir para ser verificada")
    private Integer ContaVerificada;

    @Column(name = "alltheinfo")
    @NotNull(message = "usar pra a vida ficar mais facil. agencia -> carteira -> Conta")
    private Integer alltheinfo;






}
