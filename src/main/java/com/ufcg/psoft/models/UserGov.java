package com.ufcg.psoft.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ufcg.psoft.util.Estagio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class UserGov extends User{


    @Column
    @Id
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String cargo;

    @NotNull
    @Column(nullable = false)
    private String localTrabalho;

    @Transient
    private String cpf;

    public UserGov(User user) {
        this.setName(user.getName());
        this.setCartaoSUS(user.getCartaoSUS());
        this.setDataNascimento(user.getDataNascimento());
        this.setTelefone(user.getTelefone());
        this.setEndereco(user.getEndereco());
        this.setProfissao(user.getProfissao());
        this.setEmail(user.getEmail());
        this.setCpf(user.getCpf());
        this.setEstagio(Estagio.Finalizado);
    }

}
