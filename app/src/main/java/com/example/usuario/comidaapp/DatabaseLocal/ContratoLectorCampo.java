package com.example.usuario.comidaapp.DatabaseLocal;

import android.provider.BaseColumns;

/**
 * Created by usuario on 06/04/2018.
 */

final class ContratoLectorCampo {
    private ContratoLectorCampo(){
    }
    private class EntradaAlimentacion implements BaseColumns {
        /**TABLA MENU*/
        private static final String TABLA_MENU="menu";
        private static final String ID_MENU="idmenu";
        private static final String NOMBRE_MENU="nommenu";

        /**TABLA CALDO*/
        private static final String TABLA_CALDO="caldo";
        private static final String ID_TABLA_CALDO="idcaldo";
        private static final String ID_CALDO_C="idmenu";
        private static final String STOCK_CALDO="stock_caldo";
        private static final String FECHA_CALDO="fecha_caldo";

        /**TABLA SEGUNDO*/
        private static final String TABLA_SEGUNDO="segundo";
        private static final String ID_TABLA_SEGUNDO="idsegundo";
        private static final String ID_SEGUNDO_S="idmenu";
        private static final String STOCK_SEGUNDO="stock_segundo";
        private static final String FECHA_SEGUNDO="fecha_segundo";

        /**TABLA COMBINADO*/
        private static final String TABLA_COMBINADO="combinado";
        private static final String ID_TABLA_COMBINADO="idcombinado";
        private static final String ID_COMBINADO_C="idmenu";
        private static final String STOCK_COMBINADO="stock_combinado";
        private static final String FECHA_COMBINADO="fecha_combinado";

        /**TABLA MESA*/
        private static final String TABLA_MESA="mesa";
        private static final String ID_MESA_M="idmesa";
        private static final String NOMBRE_MESA="nommesa";

        /**TABLA CANTIDAD*/
        private static final String TABLA_CANTIDAD="cantidad";
        private static final String ID_CANTIDAD="idcantidad";
        private static final String NOMBRE_CANTIDAD="nomcantidad";

        /**TABLA PEDIDO*/
        private static final String TABLA_PEDIDO="pedido";
        private static final String ID_PEDIDO="idpedido";
        private static final String ID_CALDO_P="idcaldo";
        private static final String CANT_CALDO="cant_caldo";
        private static final String ID_SEGUNDO_P="idsegundo";
        private static final String CANT_SEGUNDO="cant_segundo";
        private static final String ID_COMBINADO_P="idcombinado";
        private static final String CANT_COMBINADO="cant_combinado";
        private static final String ID_MESA_P="idmesa";
        private static final String FECHA_PEDIDO="fecha_pedido";

        /**VISTAS**/
        private static final String SEGUNDOS_DIA_VIEW="segundo_dia_view";
        private static final String COMBINADOS_DIA_VIEW="combinado_dia_view";
        private static final String CALDO_DIA_VIEW="caldo_dia_view";
        private static final String REPORTE_SEGUNDO_DIA_VIEW="reporte_segundo_dia_view";
        private static final String REPORTE_COMBINADO_DIA_VIEW="reporte_combinado_dia_view";
        private static final String REPORTE_CALDO_DIA_VIEW="reporte_caldo_dia_view";
    }
    /**Creacion de los códigos SQL*/
    private static final String VARCHAR_TYPE = " VARCHAR";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String INT_8_TYPE = " INT8";
    private static final String REAL_TYPE = " REAL";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";
    private static final String NOT_NULL = " NOT NULL";
    private static final String UNIQUE = " UNIQUE";
    private static final String _50 = " (50)";
    private static final String DEFAULT = " DEFAULT";
    private static final String _0 = " 0";
    private static final String CREATE_TABLE = "CREATE TABLE ";
    private static final String DROP_TABLE_IF_EXISTS="DROP TABLE IF EXISTS ";
    private static final String APERT = " (";
    private static final String CIERRE = " );";
    private static final String COMMA_SEP = ",";
    static final String SQL_CREATE_TABLA_MENU =
            CREATE_TABLE + EntradaAlimentacion.TABLA_MENU + APERT +
                    EntradaAlimentacion.ID_MENU + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.NOMBRE_MENU + VARCHAR_TYPE + _50 + NOT_NULL + UNIQUE + CIERRE;

    static final String SQL_CREATE_TABLA_CALDO =
            CREATE_TABLE + EntradaAlimentacion.TABLA_CALDO + APERT +
                    EntradaAlimentacion.ID_TABLA_CALDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_CALDO_C + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.STOCK_CALDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.FECHA_CALDO + TIMESTAMP_TYPE + NOT_NULL + CIERRE;

    static final String SQL_CREATE_TABLA_SEGUNDO =
            CREATE_TABLE + EntradaAlimentacion.TABLA_SEGUNDO + APERT +
                    EntradaAlimentacion.ID_TABLA_SEGUNDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_SEGUNDO_S + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.STOCK_SEGUNDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.FECHA_SEGUNDO + TIMESTAMP_TYPE + NOT_NULL + CIERRE;

    static final String SQL_CREATE_TABLA_COMBINADO =
            CREATE_TABLE + EntradaAlimentacion.TABLA_COMBINADO + APERT +
                    EntradaAlimentacion.ID_TABLA_COMBINADO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_COMBINADO_C + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.STOCK_COMBINADO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.FECHA_COMBINADO + TIMESTAMP_TYPE + NOT_NULL + CIERRE;


    static final String SQL_CREATE_TABLA_MESA =
            CREATE_TABLE + EntradaAlimentacion.TABLA_MESA + APERT +
                    EntradaAlimentacion.ID_MESA_M + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.NOMBRE_MESA + VARCHAR_TYPE + _50 + NOT_NULL + UNIQUE + CIERRE;

    static final String SQL_CREATE_TABLA_CANTIDAD =
            CREATE_TABLE + EntradaAlimentacion.TABLA_CANTIDAD + APERT +
                    EntradaAlimentacion.ID_CANTIDAD + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.NOMBRE_CANTIDAD + VARCHAR_TYPE + _50 + NOT_NULL + UNIQUE + CIERRE;

    static final String SQL_CREATE_TABLA_PEDIDO =
            CREATE_TABLE + EntradaAlimentacion.TABLA_PEDIDO + APERT +
                    EntradaAlimentacion.ID_PEDIDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_CALDO_P + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.CANT_CALDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_SEGUNDO_P + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.CANT_SEGUNDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_COMBINADO_P + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.CANT_COMBINADO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_MESA_P + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.FECHA_PEDIDO + TIMESTAMP_TYPE + NOT_NULL + CIERRE;

    /** INSERCION DE DATOS A LA TABLA MENU*/
    static final String SQL_INSERT_DATA_TABLA_MENU="INSERT INTO menu (idmenu,nommenu) VALUES " +
            "(1,'Arroz')," +
            "(2,'Chaquepa')," +
            "(3,'Quinua')," +
            "(4,'Sémola')," +
            "(5,'Trigo')," +

            "(6,'Arvejitas')," +
            "(7,'Cau cau')," +
            "(8,'Chanfainita')," +
            "(9,'Frejoles')," +
            "(10,'Guiso de Fideos')," +
            "(11,'Lentejas')," +
            "(12,'Pallares')," +
            "(13,'Picante')," +
            "(14,'Tallarín')," +

            "(15,'Pollo al horno')," +
            "(16,'Bistec a la olla')," +
            "(17,'Arroz con pollo')," +
            "(18,'Saltado de mollejitas')," +
            "(19,'Papa Rellena')," +
            "(20,'Asado de carne')," +
            "(21,'Asado de pollo')," +
            "(22,'Pollo al sillao')," +
            "(23,'Carne frita')," +
            "(24,'Pollo Frito')," +
            "(25,'Queso frito')," +
            "(26,'Ají de gallina')," +
            "(27,'Tallarín con pollo')," +
            "(28,'Trucha frita')," +
            "(29,'Hígado frito')," +
            "(30,'Pescado frito')," +
            "(31,'Pejerrey frito')," +
            "(32,'Picante de Guata');";

    /** INSERCION DE DATOS A LA TABLA MESA*/
    static final String SQL_INSERT_DATA_TABLA_MESA="INSERT INTO mesa (idmesa,nommesa) VALUES " +
            "(1,'Llevar')," +
            "(2,'1')," +
            "(3,'2')," +
            "(4,'3')," +
            "(5,'4')," +
            "(6,'5')," +
            "(7,'6')," +
            "(8,'7')," +
            "(9,'8')," +
            "(10,'9');";

    /** INSERCION DE DATOS A LA TABLA CANTIDAD*/
    static final String SQL_INSERT_DATA_TABLA_CANTIDAD="INSERT INTO cantidad (idcantidad,nomcantidad) VALUES " +
            "(1,'1')," +
            "(2,'2')," +
            "(3,'3')," +
            "(4,'4')," +
            "(5,'5')," +
            "(6,'6')," +
            "(7,'7')," +
            "(8,'8')," +
            "(9,'9')," +
            "(10,'10');";

    /**CREACION DE VISTAS**/
    static final String SQL_CREATE_VIEW_SEGUNDO_DIA="CREATE VIEW segundo_dia_view AS \n" +
            "SELECT nommenu,stock_segundo,fecha_segundo\n" +
            "FROM segundo INNER JOIN menu ON\n" +
            "segundo.idmenu=menu.idmenu ;";

    static final String SQL_CREATE_VIEW_COMBINADO_DIA="CREATE VIEW combinado_dia_view AS \n" +
            "SELECT nommenu,stock_combinado,fecha_combinado\n" +
            "FROM combinado INNER JOIN menu ON\n" +
            "combinado.idmenu=menu.idmenu ;";

    static final String SQL_CREATE_VIEW_CALDO_DIA="CREATE VIEW caldo_dia_view AS \n" +
            "SELECT nommenu,stock_caldo,fecha_caldo\n" +
            "FROM caldo INNER JOIN menu ON\n" +
            "caldo.idmenu=menu.idmenu ;";

    static final String SQL_CREATE_VIEW_REPORTE_SEGUNDO_DIA="CREATE VIEW reporte_segundo_dia_view AS \n" +
            "SELECT menu.nommenu as segundos,SUM(cant_segundo) as total_segundos,fecha_pedido\n" +
            "FROM pedido INNER JOIN menu ON\n" +
            "pedido.idsegundo=menu.idmenu" +
            " GROUP BY menu.nommenu;";

    static final String SQL_CREATE_VIEW_REPORTE_COMBINADO_DIA="CREATE VIEW reporte_combinado_dia_view AS \n" +
            "SELECT menu.nommenu as combinados,SUM(cant_combinado) as total_combinados,fecha_pedido\n" +
            "FROM pedido INNER JOIN menu ON\n" +
            "pedido.idcombinado=menu.idmenu" +
            " GROUP BY menu.nommenu;";

    static final String SQL_CREATE_VIEW_REPORTE_CALDO_DIA="CREATE VIEW reporte_caldo_dia_view AS \n" +
            "SELECT menu.nommenu as caldos,SUM(cant_caldo) as total_caldos,fecha_pedido\n" +
            "FROM pedido INNER JOIN menu ON\n" +
            "pedido.idcaldo=menu.idmenu" +
            " GROUP BY menu.nommenu;";

    static final String SQL_DROP_TABLA_MENU =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.TABLA_MENU;
    static final String SQL_DROP_TABLA_CALDO =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.TABLA_CALDO;
    static final String SQL_DROP_TABLA_SEGUNDO =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.TABLA_SEGUNDO;
    static final String SQL_DROP_TABLA_COMBINADO =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.TABLA_COMBINADO;
    static final String SQL_DROP_TABLA_MESA =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.TABLA_MESA;
    static final String SQL_DROP_TABLA_CANTIDAD =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.TABLA_CANTIDAD;
    static final String SQL_DROP_TABLA_PEDIDO =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.TABLA_PEDIDO;
    static final String SQL_DROP_VIEW_SEGUNDOS_DIA =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.SEGUNDOS_DIA_VIEW;
    static final String SQL_DROP_VIEW_COMBINADOS_DIA =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.COMBINADOS_DIA_VIEW;
    static final String SQL_DROP_VIEW_CALDO_DIA =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.CALDO_DIA_VIEW;
    static final String SQL_DROP_VIEW_REPORTE_SEGUNDO_DIA =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.REPORTE_SEGUNDO_DIA_VIEW;
    static final String SQL_DROP_VIEW_REPORTE_COMBINADO_DIA =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.REPORTE_COMBINADO_DIA_VIEW;
    static final String SQL_DROP_VIEW_REPORTE_CALDO_DIA =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.REPORTE_CALDO_DIA_VIEW;
}

