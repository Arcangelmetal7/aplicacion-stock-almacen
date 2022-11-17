package com.springboot.app1.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app1.domains.Producto;
import com.springboot.app1.repositories.ProductoRepository;

@Service
@Transactional
public class ProductoService {

	private ProductoRepository productoRepository;

	public ProductoService(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	public List<Producto> buscarTodos() {
		return productoRepository.findAll();
	}

	public Producto insertarProducto(Producto producto) {

		return productoRepository.save(producto);
	}

	public Producto buscarPorId(Long id) {

		return productoRepository.findById(id).orElse(null);

	}

	public void borrarPorId(Long id) {
		productoRepository.deleteById(id);
	}

	public List<Producto> buscarPorNombre(String nombre) {

		return productoRepository.findByNombreEquals(nombre);
	}

}
