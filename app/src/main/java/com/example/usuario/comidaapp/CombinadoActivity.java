package com.example.usuario.comidaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.usuario.comidaapp.DatabaseLocal.ControlBDsand;
import com.example.usuario.comidaapp.Entidades.Mimenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CombinadoActivity extends AppCompatActivity {
    Spinner spinner;
    List<Mimenu> listadocombinados;
    ArrayList<String> listafinalcombinados;
    EditText cant_combinados;
    Button segundo, inicio, caldo,limpiar,guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combinado);

        final ControlBDsand DBhelper=new ControlBDsand(this);

        spinner= findViewById(R.id.sp_nom_combinado);
        cant_combinados=findViewById(R.id.et_cant_combinados);

        guardar=findViewById(R.id.btn_guardar_c);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_combinado;
                String canti_combinado;
                double cantidad;
                DBhelper.abrir();
                long id_tabla_combinado=DBhelper.consultIDTablaCombinado();

                canti_combinado =  cant_combinados.getText().toString() ;
                if (Objects.equals(canti_combinado, "")){
                    cantidad=0.0;
                }else{
                    cantidad=Double.parseDouble(canti_combinado);
                }
                id_combinado=DBhelper.buscarId((String) spinner.getSelectedItem());
                if (id_combinado==0){
                    Toast.makeText(CombinadoActivity.this, "Seleccione un combinado", Toast.LENGTH_SHORT).show();
                }else{
                    DBhelper.guardarCombinado(id_combinado,cantidad,id_tabla_combinado);
                    Toast.makeText(CombinadoActivity.this, "Guardado exitosamente", Toast.LENGTH_SHORT).show();
                }
                DBhelper.cerrar();

            }
        });

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


        DBhelper.abrir();
        listadocombinados=DBhelper.listarCombinados();
        listafinalcombinados=DBhelper.obtenerListacombinados(listadocombinados);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalcombinados);
        spinner.setAdapter(adapter);
    }
}
