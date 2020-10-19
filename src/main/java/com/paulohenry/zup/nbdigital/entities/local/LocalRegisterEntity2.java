package com.paulohenry.zup.nbdigital.entities.local;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class LocalRegisterEntity2{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
}
