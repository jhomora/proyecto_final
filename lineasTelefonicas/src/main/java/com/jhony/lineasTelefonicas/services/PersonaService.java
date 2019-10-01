package com.jhony.lineasTelefonicas.services;

import java.util.List;

import com.jhony.lineasTelefonicas.Vo.Persona;


public interface PersonaService {

	public List<Persona> getPersonas();

	public void savePersona(Persona p);

	public Persona getPersona(Integer id);

	public void deletePersona(Integer id);
}
