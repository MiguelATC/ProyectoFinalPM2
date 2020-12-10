package com.example.proyectofinalpm2.Fragments;

import android.app.DatePickerDialog;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import com.example.proyectofinalpm2.Clases.DatePickerFragment;
import com.example.proyectofinalpm2.Clases.FacturaControl;
import com.example.proyectofinalpm2.Clases.FacturaModel;
import com.example.proyectofinalpm2.R;

import java.util.Calendar;

public class FragmentCrearFac extends Fragment {
    private EditText etNIT, etNroFactura, etNroAutorizacion, etCodigoControl,etFecha,etImporte;
    private Button btnCrearFactura;
    private View view;
    private FacturaModel facturaModel;
    private FacturaControl facturaControl;
    private int idForm;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_crearfac, container, false);

        etNIT = view.findViewById(R.id.etNIT);
        etNroFactura = view.findViewById(R.id.etNroFac);
        etNroAutorizacion = view.findViewById(R.id.etNroAutorizacion);
        etImporte = view.findViewById(R.id.etImporte);
        etCodigoControl = view.findViewById(R.id.etCodigoControl);
        etFecha = view.findViewById(R.id.etFecha);
        btnCrearFactura = view.findViewById(R.id.btnCrearFactura);

        facturaControl = new FacturaControl(getContext());
        idForm = getArguments().getInt("formId");
        btnCrearFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String NIT, nroFactura, nroAutorizacion, fecha, codigoControl, importe;
                    NIT = etNIT.getText().toString().trim();
                    nroFactura = etNroFactura.getText().toString().trim();
                    nroAutorizacion = etNroAutorizacion.getText().toString().trim();
                    fecha = etFecha.getText().toString().trim();
                    codigoControl = etCodigoControl.getText().toString().trim();
                    importe = etImporte.getText().toString().trim();
                    int nit = Integer.parseInt(NIT);
                    int nroFac = Integer.parseInt(nroFactura);
                    int nroAut = Integer.parseInt(nroAutorizacion);
                    double importeFac = Double.parseDouble(importe);
                    facturaModel = new FacturaModel(nit, nroFac, nroAut, importeFac, fecha, codigoControl, idForm);

                    long insert = facturaControl.newFac(facturaModel);
                    if (insert == -1) {
                        Toast.makeText(getContext(),"Error: Unrecorded invoice",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "datos almacenados", Toast.LENGTH_LONG).show();
                        Limpiar();

                    }
                }
                catch (Exception ex){
                    Toast.makeText(getContext(), "Error: " + ex, Toast.LENGTH_LONG).show();
                }

            }
        });

        etFecha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        return view;
    }
    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = twoDigits(day) + " / " + twoDigits(month + 1) + " / " + year;
                Calendar cal = Calendar.getInstance();
                if (day > cal.get(Calendar.DAY_OF_MONTH) || month > cal.get(Calendar.MONTH) || year > cal.get(Calendar.YEAR)) {
                    etFecha.setError("The date can't be higher than today's");
                    etFecha.requestFocus();
                } else {
                    etFecha.setText(selectedDate);
                }
            }
        });
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }
    private String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }

    private void Limpiar() {
        etNIT.setText("");
        etNroAutorizacion.setText("");
        etFecha.setText("");
        etCodigoControl.setText("");
        etImporte.setText("");
        etNroFactura.setText("");

    }
}
