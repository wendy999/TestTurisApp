package com.example.android.testturisapp.data.crud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.testturisapp.data.ConexionOpenHelper;
import com.example.android.testturisapp.data.Utilidades;

public class CrudHotel
{
        private static ConexionOpenHelper dataBase;
        private static CrudHotel instance = new CrudHotel();

        public CrudHotel() {}

        public static CrudHotel getInstance(Context contexto)
        {
            if (dataBase == null)
            {
                dataBase = new ConexionOpenHelper(contexto);
            }

            return instance;
        }

        public Cursor buscarHoteles()
        {
            SQLiteDatabase db = dataBase.getReadableDatabase();
            String sql = String.format("SELECT * FROM %s ORDER BY %s", ConexionOpenHelper.Tablas.HOTEL, Utilidades.UtilidadesHotel.HOTEL_NOMBRE);
            return db.rawQuery(sql, null);
        }

        public Cursor buscarHotel(String idHotel)
        {
            SQLiteDatabase db = dataBase.getReadableDatabase();
            String sql = String.format("SELECT * FROM %s WHERE %s=%s", ConexionOpenHelper.Tablas.HOTEL, Utilidades.UtilidadesHotel._ID, idHotel);
            return db.rawQuery(sql, null);
        }
}
