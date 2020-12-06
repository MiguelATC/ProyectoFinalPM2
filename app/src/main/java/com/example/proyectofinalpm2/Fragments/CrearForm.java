package com.example.proyectofinalpm2.Fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectofinalpm2.Clases.FormularioCrear;
import com.example.proyectofinalpm2.R;

public class CrearForm extends Fragment {

    private EditText etMes, etAnio,etNombre;
    private Button btnCrear;
    private View view;
    private FormularioCrear formulario;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_crear,container,false);
        etNombre = view.findViewById(R.id.etNombre);
        etMes = view.findViewById(R.id.etMes);
        etAnio = view.findViewById(R.id.etAnio);
        btnCrear = view.findViewById(R.id.btnCrear);

        final ConnectionDB connectionDB = new ConnectionDB(getContext());

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre;
                String mes;
                String anio;

                nombre=etNombre.getText().toString().trim();
                mes = etMes.getText().toString().trim();
                anio = etAnio.getText().toString().trim();

                formulario = new FormularioCrear(nombre, mes, anio);
                connectionDB.Insert(formulario);
                Toast.makeText(getContext(),"Formulario creado",Toast.LENGTH_SHORT).show();

            }
        });

        return view;


    }
}
