package com.datacar.model;

import javax.json.bind.annotation.JsonbProperty;

public class AutoCliente {

    @JsonbProperty
    private String targa;

    @JsonbProperty
    private String cod_fiscale;

    public AutoCliente(){
    }

    public AutoCliente(String targa, String cod_fiscale) {
        this.targa = targa;
        this.cod_fiscale = cod_fiscale;
    }

    public String getCod_fiscale() {
        return cod_fiscale;
    }

    public String getTarga() {
        return targa;
    }
}
