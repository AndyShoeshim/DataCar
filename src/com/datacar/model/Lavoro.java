package com.datacar.model;

import javax.json.bind.annotation.JsonbProperty;

public class Lavoro {

    @JsonbProperty
    String targa;

    @JsonbProperty
    String tipoLavoro;

    @JsonbProperty
    String descLavoro;

    public Lavoro() {
    }

    public Lavoro(String targa, String tipoLavoro, String descLavoro) {
        this.targa = targa;
        this.tipoLavoro = tipoLavoro;
        this.descLavoro = descLavoro;
    }

    public String getTarga() {
        return targa;
    }

    public String getDescLavoro() {
        return descLavoro;
    }

    public String getTipoLavoro() {
        return tipoLavoro;
    }
}
