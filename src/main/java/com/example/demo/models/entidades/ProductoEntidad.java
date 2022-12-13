package com.example.demo.models.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name= "producto")
public class ProductoEntidad implements Serializable{
  
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String idProducto;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    private String precio;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String descripcion;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return this.precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   

}
