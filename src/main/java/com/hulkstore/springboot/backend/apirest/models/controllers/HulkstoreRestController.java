package com.hulkstore.springboot.backend.apirest.models.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.springboot.backend.apirest.models.entity.Producto;
import com.hulkstore.springboot.backend.apirest.models.services.ProductoServiceImpl;

/**
 * Clase Controller
 * 
 * @author Luis Guarda
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class HulkstoreRestController {
	@Autowired
	private ProductoServiceImpl productoService;

	/**
	 * Controlador para listar productos.
	 * 
	 * @return
	 * 
	 * @author Luis Guarda
	 * 
	 */
	@GetMapping("/productos")
	public List<Producto> index() {

		return productoService.findAll();

	}

	/**
	 * Controlador para buscar productos.
	 * 
	 * @param id parametro tipo Long.
	 * @return
	 * 
	 * @author Luis Guarda
	 * 
	 */
	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return this.productoService.findById(id);
	}

	/**
	 * Controlador para registrar productos.
	 * 
	 * @param producto parametro de tipo producto.
	 * @return
	 * 
	 * @author Luis Guarda
	 */
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		producto.setFechaRegistro(new Date());
		this.productoService.save(producto);
		return producto;
	}

	/**
	 * Controlador para actualizar productos.
	 * 
	 * @param producto parametro tipo producto.
	 * @param id       parametro tipo Long.
	 * @return
	 * 
	 * @author Luis Guarda
	 */
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto currentProducto = this.productoService.findById(id);
		currentProducto.setNombreProd(producto.getNombreProd());
		currentProducto.setPrecioProd(producto.getPrecioProd());
		currentProducto.setCodigo(producto.getCodigo());
		this.productoService.save(currentProducto);
		return currentProducto;
	}

	/**
	 * Controlador para eliminar productos
	 * 
	 * @param id parametro tipo Long.
	 * 
	 * @author Luis Guarda
	 */
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Producto currentProducto = this.productoService.findById(id);
		this.productoService.delete(currentProducto);
	}

}
