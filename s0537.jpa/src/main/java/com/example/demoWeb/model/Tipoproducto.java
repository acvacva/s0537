package com.example.demoWeb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Tipoproducto {
	
    @Id
	private int id_tipoproducto;
    
    @Column(name="tipoproducto",length=150)
    private String tipoproducto;

	@OneToMany
	@JoinColumn(name="tipoproducto_id")
	private List<Producto> productos = new ArrayList<Producto>();
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Tipoproducto [id_tipoproducto=" + id_tipoproducto + ", tipoproducto=" + tipoproducto + ", productos="
				+ productos + "]";
	}

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
