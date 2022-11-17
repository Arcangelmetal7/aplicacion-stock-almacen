package com.springboot.app1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app1.domains.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
