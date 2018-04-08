package com.example.usuario.comidaapp.DatabaseLocal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.usuario.comidaapp.Entidades.Segundo;
import com.example.usuario.comidaapp.Entidades.Mimenu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
        private static String DATABASE_NAME = "com4.db";
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

                db.execSQL(ContratoLectorCampo.SQL_CREATE_VIEW_SEGUNDO_DIA);

                db.execSQL(ContratoLectorCampo.SQL_INSERT_DATA_TABLA_MENU);
                db.execSQL(ContratoLectorCampo.SQL_INSERT_DATA_TABLA_MESA);

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

       public List<Mimenu> listarCaldos(){
        List<Mimenu> listacaldo=new ArrayList<>();
        Cursor cursor=db.rawQuery("select nommenu from menu where idmenu>=1 and idmenu<=6 ", null);
        if (cursor.moveToFirst()){
            do{
                Mimenu mimenu=new Mimenu();
                mimenu.setNommenu(cursor.getString(0));
                listacaldo.add(mimenu);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listacaldo;
    }
    public ArrayList<String> obtenerListaCaldos(List<Mimenu> arrayList){
        ArrayList<String> listacaldos;
        listacaldos=new ArrayList<String>();
        listacaldos.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listacaldos.add(arrayList.get(i).getNommenu());
        }
        return listacaldos;
    }

    public List<Mimenu> listarSegundos(){
        List<Mimenu> listasegundo=new ArrayList<>();
        Cursor cursor=db.rawQuery("select nommenu from menu where idmenu>=16 and idmenu<=32 ", null);
        if (cursor.moveToFirst()){
            do{
                Mimenu mimenu=new Mimenu();
                mimenu.setNommenu(cursor.getString(0));
                listasegundo.add(mimenu);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listasegundo;
    }
    public ArrayList<String> obtenerListaSegundos(List<Mimenu> arrayList){
        ArrayList<String> listasegundos;
        listasegundos=new ArrayList<String>();
        listasegundos.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listasegundos.add(arrayList.get(i).getNommenu());
        }
        return listasegundos;
    }

    public List<Mimenu> listarCombinados(){
        List<Mimenu> listacombinado=new ArrayList<>();
        Cursor cursor=db.rawQuery("select nommenu from menu where idmenu>=7 and idmenu<=15 ", null);
        if (cursor.moveToFirst()){
            do{
                Mimenu mimenu=new Mimenu();
                mimenu.setNommenu(cursor.getString(0));
                listacombinado.add(mimenu);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listacombinado;
    }
    public ArrayList<String> obtenerListacombinados(List<Mimenu> arrayList){
        ArrayList<String> listacombinados;
        listacombinados=new ArrayList<String>();
        listacombinados.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listacombinados.add(arrayList.get(i).getNommenu());
        }
        return listacombinados;
    }
    public void guardarCaldo(int id_caldo, double cantidad,long id_tab_caldo){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idcaldo",id_tab_caldo);
        contentValues.put("idmenu",id_caldo);
        contentValues.put("stock_caldo",cantidad);
        contentValues.put("fecha_caldo",getDateTime());
        db.insert("caldo",null,contentValues);
    }
    public void guardarSegundo(int id_segundo, double cantidad,long id_tab_segundo){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idsegundo",id_tab_segundo);
        contentValues.put("idmenu",id_segundo);
        contentValues.put("stock_segundo",cantidad);
        contentValues.put("fecha_segundo",getDateTime());
        db.insert("segundo",null,contentValues);
    }
    public void guardarCombinado(int id_combinado, double cantidad,long id_tab_combinado){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idcombinado",id_tab_combinado);
        contentValues.put("idmenu",id_combinado);
        contentValues.put("stock_combinado",cantidad);
        contentValues.put("fecha_combinado",getDateTime());
        db.insert("combinado",null,contentValues);
    }
    private String getDateTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        return df.format(Calendar.getInstance().getTime());
    }
    public long consultIDTablaCaldo () {
        Cursor cursor = db.rawQuery("SELECT MAX(idcaldo) FROM caldo;", null);

        long id_caldo = -1;

        if (cursor.moveToFirst()) {
            if (cursor.isNull(0)) {
                id_caldo = 1;
            } else {
                id_caldo = cursor.getLong(0) + 1;
            }
        }
        cursor.close();
        return id_caldo;
    }
    public long consultIDTablaSegundo () {
        Cursor cursor = db.rawQuery("SELECT MAX(idsegundo) FROM segundo;", null);

        long id_segundo = -1;

        if (cursor.moveToFirst()) {
            if (cursor.isNull(0)) {
                id_segundo = 1;
            } else {
                id_segundo = cursor.getLong(0) + 1;
            }
        }
        cursor.close();
        return id_segundo;
    }
    public long consultIDTablaCombinado () {
        Cursor cursor = db.rawQuery("SELECT MAX(idcombinado) FROM combinado;", null);

        long id_combinado = -1;

        if (cursor.moveToFirst()) {
            if (cursor.isNull(0)) {
                id_combinado = 1;
            } else {
                id_combinado = cursor.getLong(0) + 1;
            }
        }
        cursor.close();
        return id_combinado;
    }
    public int buscarId(String nombre){
        int id_buscado;
        final String Consulta = "SELECT idmenu FROM menu WHERE nommenu = ?";
        Cursor cursor = db.rawQuery(Consulta, new String[] {nombre});
        if (cursor.moveToFirst()) {
            id_buscado = cursor.getInt(0) ;
            cursor.close();
            return id_buscado;
        } else {
            cursor.close();
            return 0;
        }
    }
    public List<Segundo> listarSegundosDia () {
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        String fecha_final;
        String fecha_inicial;

        if (calendar.get(Calendar.HOUR_OF_DAY) < 24) {
            fecha_final = df.format(calendar.getTime());

            calendar.add(Calendar.DAY_OF_YEAR, -1);
            calendar.set(Calendar.HOUR_OF_DAY, 24);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            fecha_inicial = df.format(calendar.getTime());
        } else {
            fecha_final = df.format(calendar.getTime());

            calendar.set(Calendar.HOUR_OF_DAY, 24);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            fecha_inicial = df.format(calendar.getTime());
        }

        List<Segundo> listadosegundo=new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT nommenu FROM caldo_dia_view WHERE fecha_caldo >='"+fecha_inicial+"'"+" AND fecha_caldo < '"+fecha_final+"'",null);

        if (cursor.moveToFirst()){
            do{
                Segundo segundo=new Segundo();
                segundo.setNombre_segundo(cursor.getString(0));
                listadosegundo.add(segundo);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listadosegundo;
    }
    public ArrayList<String> obtenerListaSegundosDia(List<Segundo> arrayList){
        ArrayList<String> listasegundosdia;
        listasegundosdia=new ArrayList<String>();
        listasegundosdia.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listasegundosdia.add(arrayList.get(i).getNombre_segundo());
        }
        return listasegundosdia;
    }

}
