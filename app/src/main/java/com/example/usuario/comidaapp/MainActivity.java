package com.example.usuario.comidaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.usuario.comidaapp.DatabaseLocal.ControlBDsand;

public class MainActivity extends AppCompatActivity {


    Button caldo_menu,segundo,combinado,pedido,menu_del_dia,reportes,calculo_ganacias,mesa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ControlBDsand DBhelper=new ControlBDsand(this);
        DBhelper.abrir();
        DBhelper.cerrar();

        caldo_menu=findViewById(R.id.btn_caldo_menu);
        caldo_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent caldo_menu=new Intent(MainActivity.this,CaldoActivity.class);
                startActivity(caldo_menu);
            }
        });

        segundo=findViewById(R.id.btn_segundo_menu);
        segundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent segundo=new Intent(MainActivity.this,SegundoActivity.class);
                startActivity(segundo);
            }
        });

        combinado=findViewById(R.id.btn_combinado_menu);
        combinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent combinado=new Intent(MainActivity.this,CombinadoActivity.class);
                startActivity(combinado);
            }
        });

        pedido=findViewById(R.id.btn_pedido_menu);
        pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pedido=new Intent(MainActivity.this,PedidoActivity.class);
                startActivity(pedido);
            }
        });

        menu_del_dia=findViewById(R.id.btn_menu_del_dia);
        menu_del_dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu_del_dia=new Intent(MainActivity.this,MenuDiaActivity.class);
                startActivity(menu_del_dia);
            }
        });

        calculo_ganacias=findViewById(R.id.btn_calc_gana);
        calculo_ganacias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calculo_gan=new Intent(MainActivity.this,CalculoActivity.class);
                startActivity(calculo_gan);
            }
        });

        reportes=findViewById(R.id.btn_reportes);
        reportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reportes=new Intent(MainActivity.this,ReportesActivity.class);
                startActivity(reportes);
            }
        });

        mesa=findViewById(R.id.btn_mesa);
        mesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mesa=new Intent(MainActivity.this,MesaActivity.class);
                startActivity(mesa);
            }
        });
    }
}
