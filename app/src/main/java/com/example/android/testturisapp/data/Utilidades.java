package com.example.android.testturisapp.data;

import android.provider.BaseColumns;

public class Utilidades
{
    public static abstract class UtilidadesHotel implements BaseColumns
    {
    public final static String TABLA_HOTEL="hotel";
    public final static String HOTEL_NOMBRE="nombre";
    public final static String HOTEL_DESCRIPCION="descripcion";
    public final static String HOTEL_UBICACION="ubicacion";
    public final static String IMAGEN="imagen";

    public static final String CREAR_TABLA_HOTEL="CREATE TABLE "+TABLA_HOTEL+"("
                                            +_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                            HOTEL_NOMBRE+"TEXT,"+HOTEL_DESCRIPCION+"TEXT,"+HOTEL_UBICACION+"TEXT,"+IMAGEN+"INTEGER)";

    }

    public static abstract class UtilidadesSitios implements BaseColumns
    {
        public static final String TABLA_SITIO="sitio";
        public static final String SITIO_NOMBRE="nombre";
        public static final String SITIO_DESCRIPCION="descripcion";
        public static final String SITIO_UBICACION="ubicacion";
        public static final String SITIO_IMAGEN="imagen";

        public static final String CREAR_TABLA_SITIO="CREATE TABLE "+TABLA_SITIO+"("+
                                                _ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                                SITIO_NOMBRE+" TEXT,"+SITIO_DESCRIPCION+ " TEXT,"+SITIO_UBICACION+" TEXT,"+SITIO_IMAGEN+" TEXT)";
    }

    public static abstract class UtilidadesRestaurante implements BaseColumns
    {
        public static final String TABLA_RESTAURANTE="restaurante";
        public static final String RESTAURANTE_NOMBRE="nombre";
        public static final String RESTAURANTE_DESCRIPCION="descripcion";
        public static final String RESTAURANTE_UBIICACION="ubicacion";
        public static final String RESTAURANTE_IMAGEN=" imagen";

        public static final String CREACION_TABLA_RESTAURATE="CREATE TABLE "+TABLA_RESTAURANTE+"("+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            RESTAURANTE_NOMBRE+" TEXT,"+RESTAURANTE_DESCRIPCION+" TEXT,"+RESTAURANTE_UBIICACION+" TEXT,"+RESTAURANTE_IMAGEN+" TEXT)";
    }
}
