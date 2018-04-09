package com.example.usuario.comidaapp.Entidades;

/**
 * Created by Dalthon on 8/4/2018.
 */

public class Mesa {
    int id_mesa;
    String nom_mesa;
    public Mesa(){

    }

    public Mesa(int id_mesa, String nom_mesa) {
        this.id_mesa = id_mesa;
        this.nom_mesa = nom_mesa;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public String getNom_mesa() {
        return nom_mesa;
    }

    public void setNom_mesa(String nom_mesa) {
        this.nom_mesa = nom_mesa;
    }
}
