package com.paulohenry.zup.nbdigital.utils;

public class ConfirmRegisterEntity{
  
  private String nome;   
  private String sobrenome; 
  private String cpf;     
  private String email;    
  private String nascimento;
  private String cep;
  private String bairro;
  private String rua;
  private String complemento;
  private String cidade;
  private String estado;
  private String nameImage;
  private String typeImage;
  private String message;
  private byte[] data;

  public ConfirmRegisterEntity() {
  }
  public ConfirmRegisterEntity(String message) {
    this.message=message;
  }
  public ConfirmRegisterEntity(String nome, String sobrenome, String cpf, String email, String nascimento, String cep, String bairro, String rua, String complemento, String cidade, String estado, String nameImage, String typeImage, String message, byte[] data) {
    this.message = message;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cpf = cpf;
    this.email = email;
    this.nascimento = nascimento;
    this.cep = cep;
    this.bairro = bairro;
    this.rua = rua;
    this.complemento = complemento;
    this.cidade = cidade;
    this.estado = estado;
    this.nameImage = nameImage;
    this.typeImage = typeImage;
    this.data = data;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return this.sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNascimento() {
    return this.nascimento;
  }

  public void setNascimento(String nascimento) {
    this.nascimento = nascimento;
  }

  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getRua() {
    return this.rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getComplemento() {
    return this.complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return this.estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getNameImage() {
    return this.nameImage;
  }

  public void setNameImage(String nameImage) {
    this.nameImage = nameImage;
  }

  public String getTypeImage() {
    return this.typeImage;
  }

  public void setTypeImage(String typeImage) {
    this.typeImage = typeImage;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public byte[] getData() {
    return this.data;
  }

  public void setData(byte[] data) {
    this.data = data;
  } 

  public ConfirmRegisterEntity message(String message) {
    this.message = message;
    return this;
  }  

}
   
