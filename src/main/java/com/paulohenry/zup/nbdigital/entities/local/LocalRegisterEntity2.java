package com.paulohenry.zup.nbdigital.entities.local;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



import lombok.Data;



@Entity
@Data
@Table(name="step2")
public class LocalRegisterEntity2{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @ManyToOne
    @JoinColumn(name = "id_user")
    private LocalRegisterEntity1 localRegisterEntity1; 
}
