package com.example.android.testturisapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.view.ViewAnimationUtils;

import com.example.android.testturisapp.R;
import com.example.android.testturisapp.menu.Hotel.dummy.ModeloHotel;
import com.example.android.testturisapp.menu.site.dummy.ModelSite;

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
    cargarDatosHotel(db);
    db.execSQL(Utilidades.UtilidadesRestaurante.CREACION_TABLA_RESTAURATE);
    db.execSQL(Utilidades.UtilidadesSitios.CREAR_TABLA_SITIO);
    loadDataSites(db);
}


////////          HOTEL            //////////////////////////////////


    public void cargarDatosHotel(SQLiteDatabase db)
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

    ////////          SITES            //////////////////////////////////



    public void loadDataSites(SQLiteDatabase db)
    {
        LoadSite(db,new ModelSite.Site(
                "Centro Lucy Tejada",
                "This a beautiful place where all the can visit to know about the art, there are books, pictures, and other activities like presentations ",
                " Cra. 10 #16-60, Pereira, Risaralda",
                R.drawable.centrolucytejada));

        LoadSite(db,new ModelSite.Site(
                "Catedral de Nuestra Señora de la Pobreza de Pereira",
                "La Catedral de Nuestra Señora de la Pobreza es la iglesia catedralicia de culto católico ubicada en la ciudad colombiana de Pereira, capital del departamento de Risaralda",
                " Cra. 7, Pereira, Risaralda",
                R.drawable.catedral));

        LoadSite(db,new ModelSite.Site(
                "Plaza de Bolívar",
                "La Plaza de Bolívar es el parque principal de Pereira. Allí se encuentran la Catedral de Nuestra Señora de la Pobreza y el monumento 'Bolívar desnudo', elaborado por el maestro Rodrigo Arenas Betancourt. ",
                "con, Cra. 7, Pereira, Risaralda",
                R.drawable.plazabolivar));
        LoadSite(db,new ModelSite.Site(
                "BioParque Ukumarí",
                "El parque es uno de los mas grandes de Suramérica con 820.00 metros cuadrados. Dentro de este espacio unas 45 hectáreas estarán dedicadas a varias atracciones",
                "Cerritos-Cartago, FONDA CENTRAL, Pereira, Risaralda",
                R.drawable.ukumari));

    }

    public long LoadSite(SQLiteDatabase db, ModelSite.Site site)
    {
        return db.insert(Tablas.SITIO,null, site.contentValues());
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.HOTEL);
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.RESTAURANTE);
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.SITIO);
        this.onCreate(db);
    }
}
