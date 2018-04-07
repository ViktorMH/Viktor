package com.example.usuario.comidaapp.DatabaseLocal;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.usuario.comidaapp.Mimenu;

import java.util.ArrayList;

/**
 * Created by usuario on 06/04/2018.
 */

public class ControlBDsand {
    private static final String[] camposMenu = new String[]{"idmenu", "nommenu"};

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBDsand(Context context) {
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static String DATABASE_NAME = "com1.db";
        private static int VERSION = 1;

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_MENU);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_MESA);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_CALDO);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_SEGUNDO);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_COMBINADO);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_PEDIDO);

                db.execSQL(ContratoLectorCampo.SQL_INSERT_DATA_TABLA_MENU);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {
                db.execSQL(ContratoLectorCampo.SQL_DROP_TABLA_MENU);
                db.execSQL(ContratoLectorCampo.SQL_DROP_TABLA_MESA);
                db.execSQL(ContratoLectorCampo.SQL_DROP_TABLA_CALDO);
                db.execSQL(ContratoLectorCampo.SQL_DROP_TABLA_SEGUNDO);
                db.execSQL(ContratoLectorCampo.SQL_DROP_TABLA_COMBINADO);
                db.execSQL(ContratoLectorCampo.SQL_DROP_TABLA_PEDIDO);

                onCreate(db);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
    }

    public void cerrar() {
        DBHelper.close();
    }

    public long consultIDPedido () {
        Cursor cursor = db.rawQuery("SELECT MAX(idped) FROM detallepedido;", null);

        long id_pedido = -1;

        if (cursor.moveToFirst()) {
            if (cursor.isNull(0)) {
                id_pedido = 1;
            } else {
                id_pedido = cursor.getLong(0) + 1;
            }
        }

        cursor.close();
        return id_pedido;
    }
    public ArrayList<Mimenu> listarCaldos(){
        ArrayList<Mimenu> listacaldo=new ArrayList<>();
        Mimenu mimenu =null;
        Cursor cursor=db.rawQuery("select nommenu from menu where idmenu>=1 and idmenu<=6 ", null);
        while (cursor.moveToNext()){
            mimenu =new Mimenu();
            mimenu.setIdmenu(cursor.getInt(1));
            listacaldo.add(mimenu);
        }
        return listacaldo;
    }
    public ArrayList<String> obtenerListaCaldos(ArrayList<Mimenu> arrayList){
        ArrayList<String> listacaldos;
        listacaldos=new ArrayList<String>();
        listacaldos.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listacaldos.add(arrayList.get(i).getNommenu());
        }
        return listacaldos;
    }

}
