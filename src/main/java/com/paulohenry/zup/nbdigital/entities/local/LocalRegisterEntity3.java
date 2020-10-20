package com.paulohenry.zup.nbdigital.entities.local;


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

    public LocalRegisterEntity3() {}

    public LocalRegisterEntity3(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
      }

      public Integer getId() {
        return id;
      }
    
      public String getName() {
        return name;
      }
    
      public void setName(String name) {
        this.name = name;
      }
    
      public String getType() {
        return type;
      }
    
      public void setType(String type) {
        this.type = type;
      }
    
      public byte[] getData() {
        return data;
      }
    
      public void setData(byte[] data) {
        this.data = data;
      }

}