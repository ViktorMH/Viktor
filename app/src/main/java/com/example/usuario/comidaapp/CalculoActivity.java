package com.example.usuario.comidaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.text.DecimalFormat;

public class CalculoActivity extends AppCompatActivity {
    Button inicio,limpiar,calcular;
    EditText cant_presas,precio_compra,precio_venta;
    TextView ganancia,cada_presa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        cant_presas=findViewById(R.id.et_cant_pres);
        precio_compra=findViewById(R.id.et_cost_com);
        precio_venta=findViewById(R.id.et_cost_vent);
        ganancia=findViewById(R.id.tv_ganan);
        cada_presa=findViewById(R.id.tv_cada_presa);

        cant_presas.requestFocus();

        inicio=findViewById(R.id.btn_inicio_calc);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio=new Intent(CalculoActivity.this,MainActivity.class);
                startActivity(inicio);
            }
        });
        limpiar=findViewById(R.id.btn_limpiar_cal);
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cant_presas.setText("");
                precio_compra.setText("");
                precio_venta.setText("");
                ganancia.setText("......");
                cada_presa.setText("......");

                Toast.makeText(CalculoActivity.this, "Se realizó la limpieza", Toast.LENGTH_SHORT).show();
            }
        });

        calcular=findViewById(R.id.btn_calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int canti_presas;
                Double presi_compra;
                Double presi_venta;
                Double calculo_cada_presa;
                Double calculo_ganancia;
                String calc_pres,calc_gan;
                canti_presas=Integer.valueOf(cant_presas.getText().toString());
                presi_compra=Double.parseDouble(precio_compra.getText().toString());
                presi_venta=Double.parseDouble(precio_venta.getText().toString());
                if (!cant_presas.getText().toString().isEmpty() && !precio_compra.getText().toString().isEmpty() && !precio_venta.getText().toString().isEmpty()){

                    calculo_cada_presa=presi_compra/canti_presas;
                    calculo_ganancia=(presi_venta*canti_presas)- presi_compra;

                    calc_pres=String.valueOf(calculo_cada_presa);
                    calc_gan=String.valueOf(calculo_ganancia);
                    ganancia.setText(String.format("%.2f",calculo_ganancia));
                    cada_presa.setText(String.format("%.2f",calculo_cada_presa));
                    if (calculo_ganancia>presi_compra){
                        StyleableToast.makeText(CalculoActivity.this, "SI te combiene", R.style.toast_si).show();
                    }else{
                        StyleableToast.makeText(CalculoActivity.this, "NO te combiene", R.style.toast_no).show();
                    }

                }else{
                    Toast.makeText(CalculoActivity.this, "Ingrese toda la información solicitada", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
