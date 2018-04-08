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
import com.example.usuario.comidaapp.Entidades.Segundo;

import java.util.ArrayList;
import java.util.List;

public class PedidoActivity extends AppCompatActivity {
    Button limpiar,inicio;
    Spinner sp_segundo,sp_combinado,sp_mesa;
    EditText et_cant_seg,et_cant_cald;
    List<Segundo> listadocaldosdia;
    ArrayList<String> listafinalcaldosdia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        final ControlBDsand DBhelper=new ControlBDsand(this);

        sp_segundo=findViewById(R.id.sp_segundo_p);
        sp_combinado=findViewById(R.id.sp_combinado_p);
        sp_mesa=findViewById(R.id.sp_mesa_p);
        et_cant_seg=findViewById(R.id.et_cant_seg_p);
        et_cant_cald=findViewById(R.id.et_cant_cald_p);

        limpiar=findViewById(R.id.btn_limpiar_p);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp_segundo.setSelection(0);
                sp_combinado.setSelection(0);
                sp_mesa.setSelection(0);
                et_cant_seg.setText("");
                et_cant_cald.setText("");
            }
        });

        inicio=findViewById(R.id.btn_inicio_p);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(PedidoActivity.this,MainActivity.class);
                startActivity(inicio);
            }
        });

        DBhelper.abrir();
        listadocaldosdia=DBhelper.listarSegundosDia();
        listafinalcaldosdia=DBhelper.obtenerListaSegundosDia(listadocaldosdia);
        DBhelper.cerrar();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalcaldosdia);
        sp_segundo.setAdapter(adapter);
    }
}
