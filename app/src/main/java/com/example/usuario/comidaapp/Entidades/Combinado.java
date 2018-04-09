package com.example.usuario.comidaapp.Entidades;

/**
 * Created by Dalthon on 8/4/2018.
 */

public class Combinado {
    String nombre_combinado;
    String fecha_pedido_combinado;

    public Combinado(){

    }

    public Combinado(String nombre_combinado, String fecha_pedido_combinado) {
        this.nombre_combinado = nombre_combinado;
        this.fecha_pedido_combinado = fecha_pedido_combinado;
    }

    public String getNombre_combinado() {
        return nombre_combinado;
    }

    public void setNombre_combinado(String nombre_combinado) {
        this.nombre_combinado = nombre_combinado;
    }

    public String getFecha_pedido_combinado() {
        return fecha_pedido_combinado;
    }

    public void setFecha_pedido_combinado(String fecha_pedido_combinado) {
        this.fecha_pedido_combinado = fecha_pedido_combinado;
    }
}
