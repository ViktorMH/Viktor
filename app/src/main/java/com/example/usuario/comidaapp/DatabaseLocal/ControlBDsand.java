package com.example.usuario.comidaapp.DatabaseLocal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.usuario.comidaapp.Entidades.Caldo;
import com.example.usuario.comidaapp.Entidades.Cantidad;
import com.example.usuario.comidaapp.Entidades.Combinado;
import com.example.usuario.comidaapp.Entidades.MenuDia;
import com.example.usuario.comidaapp.Entidades.Mesa;
import com.example.usuario.comidaapp.Entidades.ReporteDia;
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

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ControlBDsand(Context context) {
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static String DATABASE_NAME = "com16.db";
        private static int VERSION = 1;

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_MENU);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_MESA);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_CANTIDAD);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_CALDO);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_SEGUNDO);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_COMBINADO);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_TABLA_PEDIDO);

                db.execSQL(ContratoLectorCampo.SQL_CREATE_VIEW_SEGUNDO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_VIEW_COMBINADO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_VIEW_CALDO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_VIEW_REPORTE_SEGUNDO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_VIEW_REPORTE_CALDO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_CREATE_VIEW_REPORTE_COMBINADO_DIA);

                db.execSQL(ContratoLectorCampo.SQL_INSERT_DATA_TABLA_MENU);
                db.execSQL(ContratoLectorCampo.SQL_INSERT_DATA_TABLA_MESA);
                db.execSQL(ContratoLectorCampo.SQL_INSERT_DATA_TABLA_CANTIDAD);

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
                db.execSQL(ContratoLectorCampo.SQL_DROP_VIEW_SEGUNDOS_DIA);
                db.execSQL(ContratoLectorCampo.SQL_DROP_VIEW_COMBINADOS_DIA);
                db.execSQL(ContratoLectorCampo.SQL_DROP_VIEW_CALDO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_DROP_VIEW_REPORTE_SEGUNDO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_DROP_VIEW_REPORTE_COMBINADO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_DROP_VIEW_REPORTE_CALDO_DIA);
                db.execSQL(ContratoLectorCampo.SQL_DROP_TABLA_PEDIDO);
                db.execSQL(ContratoLectorCampo.SQL_DROP_TABLA_CANTIDAD);

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
        Cursor cursor=db.rawQuery("select nommenu from menu where idmenu>=1 and idmenu<=5 ", null);
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
        listacaldos=new ArrayList<>();
        listacaldos.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listacaldos.add(arrayList.get(i).getNommenu());
        }
        return listacaldos;
    }

    public List<Mimenu> listarSegundos(){
        List<Mimenu> listasegundo=new ArrayList<>();
        Cursor cursor=db.rawQuery("select nommenu from menu where idmenu>=15 and idmenu<=32 ", null);
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
        listasegundos=new ArrayList<>();
        listasegundos.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listasegundos.add(arrayList.get(i).getNommenu());
        }
        return listasegundos;
    }

    public List<Mimenu> listarCombinados(){
        List<Mimenu> listacombinado=new ArrayList<>();
        Cursor cursor=db.rawQuery("select nommenu from menu where idmenu>=6 and idmenu<=14 ", null);
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
        listacombinados=new ArrayList<>();
        listacombinados.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listacombinados.add(arrayList.get(i).getNommenu());
        }
        return listacombinados;
    }
    public List<Cantidad> listarCantidad(){
        List<Cantidad> listacantidad=new ArrayList<>();
        Cursor cursor=db.rawQuery("select nomcantidad from cantidad where idcantidad>=1 and idcantidad<=6 ", null);
        if (cursor.moveToFirst()){
            do{
                Cantidad cantidad=new Cantidad();
                cantidad.setNom_cantidad(cursor.getString(0));
                listacantidad.add(cantidad);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listacantidad;
    }
    public ArrayList<String> obtenerListaCantidad(List<Cantidad> arrayList){
        ArrayList<String> listacantidad;
        listacantidad=new ArrayList<>();
        listacantidad.add("0");
        for (int i=0;i<arrayList.size();i++){
            listacantidad.add(arrayList.get(i).getNom_cantidad());
        }
        return listacantidad;
    }
    public List<Mesa> listarMesa(){
        List<Mesa> listamesa=new ArrayList<>();
        Cursor cursor=db.rawQuery("select nommesa from mesa where idmesa>=1 and idmesa<=10 ", null);
        if (cursor.moveToFirst()){
            do{
                Mesa mesa=new Mesa();
                mesa.setNom_mesa(cursor.getString(0));
                listamesa.add(mesa);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listamesa;
    }
    public ArrayList<String> obtenerListaMesa(List<Mesa> arrayList){
        ArrayList<String> listamesa;
        listamesa=new ArrayList<>();
        listamesa.add("#");
        for (int i=0;i<arrayList.size();i++){
            listamesa.add(arrayList.get(i).getNom_mesa());
        }
        return listamesa;
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
    public void guardarPedido(long id_tab_pedido, int id_caldo,double cantidad_caldo,int id_segundo,double cantidad_segundo,int id_combinado,double cantidad_combinado,int id_mesa){
        ContentValues contentValues = new ContentValues();
        contentValues.put("idpedido",id_tab_pedido);
        contentValues.put("idcaldo",id_caldo);
        contentValues.put("cant_caldo",cantidad_caldo);
        contentValues.put("idsegundo",id_segundo);
        contentValues.put("cant_segundo",cantidad_segundo);
        contentValues.put("idcombinado",id_combinado);
        contentValues.put("cant_combinado",cantidad_combinado);
        contentValues.put("idmesa",id_mesa);
        contentValues.put("fecha_pedido",getDateTime());
        db.insert("pedido",null,contentValues);
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
    public long consultIDTablaPedido () {
        Cursor cursor = db.rawQuery("SELECT MAX(idpedido) FROM pedido;", null);

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
    public int buscarIdMesa(String nombre){
        int id_buscado;
        final String Consulta = "SELECT idmesa FROM mesa WHERE nommesa = ?";
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
        Cursor cursor = db.rawQuery("SELECT nommenu FROM segundo_dia_view WHERE fecha_segundo >='"+fecha_inicial+"'"+" AND fecha_segundo < '"+fecha_final+"'",null);

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
    public List<Combinado> listarCombinadosDia () {
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

        List<Combinado> listadocombinado=new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT nommenu FROM combinado_dia_view WHERE fecha_combinado >='"+fecha_inicial+"'"+" AND fecha_combinado < '"+fecha_final+"'",null);

        if (cursor.moveToFirst()){
            do{
                Combinado combinado=new Combinado();
                combinado.setNombre_combinado(cursor.getString(0));
                listadocombinado.add(combinado);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listadocombinado;
    }
    public ArrayList<String> obtenerListaCombinadosDia(List<Combinado> arrayList){
        ArrayList<String> listacombinadosdia;
        listacombinadosdia=new ArrayList<>();
        listacombinadosdia.add("Seleccione");
        for (int i=0;i<arrayList.size();i++){
            listacombinadosdia.add(arrayList.get(i).getNombre_combinado());
        }
        return listacombinadosdia;
    }
    public List<Caldo> listarIDCaldoDia(){
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

        List<Caldo> listadocaldo=new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT idmenu FROM caldo WHERE fecha_caldo >='"+fecha_inicial+"'"+" AND fecha_caldo < '"+fecha_final+"'",null);

        if (cursor.moveToFirst()){
            do{
                Caldo caldo=new Caldo();
                caldo.setIdmenu(cursor.getInt(0));
                listadocaldo.add(caldo);
            }while (cursor.moveToNext());
        }else{
            Caldo caldo=new Caldo();
            caldo.setIdmenu(0);
            listadocaldo.add(caldo);
            return listadocaldo;
        }
        cursor.close();
        return  listadocaldo;
    }

    public List<MenuDia> listarMenuCaldoDia() {
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

        List<MenuDia> listadomenucaldodia = new ArrayList<>();
        Cursor cursorcaldo = db.rawQuery("SELECT nommenu,stock_caldo,fecha_caldo FROM caldo_dia_view WHERE fecha_caldo >='" + fecha_inicial + "'" + " AND fecha_caldo < '" + fecha_final + "'", null);

        if (cursorcaldo.moveToFirst()) {
            do {
                MenuDia menucaldoDia = new MenuDia();
                menucaldoDia.setNom_menu_dia("Caldo de " + cursorcaldo.getString(0));
                menucaldoDia.setCant_menu_dia(cursorcaldo.getInt(1));
                menucaldoDia.setFecha_menu_dia(cursorcaldo.getString(2));
                listadomenucaldodia.add(menucaldoDia);
            } while (cursorcaldo.moveToNext());
        }
        cursorcaldo.close();
        return listadomenucaldodia;
    }

    public List<MenuDia> listarMenuSegundoDia() {
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

            List<MenuDia> listadomenusegundodia = new ArrayList<>();
            Cursor cursorsegundo = db.rawQuery("SELECT nommenu,stock_segundo,fecha_segundo FROM segundo_dia_view WHERE fecha_segundo >='" + fecha_inicial + "'" + " AND fecha_segundo < '" + fecha_final + "'", null);
            if (cursorsegundo.moveToFirst()) {
                do {
                    MenuDia menusegundoDia = new MenuDia();
                    menusegundoDia.setNom_menu_dia(cursorsegundo.getString(0));
                    menusegundoDia.setCant_menu_dia(cursorsegundo.getInt(1));
                    menusegundoDia.setFecha_menu_dia(cursorsegundo.getString(2));
                    listadomenusegundodia.add(menusegundoDia);
                } while (cursorsegundo.moveToNext());
            }
            cursorsegundo.close();
            return listadomenusegundodia;
        }

    public List<MenuDia> listarMenuCombinadoDia(){
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

                List<MenuDia> listadomenucombinadodia=new ArrayList<>();
        Cursor cursorcombinado = db.rawQuery("SELECT nommenu,stock_combinado,fecha_combinado FROM combinado_dia_view WHERE fecha_combinado >='"+fecha_inicial+"'"+" AND fecha_combinado < '"+fecha_final+"'",null);
        if (cursorcombinado.moveToFirst()){
            do{
                MenuDia menucombinadoDia=new MenuDia();
                menucombinadoDia.setNom_menu_dia(cursorcombinado.getString(0));
                menucombinadoDia.setCant_menu_dia(cursorcombinado.getInt(1));
                menucombinadoDia.setFecha_menu_dia(cursorcombinado.getString(2));
                listadomenucombinadodia.add(menucombinadoDia);
            }while (cursorcombinado.moveToNext());
        }
        cursorcombinado.close();

        return  listadomenucombinadodia;
    }
    public ArrayList<String> obtenerListaMenuDia(List<MenuDia> arrayList){
        ArrayList<String> listamenudia;
        listamenudia=new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            listamenudia.add(String.valueOf(arrayList.get(i).getNom_menu_dia())+" | "+ arrayList.get(i).getCant_menu_dia()+" Platos");
        }
        return listamenudia;
    }
    public List<ReporteDia> listarCombinadosRep () {
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

        List<ReporteDia> listadocombinadorep=new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM reporte_combinado_dia_view WHERE fecha_pedido >='"+fecha_inicial+"'"+" AND fecha_pedido < '"+fecha_final+"'",null);

        if (cursor.moveToFirst()){
            do{
                ReporteDia reporteDia=new ReporteDia();
                reporteDia.setNom_comi(cursor.getString(0));
                reporteDia.setCant_ven(cursor.getInt(1));
                reporteDia.setFecha_repor(cursor.getString(2));
                listadocombinadorep.add(reporteDia);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listadocombinadorep;
    }
    public List<ReporteDia> listarSegundosRep () {
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

        List<ReporteDia> listadosegundorep=new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM reporte_segundo_dia_view WHERE fecha_pedido >='"+fecha_inicial+"'"+" AND fecha_pedido < '"+fecha_final+"'",null);

        if (cursor.moveToFirst()){
            do{
                ReporteDia reporteDia=new ReporteDia();
                reporteDia.setNom_comi(cursor.getString(0));
                reporteDia.setCant_ven(cursor.getInt(1));
                reporteDia.setFecha_repor(cursor.getString(2));
                listadosegundorep.add(reporteDia);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listadosegundorep;
    }
    public List<ReporteDia> listarCaldosRep () {
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

        List<ReporteDia> listadocaldorep=new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM reporte_caldo_dia_view WHERE fecha_pedido >='"+fecha_inicial+"'"+" AND fecha_pedido < '"+fecha_final+"'",null);

        if (cursor.moveToFirst()){
            do{
                ReporteDia reporteDia=new ReporteDia();
                reporteDia.setNom_comi("Caldo de "+cursor.getString(0));
                reporteDia.setCant_ven(cursor.getInt(1));
                reporteDia.setFecha_repor(cursor.getString(2));
                listadocaldorep.add(reporteDia);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listadocaldorep;
    }
    public ArrayList<String> obtenerListaComidaReporte(List<ReporteDia> arrayList){
        ArrayList<String> listacomidarep;
        listacomidarep=new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            listacomidarep.add(String.valueOf(arrayList.get(i).getNom_comi())+" | "+" Se vendieron "+ arrayList.get(i).getCant_ven()+" Plato(s)");
        }
        return listacomidarep;
    }

}
