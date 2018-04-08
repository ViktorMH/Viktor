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

public class SegundoActivity extends AppCompatActivity {
    Spinner spinner;
    List<Mimenu> listadosegundos;
    ArrayList<String> listafinalsegundos;
    EditText cant_segundos;
    Button caldo, inicio, combinado,limpiar,guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        final ControlBDsand DBhelper=new ControlBDsand(this);

        spinner= findViewById(R.id.sp_nom_segundo);
        cant_segundos=findViewById(R.id.et_cant_segundos);

        guardar=findViewById(R.id.btn_guardar_s);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_segundo;
                String canti_segundos;
                double cantidad;
                DBhelper.abrir();
                long id_tabla_segundo=DBhelper.consultIDTablaSegundo();

                canti_segundos =  cant_segundos.getText().toString() ;
                if (Objects.equals(canti_segundos, "")){
                    cantidad=0.0;
                }else{
                    cantidad=Double.parseDouble(canti_segundos);
                }
                id_segundo=DBhelper.buscarId((String) spinner.getSelectedItem());
                if (id_segundo==0){
                    Toast.makeText(SegundoActivity.this, "Seleccione un segundo", Toast.LENGTH_SHORT).show();
                }else{
                    DBhelper.guardarSegundo(id_segundo,cantidad,id_tabla_segundo);
                    Toast.makeText(SegundoActivity.this, "Guardado exitosamente", Toast.LENGTH_SHORT).show();
                }
                DBhelper.cerrar();

            }
        });

        limpiar=findViewById(R.id.btn_limpiar);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setSelection(0);
                cant_segundos.setText("");
            }
        });

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

        DBhelper.abrir();
        listadosegundos=DBhelper.listarSegundos();
        listafinalsegundos=DBhelper.obtenerListaSegundos(listadosegundos);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalsegundos);
        spinner.setAdapter(adapter);
    }
}
