package com.jhony.lineasTelefonicas.services;

import java.util.List;

import com.jhony.lineasTelefonicas.Vo.Facturas;

public interface FacturasService {

	public Facturas getFactura(Integer id);
	
	public Facturas saveFactura(Facturas f);
	
	public Iterable<Facturas> consultarFacturas(String documento, String fecha);
	
	public List<Facturas> taerFacturas();
	
	public void deleteFactura(Integer id);
}
