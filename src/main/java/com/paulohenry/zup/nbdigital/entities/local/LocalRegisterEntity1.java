package com.paulohenry.zup.nbdigital.entities.local;



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
public class LocalRegisterEntity1{

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

    @Column(nullable=true, length=10)
    @NotNull
    private String nascimento;
}
