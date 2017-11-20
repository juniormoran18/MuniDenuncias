package com.example.junior.munidenuncias.Repository;

/**
 * Created by Junior on 13/11/17.
 */

public class Denuncia {

    private Integer id;
    private String titulo;
    private String descripcion;
    private Double latitud;
    private Double longitud;
    private String imagen;
    private String usuario;


    public Denuncia(Integer id, String titulo, String descripcion, Double latitud, Double longitud, String imagen, String usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
        this.usuario = usuario;
    }

    public Denuncia() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Denuncia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", imagen='" + imagen + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
