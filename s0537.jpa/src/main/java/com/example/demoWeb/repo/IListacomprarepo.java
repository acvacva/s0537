package com.example.demoWeb.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demoWeb.model.Producto;
import java.util.List;

public interface IListacomprarepo extends CrudRepository<Producto,Integer>{
	List<Producto> findByDescripcion(String descripcion);
	List<Producto> findByComprar(Boolean comprar);
	//List<Producto> findByTipoproducto(String tipoproducto);
	
}