package com.example.proyectofinalpm2.Fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectofinalpm2.Clases.FormularioCrear;

public class ConnectionDB extends SQLiteOpenHelper {
    private static final String NOMBRE_BASE_DE_DATOS = "qrproject.db",  NOMBRE_TABLA_FORM = "form";
    private static final int VERSION_BASE_DE_DATOS = 1;

    public static String getNombreBaseDeDatos(){
        return NOMBRE_BASE_DE_DATOS;
    }

    public static String getNombreTablaForm() {
        return NOMBRE_TABLA_FORM;
    }

    public static int getVersionBaseDeDatos(){
        return VERSION_BASE_DE_DATOS;
    }

    public ConnectionDB(@Nullable Context context){
        super(context, NOMBRE_BASE_DE_DATOS,null,VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(formId INTEGER PRIMARY KEY AUTOINCREMENT,mes TEXT NOT NULL, anio TEXT NOT NULL, estado DEFAULT 1);",NOMBRE_TABLA_FORM));

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void Insert(FormularioCrear formularioCrear) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
           db.execSQL("INSERT INTO form(mes, anio) VALUES('" + formularioCrear.getMes() +"', '"+ formularioCrear.getAnio() +"');");
           // db.execSQL("INSERT INTO form(mes, anio) VALUES('Enero', '2020');");
            db.close();
        }
    }
}
