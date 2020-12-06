package com.example.proyectofinalpm2.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.proyectofinalpm2.Clases.FacturaControl;
import com.example.proyectofinalpm2.Clases.FacturaModel;

public class FragmentCrearFac extends Fragment {
    private EditText etNit, etNroFactura, etNroAutorizacion, etCodigoControl,etFecha;
    private Button btnAgregarFac;
    private View view;
    private FacturaModel facturaModel;
    private FacturaControl facturaControl;
    private int idForm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_bill, container, false);
        etNit = view.findViewById(R.id.etNit);
        etNroFactura = view.findViewById(R.id.etNroFactura);
        etNroAutorizacion = view.findViewById(R.id.etNroAutorizacion);
        etAmount = view.findViewById(R.id.etAmount);
        etCodigoControl = view.findViewById(R.id.etCodigoControl);
        etFecha = view.findViewById(R.id.etFecha);
        btnAgregarFac = view.findViewById(R.id.btnAddBill);
        facturaControl = new FacturaControl(getContext());

        idForm = getArguments().getInt("formId");
        btnAgregarFac


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
