package com.example.usuario.comidaapp.Entidades;

/**
 * Created by Dalthon on 8/4/2018.
 */

public class Cantidad {
    int id_cantidad;
    String nom_cantidad;
    public Cantidad(){

    }

    public Cantidad(int id_cantidad, String nom_cantidad) {
        this.id_cantidad = id_cantidad;
        this.nom_cantidad = nom_cantidad;
    }

    public int getId_cantidad() {
        return id_cantidad;
    }

    public void setId_cantidad(int id_cantidad) {
        this.id_cantidad = id_cantidad;
    }

    public String getNom_cantidad() {
        return nom_cantidad;
    }

    public void setNom_cantidad(String nom_cantidad) {
        this.nom_cantidad = nom_cantidad;
    }
}
