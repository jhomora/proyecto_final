package com.jhony.lineasTelefonicas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhony.lineasTelefonicas.Dao.PersonaDao;
import com.jhony.lineasTelefonicas.Vo.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaDao miDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> getPersonas() {
		return (List<Persona>) miDao.findAll();
	}

	@Override
	public void savePersona(Persona p) {
		miDao.save(p);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona getPersona(Integer id) {
		return miDao.findById(id).get();
	}

	@Override
	@Transactional
	public void deletePersona(Integer id) {
		miDao.deleteById(id);
	}

}
