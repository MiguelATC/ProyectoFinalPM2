package com.example.proyectofinalpm2.Clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinalpm2.R;

import java.util.ArrayList;

public class Listar extends RecyclerView.Adapter<Listar.ViewHolderDatos> implements View.OnClickListener, View.OnLongClickListener{

    ArrayList<FormularioCrear> listaForm;
    private View.OnClickListener listener;
    private View.OnLongClickListener longListener;

    public Listar(ArrayList<FormularioCrear> listaForm){
        this.listaForm = listaForm;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentitems,null,false);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.Datos(listaForm.get(position));
    }

    @Override
    public int getItemCount() {
        return listaForm.size();
    }

    @Override
    public void onClick(View view) {
        if (listener !=null){
            listener.onClick(view);
        }

    }

    @Override
    public boolean onLongClick(View view) {
        if (longListener != null){
            longListener.onLongClick(view);
        }
        return false;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements  View.OnCreateContextMenuListener{
        TextView tvMes, tvAnio, tvFormId;
        LinearLayout linearLayout;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tvFormId = itemView.findViewById(R.id.tvFormId);
            tvMes = itemView.findViewById(R.id.tvMes);
            tvAnio = itemView.findViewById(R.id.tvAnio);
            linearLayout = itemView.findViewById(R.id.lyItems);
            linearLayout.setOnCreateContextMenuListener(this);
        }

        public void Datos(FormularioCrear formularioCrear) {
            tvFormId.setText(String.valueOf(formularioCrear.getFormId()));
            tvMes.setText("Año: " + formularioCrear.getMes());
            tvAnio.setText("Mes: " + formularioCrear.getAnio());
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select an option");
            menu.add(getAdapterPosition(), 1001, 0, "Edit Form");
            menu.add(getAdapterPosition(), 1002, 1, "Delete Form");

        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    public void setOnLongClickListener(View.OnLongClickListener longListener) {this.longListener = longListener;}




}
