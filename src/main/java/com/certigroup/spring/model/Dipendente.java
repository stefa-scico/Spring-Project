package com.certigroup.spring.model;


import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Dipendente implements Serializable {
	
	private static final long serialVersionUID = 8251222167565013150L;
	
	private Integer id;
	
	private String nome;
	
	private String cognome;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataNascita;
	
	public Dipendente() {}
	
	public Dipendente(int id, String nome, String cognome, Date dataNascita) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
}
