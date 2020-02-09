package com.example.demoWeb.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demoWeb.model.Tipoproducto;

public interface ITipoproductorepo extends CrudRepository<Tipoproducto,Integer>{
	//List<Producto> findByDescripcion(String descripcion);
//	List<Tipoproducto> findTipoproducto(String Tipoproducto);
	//List<Tipoproducto> findByTipoproducto(String tipoproducto);
	List<Tipoproducto> findByTipoproducto(String tipoproducto);

}
