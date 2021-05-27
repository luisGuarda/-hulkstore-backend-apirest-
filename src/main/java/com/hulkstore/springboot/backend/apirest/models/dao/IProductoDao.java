package com.hulkstore.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hulkstore.springboot.backend.apirest.models.entity.Producto;

/**
 * Clase Dao
 * 
 * @author Luis Guarda
 *
 */
public interface IProductoDao extends CrudRepository<Producto, Long>{

}
