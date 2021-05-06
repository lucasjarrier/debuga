package com.ufcg.psoft.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private String fabricante;

    @Column(nullable = false)
    @NotNull
    private Integer numeroDoses;

    @Column(nullable = false)
    @NotNull
    private Integer intervaloDoses;

}
