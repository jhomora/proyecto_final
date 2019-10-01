package com.jhony.lineasTelefonicas.Vo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facturas")
public class Facturas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private Integer id_factura;
	@Column(name = "num_lin_fac")
	private String num_lin_fac;
	@Column(name = "fecha_emi_fac")
	private String fecha_emi_fac;
	@Column(name = "valor_fac")
	private double valor_fac;
	
	public Facturas() {
		
	}
	public Integer getId_factura() {
		return id_factura;
	}
	public void setId_factura(Integer id_factura) {
		this.id_factura = id_factura;
	}
	public String getNum_lin_fac() {
		return num_lin_fac;
	}
	public void setNum_lin_fac(String num_lin_fac) {
		this.num_lin_fac = num_lin_fac;
	}
	public String getFecha_emi_fac() {
		return fecha_emi_fac;
	}
	public void setFecha_emi_fac(String fecha_emi_fac) {
		this.fecha_emi_fac = fecha_emi_fac;
	}
	public double getValor_fac() {
		return valor_fac;
	}
	public void setValor_fac(double valor_fac) {
		this.valor_fac = valor_fac;
	}
	@Override
	public String toString() {
		return "Facturas [id_factura=" + id_factura + ", num_lin_fac=" + num_lin_fac + ", fecha_emi_fac="
				+ fecha_emi_fac + ", valor_fac=" + valor_fac + "]";
	}
}
