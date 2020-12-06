package com.example.proyectofinalpm2.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofinalpm2.Fragments.ConnectionDB;

public class FacturaControl {
    private ConnectionDB connectionDB;

    public FacturaControl(Context context){
        connectionDB=new ConnectionDB(context);
    }

    public long newFac(FacturaModel facturaModel){
        SQLiteDatabase sqLiteDatabase = connectionDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NIT", facturaModel.getNIT());
        contentValues.put("nroFactura", facturaModel.getNroFac());
        contentValues.put("nroAutorizacion", facturaModel.getNroAutorizacion());
        contentValues.put("importe", facturaModel.getImporte());
        contentValues.put("fecha", facturaModel.getFecha());
        contentValues.put("codigoControl", facturaModel.getCodigoControl());
        contentValues.put("formId", facturaModel.getFormId());

        return sqLiteDatabase.insert(connectionDB.getNombreTablaFactura(),null,contentValues);
    }
}
