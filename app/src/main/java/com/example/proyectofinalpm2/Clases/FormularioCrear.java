package com.example.proyectofinalpm2.Clases;

public class FormularioCrear {

    private int formId;
    private String nombre;
    private String mes;
    private String anio;

    public FormularioCrear(){

    }
    public FormularioCrear(int formId, String nombre, String mes, String anio){
        this.formId=formId;
        this.nombre=nombre;
        this.mes=mes;
        this.anio=anio;
    }

    public FormularioCrear(String nombre, String mes, String anio){
        this.nombre=nombre;
        this.mes=mes;
        this.anio=anio;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
