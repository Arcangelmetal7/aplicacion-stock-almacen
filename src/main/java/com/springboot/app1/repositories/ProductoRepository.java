package com.springboot.app1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app1.domains.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByNombreEquals(String nombre);

}
