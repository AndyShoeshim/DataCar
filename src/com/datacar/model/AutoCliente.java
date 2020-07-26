package com.datacar.model;

import javax.json.bind.annotation.JsonbProperty;

public class AutoCliente {

    @JsonbProperty
    private String targa;

    @JsonbProperty
    private String cod_fiscale;

    @JsonbProperty
    private int auto_id;


    public AutoCliente(){
    }

    public AutoCliente(String targa, String cod_fiscale, int auto_id) {
        this.targa = targa;
        this.cod_fiscale = cod_fiscale;
        this.auto_id = auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    public void setCod_fiscale(String cod_fiscale) {
        this.cod_fiscale = cod_fiscale;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getCod_fiscale() {
        return cod_fiscale;
    }

    public String getTarga() {
        return targa;
    }

    public int getAuto_id() {
        return auto_id;
    }
}
