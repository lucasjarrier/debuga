package com.ufcg.psoft.DTO;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class UserGovDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String cargo;

    @NotNull
    @Column(nullable = false)
    private String localTrabalho;

    @NotNull
    @Column(nullable = false)
    private String cpf;

}
