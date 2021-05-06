package com.ufcg.psoft.models;


import javax.validation.constraints.NotNull;

import com.ufcg.psoft.util.Estagio;
import lombok.Data;
import javax.persistence.*;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private String email;

    @Column(nullable = false)
    @NotNull
    private String endereco;

    @Column(nullable = false)
    @NotNull
    private String cpf;

    @Column(nullable = false)
    @NotNull
    private String cartaoSUS;

    @Column(nullable = false)
    @NotNull
    private String dataNascimento;

    @Column(nullable = false)
    @NotNull
    private String telefone;

    @Column(nullable = false)
    @NotNull
    private String profissao;

    @Column(nullable = false)
    @NotNull
    private Estagio estagio;

    public User() {
        this.estagio = Estagio.NaoHabilitado;
    }
}
