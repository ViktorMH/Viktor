package com.example.usuario.comidaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.usuario.comidaapp.DatabaseLocal.ControlBDsand;

import java.util.ArrayList;
import java.util.List;

public class SegundoActivity extends AppCompatActivity {
    Spinner spinner;
    List<Mimenu> listadosegundos;
    ArrayList<String> listafinalsegundos;
    EditText cant_segundos;
    Button caldo, inicio, combinado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        spinner= findViewById(R.id.sp_nom_segundo);
        cant_segundos=findViewById(R.id.et_cant_segundos);
        inicio=findViewById(R.id.btn_inicio);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(SegundoActivity.this,MainActivity.class);
                startActivity(inicio);
            }
        });
        combinado=findViewById(R.id.btn_combinados);
        combinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent combinado=new Intent(SegundoActivity.this,CombinadoActivity.class);
                startActivity(combinado);
            }
        });
        caldo=findViewById(R.id.btn_caldos);
        caldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent caldo=new Intent(SegundoActivity.this,CaldoActivity.class);
                startActivity(caldo);
            }
        });


        ControlBDsand DBhelper=new ControlBDsand(this);
        DBhelper.abrir();
        listadosegundos=DBhelper.listarSegundos();
        listafinalsegundos=DBhelper.obtenerListaSegundos(listadosegundos);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalsegundos);
        spinner.setAdapter(adapter);
    }
}
