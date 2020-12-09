package com.example.proyectofinalpm2.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectofinalpm2.Clases.FacturaControlQR;
import com.example.proyectofinalpm2.Clases.FacturaModelQR;
import com.example.proyectofinalpm2.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class FragmentCrearFacQR extends Fragment {
    private TextView txtQr;
    private View view;
    private Button btnGuardarCodigo;
    private FacturaModelQR facturaModelQR;
    private FacturaControlQR facturaControlQR;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listafacqr, container,false);

        txtQr = view.findViewById(R.id.txtQr);
        btnGuardarCodigo = view.findViewById(R.id.btnGuardarCodigo);

        facturaControlQR = new FacturaControlQR(getContext());

        btnGuardarCodigo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String codigo;
                codigo = txtQr.getText().toString();

                facturaModelQR = new FacturaModelQR(codigo);

                long insert = facturaControlQR.newFac(facturaModelQR);
                if (insert == -1) {
                    Toast.makeText(getContext(),"Error: Unrecorded invoice",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Insert Exitoso", Toast.LENGTH_LONG).show();

                }
            }
        });

        return view;
    }
}
