package com.example.usuario.comidaapp.Entidades;

/**
 * Created by usuario on 09/04/2018.
 */

public class ReporteDia {
    String nom_comi;
    int cant_ven;
    String fecha_repor;
    public  ReporteDia(){

    }

    public ReporteDia(String nom_comi, int cant_ven, String fecha_repor) {
        this.nom_comi = nom_comi;
        this.cant_ven = cant_ven;
        this.fecha_repor = fecha_repor;
    }

    public String getNom_comi() {
        return nom_comi;
    }

    public void setNom_comi(String nom_comi) {
        this.nom_comi = nom_comi;
    }

    public int getCant_ven() {
        return cant_ven;
    }

    public void setCant_ven(int cant_ven) {
        this.cant_ven = cant_ven;
    }

    public String getFecha_repor() {
        return fecha_repor;
    }

    public void setFecha_repor(String fecha_repor) {
        this.fecha_repor = fecha_repor;
    }
}
