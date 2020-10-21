package com.paulohenry.zup.nbdigital.entities;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;


import com.paulohenry.zup.nbdigital.validation.ValidationAge;


import org.hibernate.validator.constraints.br.CPF;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter
@Setter
@Entity
@Table(name="step1")
public class LocalRegisterEntity1{
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50)
    @NotNull(message="{campo.cpf.obrigatorio}")
    private String nome;

    @Column(length=100)
    @NotNull(message="{campo.cpf.obrigatorio}")
    private String sobrenome;



    @Column(length=14, unique=true)
    @NotNull(message="{campo.cpf.obrigatorio}")
    @CPF(message="{campo.cpf.invalido}")
    private String cpf; 

    

    @Column(length=100, unique=true)
    @Email(message="{campo.email.invalido}")
    @NotNull(message="{campo.email.obrigatorio}")
    private String email;

    @Column(length=10)
    @ValidationAge(message="{campo.nascimento.idade}")
    @NotNull(message="{campo.nascimento.obrigatorio}")
    private String nascimento;
    
    @Column()
    private Boolean confirm;

    @PrePersist
    protected void confirmFalseFirst(){
         setConfirm(false);
    }
    
}
