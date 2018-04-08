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

public class CombinadoActivity extends AppCompatActivity {
    Spinner spinner;
    List<Mimenu> listadocombinados;
    ArrayList<String> listafinalcombinados;
    EditText cant_combinados;
    Button segundo, inicio, caldo,limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinado);
        spinner= findViewById(R.id.sp_nom_caldo);
        cant_combinados=findViewById(R.id.et_cant_combinados);
        limpiar=findViewById(R.id.btn_limpiar);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setSelection(0);
                cant_combinados.setText("");
            }
        });

        segundo=findViewById(R.id.btn_segundos);
        segundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent segundo=new Intent(CombinadoActivity.this,SegundoActivity.class);
                startActivity(segundo);
            }
        });

        inicio=findViewById(R.id.btn_inicio);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(CombinadoActivity.this,MainActivity.class);
                startActivity(inicio);
            }
        });

        caldo=findViewById(R.id.btn_caldos);
        caldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent caldo=new Intent(CombinadoActivity.this,CaldoActivity.class);
                startActivity(caldo);
            }
        });

        ControlBDsand DBhelper=new ControlBDsand(this);
        DBhelper.abrir();
        listadocombinados=DBhelper.listarCombinados();
        listafinalcombinados=DBhelper.obtenerListacombinados(listadocombinados);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalcombinados);
        spinner.setAdapter(adapter);
    }
}
