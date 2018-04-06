package com.example.usuario.comidaapp;

/**
 * Created by usuario on 06/04/2018.
 */

public class menu {
    Integer idmenu;
    String nommenu;

    public menu(Integer idmenu, String nommenu) {
        this.idmenu = idmenu;
        this.nommenu = nommenu;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getNommenu() {
        return nommenu;
    }

    public void setNommenu(String nommenu) {
        this.nommenu = nommenu;
    }
}
