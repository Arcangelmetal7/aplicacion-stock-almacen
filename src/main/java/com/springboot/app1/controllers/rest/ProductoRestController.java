package com.springboot.app1.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app1.domains.Producto;
import com.springboot.app1.services.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/{id}")
	public Producto buscarPorId(@PathVariable Long id) {
		Producto producto = productoService.buscarPorId(id);

		return producto;
	}
}
