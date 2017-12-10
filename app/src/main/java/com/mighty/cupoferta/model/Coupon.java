package com.mighty.cupoferta.model;

/**
 * Created by jeanp on 09/12/2017.
 */

public class Coupon {
    private String id;
    private String empresa;
    private String titulo;
    private String descripcion;
    private Double precio;
    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Coupon(String empresa, String titulo, String descripcion) {
        this.empresa = empresa;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
}
