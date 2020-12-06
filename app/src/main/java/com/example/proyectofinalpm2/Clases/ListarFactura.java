package com.example.proyectofinalpm2.Clases;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinalpm2.R;

import java.util.ArrayList;

public class ListarFactura extends RecyclerView.Adapter<ListarFactura.ViewHolderDatos> {

    ArrayList<FacturaModel> listaFactura;

    public ListarFactura(ArrayList<FacturaModel> listaFactura){
        this.listaFactura=listaFactura;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_listfacform,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.Data(listaFactura.get(position));
    }

    @Override
    public int getItemCount() {
        return listaFactura.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView tvIdFac, tvNroFactura, tvFecha, tvImporte;
        LinearLayout linearLayout;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tvIdFac = itemView.findViewById(R.id.tvIdFacF);
            tvNroFactura = itemView.findViewById(R.id.tvNroFacturaF);
            tvFecha = itemView.findViewById(R.id.tvFechaF);
            tvImporte = itemView.findViewById(R.id.tvImporteF);
            linearLayout = itemView.findViewById(R.id.lyFormat);
            linearLayout.setOnCreateContextMenuListener(this);
        }

        public void Data(FacturaModel facturaModel) {
            tvIdFac.setText(String.valueOf(facturaModel.getFacturaId()));
            tvNroFactura.setText(String.valueOf(facturaModel.getNroFac()));
            tvFecha.setText(facturaModel.getFecha());
            tvImporte.setText(String.valueOf(facturaModel.getImporte()));
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Select an option");
            contextMenu.add(getAdapterPosition(), 101, 0, "Edit");
            contextMenu.add(getAdapterPosition(), 102, 1, "Delete");

        }
    }


}

