package com.example.usuario.comidaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.usuario.comidaapp.Adapters.AdapterDatos;

import java.util.ArrayList;

public class MesaActivity extends AppCompatActivity {

    ArrayList<String> listDatos;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesa);

        recyclerView=findViewById(R.id.recyclerId);
        //this  por defecto una lista de tipo vertical
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        listDatos=new ArrayList<>();
        for (int i=0;i<50;i++){
            listDatos.add("Mesa "+i+" ");
        }
        AdapterDatos adapterDatos=new AdapterDatos(listDatos);
        recyclerView.setAdapter(adapterDatos);
        //comentario
    }
}
