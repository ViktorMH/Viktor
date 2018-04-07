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
        private static final String ID_CALDO_C="idmenu";
        private static final String STOCK_CALDO="stock_caldo";
        private static final String FECHA_CALDO="fecha_caldo";

        /**TABLA SEGUNDO*/
        private static final String TABLA_SEGUNDO="segundo";
        private static final String ID_SEGUNDO_S="idmenu";
        private static final String STOCK_SEGUNDO="stock_segundo";
        private static final String FECHA_SEGUNDO="fecha_segundo";

        /**TABLA COMBINADO*/
        private static final String TABLA_COMBINADO="combinado";
        private static final String ID_COMBINADO_C="idmenu";
        private static final String STOCK_COMBINADO="stock_combinado";
        private static final String FECHA_COMBINADO="fecha_combinado";

        /**TABLA MESA*/
        private static final String TABLA_MESA="mesa";
        private static final String ID_MESA_M="idmesa";
        private static final String NOMBRE_MESA="nommesa";

        /**TABLA PEDIDO*/
        private static final String TABLA_PEDIDO="pedido";
        private static final String ID_PEDIDO="idpedido";
        private static final String ID_CALDO_P="idcaldo";
        private static final String CANT_CALDO="cant_caldo";
        private static final String ID_SEGUNDO_P="idsegundo";
        private static final String CANT_SEGUNDO="cant_segundo";
        private static final String ID_COMBINADO_P="idcombinado";
        private static final String ID_MESA_P="idmesa";
        private static final String FECHA_PEDIDO="fecha_pedido";
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
                    EntradaAlimentacion.ID_CALDO_C + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.STOCK_CALDO + REAL_TYPE + COMMA_SEP +
                    EntradaAlimentacion.FECHA_CALDO + TIMESTAMP_TYPE + NOT_NULL + CIERRE;

    static final String SQL_CREATE_TABLA_SEGUNDO =
            CREATE_TABLE + EntradaAlimentacion.TABLA_SEGUNDO + APERT +
                    EntradaAlimentacion.ID_SEGUNDO_S + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.STOCK_SEGUNDO + REAL_TYPE + COMMA_SEP +
                    EntradaAlimentacion.FECHA_SEGUNDO + TIMESTAMP_TYPE + NOT_NULL + CIERRE;

    static final String SQL_CREATE_TABLA_COMBINADO =
            CREATE_TABLE + EntradaAlimentacion.TABLA_COMBINADO + APERT +
                    EntradaAlimentacion.ID_COMBINADO_C + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.STOCK_COMBINADO + REAL_TYPE + COMMA_SEP +
                    EntradaAlimentacion.FECHA_COMBINADO + TIMESTAMP_TYPE + NOT_NULL + CIERRE;


    static final String SQL_CREATE_TABLA_MESA =
            CREATE_TABLE + EntradaAlimentacion.TABLA_MESA + APERT +
                    EntradaAlimentacion.ID_MESA_M + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.NOMBRE_MESA + VARCHAR_TYPE + _50 + NOT_NULL + UNIQUE + CIERRE;

    static final String SQL_CREATE_TABLA_PEDIDO =
            CREATE_TABLE + EntradaAlimentacion.TABLA_PEDIDO + APERT +
                    EntradaAlimentacion.ID_PEDIDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_CALDO_P + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.CANT_CALDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_SEGUNDO_P + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.CANT_SEGUNDO + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_COMBINADO_P + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.ID_MESA_P + INTEGER_TYPE + COMMA_SEP +
                    EntradaAlimentacion.FECHA_PEDIDO + TIMESTAMP_TYPE + NOT_NULL + CIERRE;

    /** INSERCION DE DATOS A LA TABLA INSUMO*/
    static final String SQL_INSERT_DATA_TABLA_MENU="INSERT INTO menu (idmenu,nommenu) VALUES " +
            "(1,'Trigo')," + //1
            "(2,'Chaquepa')," + //2
            "(4,'Sémola')," + //4
            "(5,'Quinua')," + //5
            "(6,'Arroz')," + //6

            "(7,'Picante')," + //7
            "(8,'Guiso de Fideos')," + //8
            "(9,'Lentejas')," + //9
            "(10,'Tallarín')," + //10
            "(11,'Arvejitas')," + //11
            "(12,'Pallares')," + //12
            "(13,'Frejoles')," + //13
            "(14,'Chanfainita')," + //14
            "(15,'Cau cau')," + //15

            "(16,'Pollo al horno')," + //16
            "(17,'Bistec a la olla')," + //17
            "(18,'Arroz con pollo')," + //18
            "(19,'Saltado de mollejitas')," + //19
            "(20,'Papa Rellena')," + //20
            "(21,'Asado de carne')," + //21
            "(22,'Asado de pollo')," + //22
            "(23,'Pollo al sillao')," +//23
            "(24,'Carne frita')," +
            "(25,'Pollo Frito')," +
            "(26,'Queso frito')," +
            "(27,'Ají de gallina')," +
            "(28,'Tallarín con pollo')," +
            "(29,'Trucha frita')," +
            "(30,'Hígado frito')," +
            "(31,'Pescado frito')," +
            "(32,'Pejerrey frito');";

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
    static final String SQL_DROP_TABLA_PEDIDO =
            DROP_TABLE_IF_EXISTS + EntradaAlimentacion.TABLA_PEDIDO;

}

