package com.springboot.app1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.app1.domains.Producto;
import com.springboot.app1.services.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@RequestMapping("/productos")
	public String productos(Model model) {
		List<Producto> productos = productoService.buscarTodos();
		model.addAttribute("productos", productos);
		return "productos";
	}

	@RequestMapping("/insertarProducto/{id}")
	public String insertarProducto(Model model, @PathVariable("id") Long id) {
		if (id == 0) {

			model.addAttribute("producto", new Producto());
		} else {
			model.addAttribute("producto", productoService.buscarPorId(id));
		}
		return "insertarProducto";
	}

	@RequestMapping("/guardarProducto")
	public String guardarProducto(Model model, Producto producto) {

		Producto miProducto = productoService.insertarProducto(producto);
		model.addAttribute("producto", miProducto);
		return "productoRegistrado";
	}

	@RequestMapping("/eliminarProducto/{id}")
	public String BorrarProducto(Model model, @PathVariable("id") Long id) {

		productoService.borrarPorId(id);
		List<Producto> productos = productoService.buscarTodos();
		model.addAttribute("productos", productos);

		return "productos";
	}

}
