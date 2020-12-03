package com.example.proyectofinalpm2.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinalpm2.Clases.FormularioCrear;
import com.example.proyectofinalpm2.Clases.Listar;
import com.example.proyectofinalpm2.R;

import java.util.ArrayList;

public class ListaForm extends Fragment {
    private RecyclerView rvListaForms;
    private ArrayList<FormularioCrear> listaForms;
    private Listar listar;
    private String mes,anio;
    private int  formId;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listaform ,container,false);
        rvListaForms = view.findViewById(R.id.rvListaForms);
        rvListaForms.setLayoutManager(new GridLayoutManager(getContext(),1));
        cargarRecyclerView();
        return view;
    }

    private void cargarRecyclerView(){
        listaForms = new ArrayList<FormularioCrear>();
        DBlista();
        listar =  new Listar(listaForms);

        listar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                formId = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getFormId();
                mes = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getMes();
                anio = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getAnio();
                return false;
            }
        });

        /*listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getContext(),ActivityBill.class);
                int idForm = listForm.get(rvListForms.getChildAdapterPosition(v)).getIdForm();
                String name = listForm.get(rvListForms.getChildAdapterPosition(v)).getName();
                String month = listForm.get(rvListForms.getChildAdapterPosition(v)).getMonth();
                int year = listForm.get(rvListForms.getChildAdapterPosition(v)).getYear();
                bundle.putInt("idForm", idForm);
                bundle.putString("nameForm",name);
                bundle.putString("monthForm",month);
                bundle.putInt("yearForm",year);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });*/
        rvListaForms.setAdapter(listar);
    }

    private void DBlista() {


        ConnectionDB connectionDB = new ConnectionDB(getContext());
        SQLiteDatabase sqLiteDatabase= connectionDB.getReadableDatabase();


        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM form WHERE estado = 1",null);

        if(cursor.moveToNext()){
            do{
                FormularioCrear formularioCrear = new FormularioCrear(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)

                );
                listaForms.add(formularioCrear);
            }while(cursor.moveToNext());
        }
    }
}
