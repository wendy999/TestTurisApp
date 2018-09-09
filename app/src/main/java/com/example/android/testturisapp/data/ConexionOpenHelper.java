package com.example.android.testturisapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.view.ViewAnimationUtils;

import com.example.android.testturisapp.R;
import com.example.android.testturisapp.menu.Hotel.dummy.ModeloHotel;

public class ConexionOpenHelper extends SQLiteOpenHelper
{
    private static final String DATA_BASE_NAME = "turisapp.db";
    private static final int VERSION = 1;

    public ConexionOpenHelper(Context contexto)
    {
        super(contexto, DATA_BASE_NAME, null, VERSION);
    }

    public interface Tablas
    {
        String HOTEL = "hotel";
        String RESTAURANTE = "restaurante";
        String SITIO = "sitio";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Utilidades.UtilidadesHotel.CREAR_TABLA_HOTEL);
    CargarDatosHotel(db);
    db.execSQL(Utilidades.UtilidadesRestaurante.CREACION_TABLA_RESTAURATE);
    db.execSQL(Utilidades.UtilidadesSitios.CREAR_TABLA_SITIO);
}
    public void CargarDatosHotel(SQLiteDatabase db)
    {
        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));

        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));

        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));
        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));
        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));
    }

    public long CargarHotel(SQLiteDatabase db,ModeloHotel.Hotel hotel)
    {
        return db.insert(Tablas.HOTEL,null,hotel.contentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.HOTEL);
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.RESTAURANTE);
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.SITIO);
        this.onCreate(db);
    }
}
