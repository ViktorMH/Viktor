package com.example.usuario.comidaapp.Entidades;

/**
 * Created by Dalthon on 9/4/2018.
 */

public class MenuDia {
    String nom_menu_dia;
    int cant_menu_dia;
    String fecha_menu_dia;
    public MenuDia(){

    }

    public MenuDia(String nom_menu_dia, int cant_menu_dia, String fecha_menu_dia) {
        this.nom_menu_dia = nom_menu_dia;
        this.cant_menu_dia = cant_menu_dia;
        this.fecha_menu_dia = fecha_menu_dia;
    }

    public String getNom_menu_dia() {
        return nom_menu_dia;
    }

    public void setNom_menu_dia(String nom_menu_dia) {
        this.nom_menu_dia = nom_menu_dia;
    }

    public int getCant_menu_dia() {
        return cant_menu_dia;
    }

    public void setCant_menu_dia(int cant_menu_dia) {
        this.cant_menu_dia = cant_menu_dia;
    }

    public String getFecha_menu_dia() {
        return fecha_menu_dia;
    }

    public void setFecha_menu_dia(String fecha_menu_dia) {
        this.fecha_menu_dia = fecha_menu_dia;
    }
}
