package com.example.usuario.comidaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.usuario.comidaapp.DatabaseLocal.ControlBDsand;

import java.util.ArrayList;

public class CaldoActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<Mimenu> listadocaldos;
    ArrayList<String> listafinalcaldos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caldo);
        spinner= findViewById(R.id.sp_nom_caldo);

        ControlBDsand DBhelper=new ControlBDsand(this);
        DBhelper.abrir();
        listadocaldos=DBhelper.listarCaldos();
        listafinalcaldos=DBhelper.obtenerListaCaldos(listadocaldos);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,listafinalcaldos);
        spinner.setAdapter(adapter);
    }

}
