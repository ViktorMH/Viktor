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

public class CaldoActivity extends AppCompatActivity {
    Spinner spinner;
    List<Mimenu> listadocaldos;
    ArrayList<String> listafinalcaldos;
    EditText cant_caldo;
    Button segundo, inicio, combinado,limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caldo);
        spinner= findViewById(R.id.sp_nom_caldo);
        cant_caldo=findViewById(R.id.et_cant_caldo);
        limpiar=findViewById(R.id.btn_limpiar);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setSelection(0);
                cant_caldo.setText("");
            }
        });
        segundo=findViewById(R.id.btn_segundos);
        segundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent segundo=new Intent(CaldoActivity.this,SegundoActivity.class);
                startActivity(segundo);
            }
        });
        inicio=findViewById(R.id.btn_inicio);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(CaldoActivity.this,MainActivity.class);
                startActivity(inicio);
            }
        });
        combinado=findViewById(R.id.btn_combinados);
        combinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent combinado=new Intent(CaldoActivity.this,CombinadoActivity.class);
                startActivity(combinado);
            }
        });

        ControlBDsand DBhelper=new ControlBDsand(this);
        DBhelper.abrir();
        listadocaldos=DBhelper.listarCaldos();
        listafinalcaldos=DBhelper.obtenerListaCaldos(listadocaldos);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalcaldos);
        spinner.setAdapter(adapter);

    }

}
