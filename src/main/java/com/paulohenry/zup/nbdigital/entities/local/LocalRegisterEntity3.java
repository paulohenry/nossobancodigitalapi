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
public class LocalRegisterEntity3{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50)
    @NotNull
    private String photo;

    @Column(length=100)
    @NotNull
    
    private String cpf_user;
  
}
