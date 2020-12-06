package com.example.proyectofinalpm2.Clases;

public class FacturaModel {
    int facturaId;
    int formId;
    int NIT;
    int nroFac;
    int nroAutorizacion;
    String fecha;
    String codigoControl;
    double importe;

    public FacturaModel()
    {

    }
    public FacturaModel(int facturaId, int NIT, int nroFac, int nroAutorizacion, double importe, String fecha, String codigoControl, int formId) {
        this.facturaId = facturaId;
        this.NIT = NIT;
        this.nroFac = nroFac;
        this.nroAutorizacion=nroAutorizacion;
        this.importe=importe;
        this.fecha=fecha;
        this.codigoControl=codigoControl;
        this.formId=formId;

    }
    public FacturaModel(int NIT, int nroFac, int nroAutorizacion, double importe, String fecha, String codigoControl, int formId)
    {
        this.NIT=NIT;
        this.nroFac=nroFac;
        this.nroAutorizacion=nroAutorizacion;
        this.importe=importe;
        this.fecha=fecha;
        this.codigoControl=codigoControl;
        this.formId=formId;

    }
    public FacturaModel(int facturaId, int nroFac, String fecha, int importe)
    {
        this.facturaId=facturaId;
        this.nroFac=nroFac;
        this.fecha=fecha;
        this.importe=importe;
    }

    public int getFacturaId(){
        return facturaId;
    }
    public void setFacturaId(int facturaId){
        this.facturaId=facturaId;
    }

    public int getFormId(){
        return formId;
    }
    public void setFormId(int formId){
        this.formId=formId;
    }

    public int getNIT(){
        return NIT;
    }
    public void setNIT(int NIT){
        this.NIT=NIT;
    }

    public int getNroFac(){
        return nroFac;
    }
    public void setNroFac(int nroFac){
        this.nroFac=nroFac;
    }

    public int getNroAutorizacion(){
        return nroAutorizacion;
    }
    public void setNroAutorizacion(int nroAutorizacion){
        this.nroAutorizacion=nroAutorizacion;
    }

    public double getImporte(){
        return importe;
    }
    public void setImporte(double importe){
        this.importe=importe;
    }

    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }

    public String getCodigoControl(){
        return codigoControl;
    }
    public void setCodigoControl(String codigoControl){
        this.codigoControl=codigoControl;
    }

}
