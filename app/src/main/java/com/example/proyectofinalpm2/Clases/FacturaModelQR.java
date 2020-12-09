package com.example.proyectofinalpm2.Clases;

public class FacturaModelQR {
    int facturaQRId;
    String codigo;

    public FacturaModelQR()
    {

    }


    public FacturaModelQR(int facturaQRId, String codigo){
        this.facturaQRId=facturaQRId;
        this.codigo=codigo;
    }
    public FacturaModelQR(String codigo){
        this.codigo=codigo;
    }

    public int getFacturaQRId(){
        return facturaQRId;
    }
    public void setFacturaQRId(int facturaQRId){
        this.facturaQRId=facturaQRId;
    }

    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
}
