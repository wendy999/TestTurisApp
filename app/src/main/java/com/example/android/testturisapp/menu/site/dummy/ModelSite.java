package com.example.android.testturisapp.menu.site.dummy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.view.Display;


import com.example.android.testturisapp.data.Utilidades;
import com.example.android.testturisapp.data.crud.CrudSite;

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
public class ModelSite {

    private CrudSite crudSite;
    private static ModelSite modelSite = null;
    /**
     * An array of sample (dummy) items.
     */
    public static final List<Site> ITEMS = new ArrayList<Site>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Site> ITEM_MAP = new HashMap<String, Site>();

    private ModelSite(Context context)
    {
        this.crudSite = CrudSite.getInstance(context);
        this.loadSites();
    }

    public static ModelSite getInstance(Context context){

        if (modelSite == null)
        {
            modelSite = new ModelSite(context);
        }
        return modelSite;
    }

    private void loadSites() {

        Cursor cursorSites = this.crudSite.searchSites();

        while ( cursorSites.moveToNext( ))
        {
            Site site = new Site(cursorSites);
            addSite(site);
        }
    }


    /*
    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }*/

    private static String generateId(){

        return UUID.randomUUID().toString();
    }

    private static void addSite(Site site) {
        ITEMS.add(site);
        ITEM_MAP.put(site.id, site);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class Site {
        public final String id;
        public final String name;
        public final String description;
        public final String ubication;
        public final int image;

        public Site(String name, String description, String ubication, int Image) {
            this.id = ModelSite.generateId();
            this.name = name;
            this.description = description;
            this.ubication = ubication;
            this.image = Image;
        }

        public Site(Cursor cursor)
        {
            this.id=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesSitios._ID ));
            this.name=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesSitios.SITIO_NOMBRE));
            this.description=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesSitios.SITIO_DESCRIPCION));
            this.ubication=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesSitios.SITIO_UBICACION));
            this.image=cursor.getInt(cursor.getColumnIndex(Utilidades.UtilidadesSitios.SITIO_IMAGEN));
        }

        public ContentValues contentValues()
        {
            ContentValues values=new ContentValues();

            values.put(Utilidades.UtilidadesSitios.SITIO_NOMBRE,getName());
            values.put(Utilidades.UtilidadesSitios.SITIO_DESCRIPCION, getDescription());
            values.put(Utilidades.UtilidadesSitios.SITIO_UBICACION, getUbication());
            values.put(Utilidades.UtilidadesSitios.SITIO_IMAGEN, getImage());

            return values;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getUbication() {
            return ubication;
        }

        public int getImage() {
            return image;
        }

    }
}
