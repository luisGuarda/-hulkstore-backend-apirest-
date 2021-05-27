package com.hulkstore.springboot.backend.apirest.models.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hulkstore.springboot.backend.apirest.models.dao.IProductoDao;
import com.hulkstore.springboot.backend.apirest.models.entity.Producto;
import com.hulkstore.springboot.backend.apirest.models.services.IProductoService;


/**
 * Clase repository
 * 
 * @author Luis Guarda
 *
 */
@Repository
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Producto producto) {

		productoDao.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return 
				productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Producto producto) {

		productoDao.delete(producto);
		
	}
}
