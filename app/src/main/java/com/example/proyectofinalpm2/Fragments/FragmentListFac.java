package com.example.proyectofinalpm2.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinalpm2.Clases.FacturaModel;
import com.example.proyectofinalpm2.R;

import java.util.ArrayList;

public class FragmentListFac extends Fragment {

    private RecyclerView rvListaFactura;
    private View view;
    private ListarFactura adapter;
    private ArrayList<FacturaModel> listaFactura;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_listafac, container,false);
        int id = getArguments().getInt("formId");
        String nombre = getArguments().getString("nombre");
        String mes = getArguments().getString("mes");
        String anio = getArguments().getString("anio");
        rvListaFactura = view.findViewById(R.id.rvListaFactura);
        rvListaFactura.setLayoutManager(new GridLayoutManager(getContext(),1));
        cargarRecyclerView();
        return view;
    }
    private void cargarListaBDD(){

    }

    private void cargarRecyclerView(){
        listaFactura = new ArrayList<FacturaModel>();
        cargarListaBDD();
        adapter = new ListarFactura(listaFactura);
        rvListaFactura.setAdapter(adapter);

    }

}
