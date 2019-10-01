package com.jhony.lineasTelefonicas.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "linea_telefonica")
public class Lineas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "id_celular")
	private String id_celular;
	@Column(name = "id_persona")
	private Integer id_persona;
	@Column(name = "precio_lin")
	private double precio_lin = 34000;
	@Column(name = "estado")
	private String estado;

	public Lineas() {

	}

	public double getPrecio_lin() {
		return precio_lin;
	}

	public void setPrecio_lin(double precio_lin) {
		this.precio_lin = precio_lin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getId_celular() {
		return id_celular;
	}

	public void setId_celular(String id_celular) {
		this.id_celular = id_celular;
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
