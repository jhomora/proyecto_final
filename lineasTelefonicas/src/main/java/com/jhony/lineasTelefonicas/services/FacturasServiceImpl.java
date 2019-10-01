package com.jhony.lineasTelefonicas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhony.lineasTelefonicas.Dao.FacturasDao;
import com.jhony.lineasTelefonicas.Vo.Facturas;

@Service
public class FacturasServiceImpl implements FacturasService{

	@Autowired
	private FacturasDao fDao;

	@Override
	@Transactional(readOnly = true)
	public Facturas getFactura(Integer id) {
		return fDao.findById(id).get();
	}

	@Override
	public Facturas saveFactura(Facturas f) {
		fDao.save(f);
		return f;
	}

	@Override
	public Iterable<Facturas> consultarFacturas(String documento, String fecha) {
		return fDao.traerFacturas(documento, fecha);
	}

	@Override
	public List<Facturas> taerFacturas() {
		return (List<Facturas>) fDao.findAll();
	}

	@Override
	@Transactional
	public void deleteFactura(Integer id) {
		fDao.deleteById(id);
	}
	
	
	
	
}
