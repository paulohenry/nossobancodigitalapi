package com.paulohenry.zup.nbdigital.entities.userentity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.br.CPF;
import lombok.Data;


@Entity
@Data
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50)
    @NotNull
    private String nome;

    @Column(length=100)
    @NotNull
    private String sobrenome;

    @Column(length=14, unique=true)
    @NotNull
    @CPF
    private String cpf; 

    @Column(length=100, unique=true)
    @Email
    @NotNull
    private String email;

    @Column(length=10)
    @NotNull
    private String nascimento;

    @Column(length=5)
    @NotNull
    private String cep;

    @Column(length=50)
    @NotNull
    private String bairro;

    @Column(length=50)
    @NotNull
    private String complemento;

    @Column(length=50)
    @NotNull
    private String cidade;

    @Column(length=50)
    @NotNull
    private String estado;

    @Column(length=244)
    @NotNull
    private String foto;
}
