package com.example.proyectofinalpm2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.proyectofinalpm2.Clases.ListarFactura;
import com.example.proyectofinalpm2.Fragments.FragmentCrearFac;
import com.example.proyectofinalpm2.Fragments.FragmentListFac;


public class activity_fac extends AppCompatActivity {
    private Toolbar toolbar;
    private FragmentCrearFac fragmentCrearFac;
    private FragmentListFac fragmentListFac;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    int formId;
    String anio;
    String nombre;
    String mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac);

        Bundle bundle = getIntent().getExtras();
        formId = bundle.getInt("formId");
        anio = bundle.getString("anio");
        nombre = bundle.getString("nombre");
        mes = bundle.getString("mes");

        Bundle bundleArgs = new Bundle();
        bundleArgs.putInt("formId",formId);
        bundleArgs.putString("nombre",nombre);
        bundleArgs.putString("mes",mes);
        bundleArgs.putString("anio",anio);

        FragmentListFac fragmentListFac = new FragmentListFac();
        fragmentListFac.setArguments(bundleArgs);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListaFactura(fragmentListFac);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menufactura, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void ListaFactura(FragmentListFac fragmentListFacA) {
        try {
            DeleteFragment();
            fragmentManager = getSupportFragmentManager();
            fragmentListFac = new FragmentListFac();
            fragmentListFac.setArguments(getIntent().getExtras());
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.panelId, fragmentListFac, "list");
            fragmentTransaction.replace(R.id.fragmentListaFactura, fragmentListFacA);
            fragmentTransaction.commit();
        }
        catch (Exception ex) {
            Toast.makeText(this, "Error: " + ex, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.lista_fac:
                ListaFactura(fragmentListFac);
                break;
            case R.id.agregar_fac:
                Bundle bundleArgs = new Bundle();
                bundleArgs.putInt("formId",formId);
                FragmentCrearFac fragmentCrearFac = new FragmentCrearFac();
                fragmentCrearFac.setArguments(bundleArgs);

                AgregarFac(fragmentCrearFac);
                break;
            case R.id.agregar_facqr:
                Toast.makeText(this, "QR", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.agregar_excel:
                Toast.makeText(this, "Export to Excel", Toast.LENGTH_SHORT).show();
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    private void AgregarFac(FragmentCrearFac fragmentCrearFacArgs) {
        try {
            fragmentManager = getSupportFragmentManager();
            fragmentCrearFac = new FragmentCrearFac();
            fragmentCrearFac.setArguments(getIntent().getExtras());
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.panelId, fragmentCrearFac, "bill");
            fragmentTransaction.replace(R.id.fragmentAgregarFactura, fragmentCrearFacArgs);
            fragmentTransaction.commit();
        } catch (Exception ex) {
            Toast.makeText(this, "Error: " + ex, Toast.LENGTH_SHORT).show();
        }
    }

    private void DeleteFragment() {
        fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag("bill") != null) {
            getSupportFragmentManager().beginTransaction().remove(fragmentCrearFac).commit();
        }
        if(fragmentManager.findFragmentByTag("list") != null) {
            getSupportFragmentManager().beginTransaction().remove(fragmentListFac).commit();
        }
    }


}