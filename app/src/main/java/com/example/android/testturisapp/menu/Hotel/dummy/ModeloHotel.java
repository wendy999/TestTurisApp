package com.example.android.testturisapp.menu.Hotel.dummy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.android.testturisapp.data.Utilidades;
import com.example.android.testturisapp.data.crud.CrudHotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ModeloHotel {
    private CrudHotel crudHotel;
    private static ModeloHotel modeloHotel =null;

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Hotel> ITEMS = new ArrayList<Hotel>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Hotel> ITEM_MAP = new HashMap<String, Hotel>();

    // CONSTRUCTOR
    private ModeloHotel(Context context)
    {
        this.crudHotel = CrudHotel.getInstance(context);
        this.cargarHoteles();
    }

    // Instancia del pojo Hotel
    public static ModeloHotel getInstance(Context context)
    {
        if (modeloHotel==null)
        {
            modeloHotel = new ModeloHotel(context);
        }
        return modeloHotel;
    }

    //  Cargar objetos Hoteles
    private void cargarHoteles()
    {
        Cursor cursorHoteles = this.crudHotel.buscarHoteles();

        while (cursorHoteles.moveToNext(   ))
        {
            Hotel hotel = new Hotel(cursorHoteles);

            addItem(hotel);
        }
    }
    // Generar Id Automatico
    private static String generarId()
    {
        return UUID.randomUUID().toString();
    }

    private static void addItem(Hotel hotel) {
        ITEMS.add(hotel);
        ITEM_MAP.put(hotel.id, hotel);
    }

    public static class Hotel {
        public final String id;
        public final String nombre;
        public final String descripcion;
        public final String ubicacion;
        public final int imagen;

        public Hotel( String nombre, String descripcion, String ubicacion, int imagen)
        {
            this.id = ModeloHotel.generarId();
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.ubicacion = ubicacion;
            this.imagen = imagen;
        }
        public Hotel(Cursor cursor)
        {
            this.id=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesHotel._ID ));
            this.nombre=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesHotel.HOTEL_NOMBRE));
            this.descripcion=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesHotel.HOTEL_DESCRIPCION));
            this.ubicacion=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesHotel.HOTEL_UBICACION));
            this.imagen=cursor.getInt(cursor.getColumnIndex(Utilidades.UtilidadesHotel.IMAGEN));
        }

        public ContentValues contentValues()
        {
            ContentValues values=new ContentValues();

            values.put(Utilidades.UtilidadesHotel.HOTEL_NOMBRE,getNombre());
            values.put(Utilidades.UtilidadesHotel.HOTEL_DESCRIPCION,getDescripcion());
            values.put(Utilidades.UtilidadesHotel.HOTEL_UBICACION,getUbicacion());
            values.put(Utilidades.UtilidadesHotel.IMAGEN,getImagen());

            return values;
        }

        public String getId() { return id; }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        public int getImagen() {
            return imagen;
        }

    }

}
