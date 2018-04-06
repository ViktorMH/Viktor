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

    /** INSERCION DE DATOS A LA TABLA INSUMO*/
    static final String SQL_INSERT_DATA_TABLA_MENU="INSERT INTO menu (idinsumo,nommenu) VALUES " +
            "(1,'Trigo')," + //1
            "(2,'Chaquepa')," + //2
            "(4,'Sémola')," + //4
            "(5,'Quinua')," + //5
            "(6,'Arroz')," + //6
            "(7,'Picante')," + //7

            "(8,'Guiso de Fideos')," + //8
            "(9,'Lentejas')," + //9
            "(10,'Tallarín')," + //10
            "(11,'Piernas de pollo',0.0)," + //11

            "(12,'Porciones para Salchipapas',0.0)," + //12
            "(13,'Porciones para Salchitodo',0.0)," + //13
            "(14,'Porciones para choripapa',0.0)," + //14

            "(15,'Huevos',0.0)," + //15

            "(16,'Vasos de Lemon frozen 14 oz.',0.0)," + //16
            "(17,'Vasos de Chicha morada de 14 oz.',0.0)," + //17
            "(18,'Botellas de Coca cola',0.0)," + //18
            "(19,'Botellas de Fanta',0.0)," + //19
            "(20,'Botellas de Inca Kola',0.0)," + //20
            "(21,'Botellas de Agua mineral',0.0)," + //21
            "(22,'Vasos de 10 oz.',0.0)," + //22
            "(23,'Vasos de oz. desconocidas',0.0)," +//23
            "(24,'Hamurguesa de cordero',0.0)," + //24
            "(25,'Kilométrico',0.0);"; //25

}

