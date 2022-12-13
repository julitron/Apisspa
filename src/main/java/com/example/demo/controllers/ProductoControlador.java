package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entidades.ProductoEntidad;
import com.example.demo.models.peticiones.ProductoActualizarReqModelo;
import com.example.demo.models.peticiones.ProductoCrearReqModelo;
import com.example.demo.models.respuestas.ProductoDataResModelo;
import com.example.demo.repositorios.IProductoRepositorio;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    IProductoRepositorio iProductoRepositorio;
    
    @PostMapping()
    public ProductoDataResModelo crearProducto(@RequestBody ProductoCrearReqModelo productoCrearReqModelo){

        ProductoEntidad productoEntidad= new ProductoEntidad();
        productoEntidad.setIdProducto(UUID.randomUUID().toString());

        BeanUtils.copyProperties(productoCrearReqModelo, productoEntidad);

        ProductoEntidad productoGuardado= iProductoRepositorio.save(productoEntidad);

        ProductoDataResModelo productoEntregado = new ProductoDataResModelo();

        BeanUtils.copyProperties(productoGuardado, productoEntregado);

        return productoEntregado;
    }

    @GetMapping()
    public List<ProductoDataResModelo> obtenerProductos(){

        List<ProductoEntidad> listaProductosGuardados= iProductoRepositorio.findAllByOrderByIdDesc();

        List<ProductoDataResModelo> listaProductosEntregados= new ArrayList<>();

        for (ProductoEntidad productoEntidad : listaProductosGuardados) {
            ProductoDataResModelo productoDataResModelo= new ProductoDataResModelo();
            BeanUtils.copyProperties(productoEntidad, productoDataResModelo);
            listaProductosEntregados.add(productoDataResModelo);

        }

        return listaProductosEntregados;


        }
    @GetMapping(path = "/{id}")
    public ProductoDataResModelo detalleProducto(@PathVariable String id){

        ProductoEntidad productoGuardado= iProductoRepositorio.FindByIdProducto(id);

        ProductoDataResModelo productoEntregado= new ProductoDataResModelo();

        BeanUtils.copyProperties(productoGuardado, productoEntregado);

        return productoEntregado;
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarProducto(@PathVariable String id){

        ProductoEntidad productoGuardado= iProductoRepositorio.FindByIdProducto(id);

        iProductoRepositorio.delete(productoGuardado);

        return "Producto eliminado con exito";

    }

    @PutMapping(path = "/{id}")
    public ProductoDataResModelo actualizarProducto(@PathVariable String id,
                                                    @RequestBody ProductoActualizarReqModelo productoActualizarReqModelo){

        ProductoEntidad productoGuardado= iProductoRepositorio.FindByIdProducto(id);
        productoGuardado.setTitulo(productoActualizarReqModelo.getTitulo());
        productoGuardado.setImagen(productoActualizarReqModelo.getImagen());
        productoGuardado.setPrecio(productoActualizarReqModelo.getPrecio());
        productoGuardado.setCategoria(productoActualizarReqModelo.getCategoria());
        productoGuardado.setDescripcion(productoActualizarReqModelo.getDescripcion());


        ProductoEntidad productoActualizado= iProductoRepositorio.save(productoGuardado);

        ProductoDataResModelo productoEntregado= new ProductoDataResModelo();

        BeanUtils.copyProperties(productoActualizado, productoEntregado);

        return productoEntregado;

     }

}





