package com.paulohenry.zup.nbdigital.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;




@Entity
@Table(name = "step3")
public class LocalRegisterEntity3 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String name;

  @Column
  private String type;

  @Lob
  private byte[] data;

  @Column(length=14, unique=true)
  private String cpf; 

    public LocalRegisterEntity3() {}

    public LocalRegisterEntity3(String name, String type, byte[] data, String cpf) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.cpf = cpf;
      }

      public Integer getId() {
        return id;
      }
      
      public String getCpf() {
        return cpf;
      }
    
      public void setCpf(String cpf) {
        this.cpf = cpf;
      }

      public String getNameImage() {
        return name;
      }
    
      public void setNameImage(String name) {
        this.name = name;
      }
    
      public String getTypeImage() {
        return type;
      }
    
      public void setTypeImage(String type) {
        this.type = type;
      }
    
      public byte[] getData() {
        return data;
      }
    
      public void setData(byte[] data) {
        this.data = data;
      }

}