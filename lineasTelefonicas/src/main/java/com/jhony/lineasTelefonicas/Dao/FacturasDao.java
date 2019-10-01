package com.jhony.lineasTelefonicas.Dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jhony.lineasTelefonicas.Vo.Facturas;

@Transactional
public interface FacturasDao extends CrudRepository<Facturas, Integer>{

	@Query(value = "select p.nombre, p.apellido, p.documento, f.num_lin_fac as numero_linea \n" + 
			"from (personas p join linea_telefonica l on p.celular = l.id_celular)join facturas f on f.num_lin_fac = l.id_celular\n" + 
			"where p.documento = :documento and f.fecha_emi_fac = :fecha", nativeQuery = true)
	public Iterable<Facturas> traerFacturas(String documento, String fecha );
	
}
