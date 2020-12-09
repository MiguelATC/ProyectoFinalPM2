package com.example.proyectofinalpm2.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofinalpm2.Fragments.ConnectionDB;

public class FacturaControlQR {
    private ConnectionDB connectionDB;

    public FacturaControlQR(Context context){
        connectionDB=new ConnectionDB(context);
    }

    public long newFac(FacturaModelQR facturaModelqr){
        SQLiteDatabase sqLiteDatabase = connectionDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("facturaqrid", facturaModelqr.getFacturaQRId());
        contentValues.put("codigo", facturaModelqr.getCodigo());


        return sqLiteDatabase.insert(connectionDB.getNombreTablaFacturaQr(),null,contentValues);
    }
}
