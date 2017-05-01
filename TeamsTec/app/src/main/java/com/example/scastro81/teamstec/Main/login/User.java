package com.example.scastro81.teamstec.Main.login;

/**
 * Created by scastro81 on 5/04/17.
 */

public class User {

    private String nombre;
    private String matricula;

    public User(){


    }

    public User(String nombre, String matricula){
        this.nombre = nombre;
        this.matricula = matricula;
    }

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }    


}
