package com.certigroup.spring.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class Permesso implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int oreAssenza;
	private Date dataAssenza;
	private Dipendente dipendente;
	
	public Permesso() {}
	
	public Permesso(int id, int oreAssenza, Date dataAssenza, Dipendente dipendente) {
		super();
		this.id = id;
		this.oreAssenza = oreAssenza;
		this.dataAssenza = dataAssenza;
		this.dipendente = dipendente;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOreAssenza() {
		return oreAssenza;
	}
	public void setOreAssenza(int oreAssenza) {
		this.oreAssenza = oreAssenza;
	}
	public Date getDataAssenza() {
		return dataAssenza;
	}	
	@JsonSerialize(using=DateSerializer.class)
	public void setDataAssenza(Date dataAssenza) {
		this.dataAssenza = dataAssenza;
	}
	public Dipendente getDipendente() {
		return dipendente;
	}
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}

}
