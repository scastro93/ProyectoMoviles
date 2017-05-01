package com.example.scastro81.teamstec.Main.subFragmentAdd;

/**
 * Created by scastro81 on 7/04/17.
 */

public class Moment {

    private String titulo;
    private String descripcion;

    public Moment(){

    }

    public Moment(String titulo, String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
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
}
