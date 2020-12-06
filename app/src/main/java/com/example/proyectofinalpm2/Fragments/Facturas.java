package com.example.proyectofinalpm2.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Facturas extends AppCompatActivity {

    int formId;
    String mes, anio, nombre;
    private FragmentCrearFac fragmentCrearFac;
    private FragmentListFac fragmentListFac;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        Bundle bundle = getIntent().getExtras();

        formId = bundle.getInt("formId");
        nombre = bundle.getString("nombre");
        mes = bundle.getString("mes");
        anio = bundle.getString("anio");

        Bundle bundleArgs = new Bundle();
        bundleArgs.putInt("formId",formId);
        bundleArgs.putString("nombre",nombre);
        bundleArgs.putString("mes",mes);
        bundleArgs.putString("anio",anio);

        FragmentListFac fragmenListFac = new FragmentListFac();

    }
}
