package com.example.usuario.comidaapp.Entidades;

/**
 * Created by usuario on 08/04/2018.
 */

public class Segundo {
    private String nombre_segundo;
    private String fecha_pedido_segundo;
    public Segundo(){

    }

    public Segundo(String nombre_segundo, String fecha_pedido) {
        this.nombre_segundo = nombre_segundo;
        this.fecha_pedido_segundo = fecha_pedido;
    }

    public String getNombre_segundo() {
        return nombre_segundo;
    }

    public void setNombre_segundo(String nombre_segundo) {
        this.nombre_segundo = nombre_segundo;
    }

    public String getFecha_pedido() {
        return fecha_pedido_segundo;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido_segundo = fecha_pedido;
    }
}
