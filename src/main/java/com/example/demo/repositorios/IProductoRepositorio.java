package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entidades.ProductoEntidad;

@Repository
public interface IProductoRepositorio extends PagingAndSortingRepository<ProductoEntidad, Long> {
    
    List<ProductoEntidad> findAllByOrderByIdDesc();

    ProductoEntidad FindByIdProducto(String id);

   
}
