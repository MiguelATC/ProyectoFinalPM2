package com.example.proyectofinalpm2.Clases;

public class FormularioCrear {

    private int formId;
    private String mes;
    private String anio;

    public FormularioCrear(){

    }
    public FormularioCrear(int formId, String mes, String anio){
        this.formId=formId;
        this.mes=mes;
        this.anio=anio;
    }

    public FormularioCrear(String mes, String anio){
        this.mes=mes;
        this.anio=anio;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

}
