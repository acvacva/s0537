package com.example.demoWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tipoproducto {
	
    @Id
	private int id_tipoproducto;
    
    @Column(name="tipoproducto",length=150)
    private String tipoproducto;

	public int getId_tipoproducto() {
		return id_tipoproducto;
	}

	public void setId_tipoproducto(int id_tipoproducto) {
		this.id_tipoproducto = id_tipoproducto;
	}


	public String getTipoproducto() {
		return tipoproducto;
	}

	public void setTipoproducto(String tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

}
