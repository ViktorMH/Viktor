package com.example.usuario.comidaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.usuario.comidaapp.DatabaseLocal.ControlBDsand;
import com.example.usuario.comidaapp.Entidades.MenuDia;

import java.util.ArrayList;
import java.util.List;

public class MenuDiaActivity extends AppCompatActivity {
    List<MenuDia> listamenudia;
    ArrayList<String> listafinalmenudia;
    ListView listado_menu_dia;
    Button inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dia);
        final ControlBDsand DBhelper=new ControlBDsand(this);
        listado_menu_dia=findViewById(R.id.lv_menu_dia);

        inicio=findViewById(R.id.btn_inicio_md);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(MenuDiaActivity.this,MainActivity.class);
                startActivity(inicio);
            }
        });

        DBhelper.abrir();
        listamenudia=DBhelper.listarMenuDia();
        listafinalmenudia=DBhelper.obtenerListaMenuDia(listamenudia);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listafinalmenudia);
        listado_menu_dia.setAdapter(adapter);


    }
}
