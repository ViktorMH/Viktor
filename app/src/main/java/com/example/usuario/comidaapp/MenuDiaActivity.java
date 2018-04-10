package com.example.usuario.comidaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.usuario.comidaapp.DatabaseLocal.ControlBDsand;
import com.example.usuario.comidaapp.Entidades.Caldo;
import com.example.usuario.comidaapp.Entidades.MenuDia;

import java.util.ArrayList;
import java.util.List;

public class MenuDiaActivity extends AppCompatActivity {
    List<MenuDia> listamenucaldodia,listamenusegundodia,listamenucombinadodia;
    ArrayList<String> listafinalmenucaldodia,listafinalmenusegundodia,listafinalmenucombinadodia;
    ListView listado_menu_caldo_dia,listado_menu_segundo_dia,listado_menu_combinado_dia;
    Button inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dia);
        final ControlBDsand DBhelper=new ControlBDsand(this);
        listado_menu_caldo_dia=findViewById(R.id.lv_caldo_dia);
        listado_menu_segundo_dia=findViewById(R.id.lv_segundos_dia);
        listado_menu_combinado_dia=findViewById(R.id.lv_combinados_dia);

        inicio=findViewById(R.id.btn_inicio_md);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(MenuDiaActivity.this,MainActivity.class);
                startActivity(inicio);
            }
        });

        DBhelper.abrir();
        listamenucaldodia=DBhelper.listarMenuCaldoDia();
        listafinalmenucaldodia=DBhelper.obtenerListaMenuDia(listamenucaldodia);
        listamenusegundodia=DBhelper.listarMenuSegundoDia();
        listafinalmenusegundodia=DBhelper.obtenerListaMenuDia(listamenusegundodia);
        listamenucombinadodia=DBhelper.listarMenuCombinadoDia();
        listafinalmenucombinadodia=DBhelper.obtenerListaMenuDia(listamenucombinadodia);

        DBhelper.cerrar();
        ArrayAdapter<String> caldo_menu_dia=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listafinalmenucaldodia);
        listado_menu_caldo_dia.setAdapter(caldo_menu_dia);
        ArrayAdapter<String> segundo_menu_dia=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listafinalmenusegundodia);
        listado_menu_segundo_dia.setAdapter(segundo_menu_dia);
        ArrayAdapter<String> combinado_menu_dia=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listafinalmenucombinadodia);
        listado_menu_combinado_dia.setAdapter(combinado_menu_dia);


    }
}
