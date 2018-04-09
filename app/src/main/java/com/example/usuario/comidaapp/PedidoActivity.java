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
import com.example.usuario.comidaapp.Entidades.Caldo;
import com.example.usuario.comidaapp.Entidades.Cantidad;
import com.example.usuario.comidaapp.Entidades.Combinado;
import com.example.usuario.comidaapp.Entidades.Mesa;
import com.example.usuario.comidaapp.Entidades.Segundo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PedidoActivity extends AppCompatActivity {
    Button limpiar,inicio,guardar;
    Spinner sp_segundo,sp_combinado,sp_mesa,sp_cant_seg,sp_cant_cal;
    List<Segundo> listadosegundosdia;
    ArrayList<String> listafinalsegundosdia;
    List<Combinado> listadocombinadosdia;
    ArrayList<String> listafinalcombinadosdia;
    List<Cantidad> listadocantidades;
    ArrayList<String> listafinalcantidades;
    List<Mesa> listadomesa;
    ArrayList<String> listafinalmesa;
    List<Caldo> listadocaldo;
    ArrayList<String> listafinalcaldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        final ControlBDsand DBhelper=new ControlBDsand(this);

        sp_segundo=findViewById(R.id.sp_segundo_p);
        sp_combinado=findViewById(R.id.sp_combinado_p);
        sp_mesa=findViewById(R.id.sp_mesa_p);
        sp_cant_seg=findViewById(R.id.sp_cant_seg);
        sp_cant_cal=findViewById(R.id.sp_cant_cal);

        DBhelper.abrir();
        listadosegundosdia=DBhelper.listarSegundosDia();
        listafinalsegundosdia=DBhelper.obtenerListaSegundosDia(listadosegundosdia);
        listadocombinadosdia=DBhelper.listarCombinadosDia();
        listafinalcombinadosdia=DBhelper.obtenerListaCombinadosDia(listadocombinadosdia);
        listadocantidades=DBhelper.listarCantidad();
        listafinalcantidades=DBhelper.obtenerListaCantidad(listadocantidades);
        listadomesa=DBhelper.listarMesa();
        listafinalmesa=DBhelper.obtenerListaMesa(listadomesa);
        listadocaldo=DBhelper.listarIDCaldoDia();
        listafinalcaldo=DBhelper.obtenerListaCaldosDia(listadocaldo);
        DBhelper.cerrar();
        ArrayAdapter<String> adap_segundos= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalsegundosdia);
        sp_segundo.setAdapter(adap_segundos);
        ArrayAdapter<String> adap_mesa= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalmesa);
        sp_mesa.setAdapter(adap_mesa);
        ArrayAdapter<String> adap_combinados= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalcombinadosdia);
        sp_combinado.setAdapter(adap_combinados);
        ArrayAdapter<String> adap_cantidad= new ArrayAdapter<>(this,R.layout.spinner_formato,listafinalcantidades);
        sp_cant_seg.setAdapter(adap_cantidad);
        sp_cant_cal.setAdapter(adap_cantidad);

        guardar=findViewById(R.id.btn_Guardar_p);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_segu,id_combi,id_mesa,id_caldo_dia;
                String canti_segu_dia,canti_caldos_dia;
                double cantidad_caldo_p,cantidad_segundo_p;

                DBhelper.abrir();
                long id_tabla_pedido=DBhelper.consultIDTablaPedido();
                id_caldo_dia= Integer.valueOf(String.valueOf(DBhelper.listarIDCaldoDia()));

                canti_caldos_dia = (String) sp_cant_cal.getSelectedItem();
                if (Objects.equals(canti_caldos_dia, "0")){
                    cantidad_caldo_p=0.0;
                }else{
                    cantidad_caldo_p=Double.parseDouble(canti_caldos_dia);
                }

                canti_segu_dia = (String) sp_cant_cal.getSelectedItem();
                if (Objects.equals(canti_segu_dia, "0")){
                    cantidad_segundo_p=0.0;
                }else{
                    cantidad_segundo_p=Double.parseDouble(canti_segu_dia);
                }

                id_segu= (int) sp_segundo.getSelectedItem();
                if (id_segu!=0){
                    id_segu=DBhelper.buscarId((String) sp_segundo.getSelectedItem());
                }else{
                    id_segu=0;
                }
                id_combi=(int) sp_combinado.getSelectedItem();
                if (id_combi!=0){
                    id_combi=DBhelper.buscarId((String) sp_combinado.getSelectedItem());
                }else{
                    id_combi=0;
                }
                id_mesa=(int) sp_mesa.getSelectedItem();
                if (id_mesa!=0){
                    id_mesa=DBhelper.buscarIdMesa((String) sp_mesa.getSelectedItem());
                }else{
                    id_mesa=0;
                }

                if (Objects.equals(canti_caldos_dia, "0")&& Objects.equals(canti_segu_dia, "0")&& id_segu==0 && id_combi==0 && id_mesa==0 ){
                    Toast.makeText(PedidoActivity.this, "Ingrese su pedido", Toast.LENGTH_SHORT).show();
                }else {
                    if ( id_mesa==0 && ( id_segu!=0 || id_combi!=0 || !Objects.equals(canti_caldos_dia, "0"))){
                        Toast.makeText(PedidoActivity.this, "Elija una mesa o para llevar", Toast.LENGTH_SHORT).show();
                    }else{
                        DBhelper.guardarPedido(id_tabla_pedido,id_caldo_dia,cantidad_caldo_p,id_segu,cantidad_segundo_p,id_combi,id_mesa);
                        sp_segundo.setSelection(0);
                        sp_combinado.setSelection(0);
                        sp_mesa.setSelection(0);
                        sp_cant_seg.setSelection(0);
                        sp_cant_cal.setSelection(0);
                    }
                }

                DBhelper.cerrar();

            }
        });

        limpiar=findViewById(R.id.btn_limpiar_p);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp_segundo.setSelection(0);
                sp_combinado.setSelection(0);
                sp_mesa.setSelection(0);
                sp_cant_seg.setSelection(0);
                sp_cant_cal.setSelection(0);
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


    }
}
