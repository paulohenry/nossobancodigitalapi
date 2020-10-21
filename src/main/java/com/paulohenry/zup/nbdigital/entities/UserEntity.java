package com.paulohenry.zup.nbdigital.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.paulohenry.zup.nbdigital.validation.ValidationAge;

import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter@Setter
@Entity
@Table(name = "user_table")
public class UserEntity{
  
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

  @Column(length=9)
  @Pattern(regexp="(\\d{5}-\\d{3})$", message="{campo.cep.invalido}")
  @NotNull(message="{campo.cep.obrigatorio}")
  private String cep;

  @Column(length=50)
  @NotNull(message="{campo.bairro.obrigatorio}")
  private String bairro;

  @Column(length=150)
  @NotNull(message="{campo.rua.obrigatorio}")
  private String rua;

  @Column(length=50)
  @NotNull(message="{campo.complemento.obrigatorio}")
  private String complemento;

  @Column(length=50)
  @NotNull(message="{campo.cidade.obrigatorio}")
  private String cidade;

  @Column(length=50)
  @NotNull(message="{campo.estado.obrigatorio}")
  private String estado;

  @Column
  private String name;

  @Column
  private String type;

  @Lob
  private byte[] data;

}
   
