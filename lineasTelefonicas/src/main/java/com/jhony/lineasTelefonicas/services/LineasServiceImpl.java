package com.jhony.lineasTelefonicas.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhony.lineasTelefonicas.Dao.LineasDao;
import com.jhony.lineasTelefonicas.Vo.Lineas;

@Service
public class LineasServiceImpl implements LineasService{

	@Autowired
	private LineasDao miLineaDao;
	
	
	@Override
	public void saveLinea(Lineas l) {
			miLineaDao.save(l);
	}


	@Override
	@Transactional(readOnly = true)
	public Lineas getLineas(Integer id) {
		return miLineaDao.findById(id).get();
	}


	@Override
	public List<Lineas> getLineas() {
		return (List<Lineas>) miLineaDao.findAll();
	}


	@Override
	@Transactional
	public void deleteLinea(Integer id) {
		miLineaDao.deleteById(id);
	}



}



