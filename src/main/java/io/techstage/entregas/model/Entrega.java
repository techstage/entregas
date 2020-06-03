package io.techstage.entregas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Entrega {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
  Long transacao;
  Double valor;
	Long cliente;
	String nome;
  String email;
  Long pedido;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTransacao() {
    return transacao;
  }

  public void setTransacao(Long transacao) {
    this.transacao = transacao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Long getCliente() {
    return cliente;
  }

  public void setCliente(Long cliente) {
    this.cliente = cliente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getPedido() {
    return pedido;
  }

  public void setPedido(Long pedido) {
    this.pedido = pedido;
  }

}