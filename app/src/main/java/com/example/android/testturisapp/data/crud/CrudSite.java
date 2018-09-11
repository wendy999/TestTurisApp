package com.example.android.testturisapp.data.crud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.testturisapp.data.ConexionOpenHelper;
import com.example.android.testturisapp.data.Utilidades;

/**
 * Created by android on 11/09/2018.
 */

public class CrudSite {

    private static ConexionOpenHelper dataBase;
    private static CrudSite instance = new CrudSite();

    public CrudSite(){
    }

    public static CrudSite getInstance(Context context)
    {
        if(dataBase == null)

        {
            dataBase = new ConexionOpenHelper(context);
        }

        return instance;
    }

    public Cursor searchSites()

    {

        SQLiteDatabase db = dataBase.getReadableDatabase();
        String sql = String.format("SELECT * FROM %s ORDER BY %s", ConexionOpenHelper.Tablas.RESTAURANTE, Utilidades.UtilidadesRestaurante.RESTAURANTE_NOMBRE);
        return  db.rawQuery(sql, null);
    }

    public  Cursor searchSite(String idSite)
    {
        SQLiteDatabase db = dataBase.getReadableDatabase();
        String sql = String.format(" SELECT * FROM %s WHERE %s=%s", ConexionOpenHelper.Tablas.RESTAURANTE, Utilidades.UtilidadesRestaurante._ID, idSite);
        return  db.rawQuery(sql, null);
    }
}
