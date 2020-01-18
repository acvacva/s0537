package com.example.demoWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto {

    @Id

	private int id_producto;
    
    @Column(name="nombre_producto",length=150)
    private String nombre_producto;
    
	@Column(name="descripcion",length=200)
    private String descripcion;
    
  @Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre_producto=" + nombre_producto + ", descripcion="
				+ descripcion + ", comprar=" + comprar + ", tipoproducto=" + tipoproducto + "]";
	}


	@Column(name="comprar")
    private Boolean comprar;
    
    @Column(name="tipoproducto",length=200)
    private String tipoproducto;
    
    public String getTipoproducto() {
		return tipoproducto;
	}

	public void setTipoproducto(String tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getComprar() {
		return comprar;
	}

	public void setComprar(Boolean comprar) {
		this.comprar = comprar;
	}

   
	public Producto () {
		
	}
}
