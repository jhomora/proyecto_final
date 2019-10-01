package com.jhony.lineasTelefonicas.controller;

import java.util.List;

import javax.sound.sampled.Line;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jhony.lineasTelefonicas.Vo.Facturas;
import com.jhony.lineasTelefonicas.Vo.Lineas;
import com.jhony.lineasTelefonicas.Vo.Persona;
import com.jhony.lineasTelefonicas.services.FacturasService;
import com.jhony.lineasTelefonicas.services.LineasService;
import com.jhony.lineasTelefonicas.services.PersonaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class controller {
	
	@Autowired
	private PersonaService pservice;
	@Autowired
	private LineasService lService;
	@Autowired
	private FacturasService fService;
	
	//traer lista personas
	@GetMapping("/personas")
	public List<Persona> getPersonas(){
		return pservice.getPersonas();
	}
	
	//consultar persona individual
	@GetMapping("/persona/{id}")
	public Persona getPersona(@PathVariable int id) {
		Persona p = pservice.getPersona(id);
		return p;
	}
	
	//ingresar personas
	@PostMapping("/personas")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona agregarPersona(@RequestBody Persona p, Lineas l,Facturas f) {
		p.setId(null);
		pservice.savePersona(p);
		l.setId_celular(p.getCelular());
		l.setId_persona(p.getId());
		l.setEstado("Activo");
		lService.saveLinea(l);
		f.setFecha_emi_fac(p.getFechaNaci());
		f.setNum_lin_fac(l.getId_celular());
		f.setValor_fac(l.getPrecio_lin());
		fService.saveFactura(f);
		return p;
	}
	//editar
	@PutMapping("/personas")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona actualizaPersona(@RequestBody Persona p) {
		pservice.savePersona(p);
		return p;
	}
	
	//eliminar
	@DeleteMapping("/personas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarPersona(@PathVariable int id) {
		pservice.deletePersona(id);
	}
	
	///////////////////////////////////////////////////////////////
	
	//servicio de lines
	
	@GetMapping("/lineas")
	public List<Lineas> getLineas(){
		return lService.getLineas();
	}
	
	
	@PostMapping("/lineas")
	@ResponseStatus(HttpStatus.CREATED)
	public Lineas agregarLineas(@RequestBody Lineas l) {
			lService.saveLinea(l);
			return l;
	}
	
	@GetMapping("/lineas/{id}")
	public Lineas getLineas(@PathVariable Integer id) {
		Lineas l = lService.getLineas(id);
		return l;
	}
	
	@DeleteMapping("/lineas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLinea(@PathVariable Integer id) {
		lService.deleteLinea(id);
	}
	
	
	
	
	////////////////////////////////////////////////////////////////
	
	//servicio de facturas
	
	@GetMapping("/facturas")
	public List<Facturas> traerFacturas(){
		return fService.taerFacturas();
	}
	
	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public String agregarFacturas(@RequestBody Facturas f) {
		if (f != null) {
			f.setId_factura(null);
			fService.saveFactura(f);
			return "Registro exitoso";
		}
		return "fallo el registro";
	}
	
	@GetMapping("/facturas/{id}")
	public Facturas getFactura(@PathVariable int id) {
		Facturas f = fService.getFactura(id);
		return f;
	}
	
	
	@GetMapping("/facturas/{documento}/{fecha}")
	public Iterable<Facturas> traerConsulFacturas(@PathVariable String documento, String fecha){
		return fService.consultarFacturas(documento, fecha);
	}
	
	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFactura(@PathVariable Integer id) {
		fService.deleteFactura(id);
	}
	
	

}
