package com.it.tu.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="cliente")
//@SequenceGenerator(name = "CLIENTE_ID_GENERATOR", sequenceName = "CLIENTE_SEQUENCE")
public class Cliente {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private Integer id;

	@Column(name="nome")
	@JsonProperty("nome")
	private String nome;

	public Integer getId() {
		return id;
	}

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public Cliente() {
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
