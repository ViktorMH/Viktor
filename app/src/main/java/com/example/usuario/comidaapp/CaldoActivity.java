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

public class CaldoActivity extends AppCompatActivity {
    Spinner spinner;
    List<Mimenu> listadocaldos;
    ArrayList<String> listafinalcaldos;
    EditText cant_caldo;
    Button segundo, inicio, combinado,limpiar,guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caldo);

        final ControlBDsand DBhelper=new ControlBDsand(this);

        spinner= findViewById(R.id.sp_nom_caldo);
        spinner.setFocusable(true);
        spinner.setFocusableInTouchMode(true);
        spinner.requestFocus();
        cant_caldo=findViewById(R.id.et_cant_caldo);
        guardar=findViewById(R.id.btn_guardar_c);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_caldo;
                String canti_caldos;
                double cantidad;
                DBhelper.abrir();
                long id_tabla_caldo=DBhelper.consultIDTablaCaldo();

                canti_caldos =  cant_caldo.getText().toString() ;
                if (Objects.equals(canti_caldos, "")){
                    cantidad=0.0;
                }else{
                    cantidad=Double.parseDouble(canti_caldos);
                }
                id_caldo=DBhelper.buscarId((String) spinner.getSelectedItem());
                if (id_caldo==0){
                    Toast.makeText(CaldoActivity.this, "Seleccione un caldo", Toast.LENGTH_SHORT).show();
                }else{
                    DBhelper.guardarCaldo(id_caldo,cantidad,id_tabla_caldo);
                    Toast.makeText(CaldoActivity.this, "Guardado exitosamente", Toast.LENGTH_SHORT).show();
                    spinner.setSelection(0);
                    cant_caldo.setText("");
                    Intent segundo=new Intent(CaldoActivity.this,SegundoActivity.class);
                    startActivity(segundo);
                }
                DBhelper.cerrar();

            }
        });
        limpiar=findViewById(R.id.btn_limpiar);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setSelection(0);
                cant_caldo.setText("");
                Toast.makeText(CaldoActivity.this, "Se realizó la limpieza", Toast.LENGTH_SHORT).show();
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

        DBhelper.abrir();
        listadocaldos=DBhelper.listarCaldos();
        listafinalcaldos=DBhelper.obtenerListaCaldos(listadocaldos);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalcaldos);
        spinner.setAdapter(adapter);

    }

}
