package com.example.usuario.comidaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.usuario.comidaapp.DatabaseLocal.ControlBDsand;
import com.example.usuario.comidaapp.Entidades.MenuDia;
import com.example.usuario.comidaapp.Entidades.ReporteDia;

import java.util.ArrayList;
import java.util.List;

public class ReportesActivity extends AppCompatActivity {
    List<ReporteDia> listareportecaldodia,listareportesegundodia,listareportecombinadodia;
    ArrayList<String> listafinalreportecaldodia,listafinalreportesegundodia,listafinalreportecombinadodia;
    ListView listado_reporte_caldo_dia,listado_reporte_segundo_dia,listado_reporte_combinado_dia;
    Button inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        final ControlBDsand DBhelper=new ControlBDsand(this);
        listado_reporte_caldo_dia=findViewById(R.id.lv_caldo_rep);
        listado_reporte_segundo_dia=findViewById(R.id.lv_segundos_rep);
        listado_reporte_combinado_dia=findViewById(R.id.lv_combinados_rep);

        inicio=findViewById(R.id.btn_inicio_rep);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(ReportesActivity.this,MainActivity.class);
                startActivity(inicio);
            }
        });

        DBhelper.abrir();
        listareportecaldodia=DBhelper.listarCaldosRep();
        listafinalreportecaldodia=DBhelper.obtenerListaComidaReporte(listareportecaldodia);
        listareportesegundodia=DBhelper.listarSegundosRep();
        listafinalreportesegundodia=DBhelper.obtenerListaComidaReporte(listareportesegundodia);
        listareportecombinadodia=DBhelper.listarCombinadosRep();
        listafinalreportecombinadodia=DBhelper.obtenerListaComidaReporte(listareportecombinadodia);
        DBhelper.cerrar();

        ArrayAdapter<String> caldo_reporte_dia=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listafinalreportecaldodia);
        listado_reporte_caldo_dia.setAdapter(caldo_reporte_dia);
        ArrayAdapter<String> segundo_reporte_dia=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listafinalreportesegundodia);
        listado_reporte_segundo_dia.setAdapter(segundo_reporte_dia);
        ArrayAdapter<String> combinado_reporte_dia=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listafinalreportecombinadodia);
        listado_reporte_combinado_dia.setAdapter(combinado_reporte_dia);

    }
}
