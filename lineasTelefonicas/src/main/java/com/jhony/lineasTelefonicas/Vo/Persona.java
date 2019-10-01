package com.jhony.lineasTelefonicas.Vo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "documento")
	private String documento;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "telefono_fijo")
	private String teleFijo;
	@Column(name = "fecha_nacimiento")
	private String fechaNaci;
	@Column(name = "celular")
	private String celular;
	
	
	public Persona() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTeleFijo() {
		return teleFijo;
	}
	public void setTeleFijo(String teleFijo) {
		this.teleFijo = teleFijo;
	}
	public String getFechaNaci() {
		return fechaNaci;
	}
	public void setFechaNaci(String fechaNaci) {
		this.fechaNaci = fechaNaci;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", teleFijo=" + teleFijo + ", fechaNaci=" + fechaNaci + "]";
	}
	
	
}
