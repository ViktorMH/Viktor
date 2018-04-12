package com.example.usuario.comidaapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.comidaapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Dalthon on 10/4/2018.
 */

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {
    ArrayList<String> listDatos;

    public AdapterDatos(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }


    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflar un view y devolver
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterDatos.ViewHolderDatos holder, int position) {
        //comunicacion entre el adaptador y la clase viewholderdatos
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}
