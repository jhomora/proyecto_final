package com.jhony.lineasTelefonicas.services;



import java.util.List;

import com.jhony.lineasTelefonicas.Vo.Lineas;

public interface LineasService {
	
	public List<Lineas> getLineas();

	public void saveLinea(Lineas l);
	
	public Lineas getLineas(Integer id);
	
	public void deleteLinea(Integer id);
	
	
}
