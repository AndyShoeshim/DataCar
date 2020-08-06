package com.datacar.model;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.sql.Date;

public class Lavoro {

    @JsonbProperty
    String targa;

    @JsonbProperty
    String tipoLavoro;

    @JsonbProperty
    String descLavoro;

    @JsonbDateFormat("dd.MM.yyyy")
    Date dataScandenza;

    @JsonbProperty(nillable = true)
    boolean effettuato;

    public Lavoro() {
    }

    public Lavoro(String targa, String tipoLavoro, String descLavoro) {
        this.targa = targa;
        this.tipoLavoro = tipoLavoro;
        this.descLavoro = descLavoro;
    }

    public Lavoro(String targa, String tipoLavoro, String descLavoro, Date dataScandenza, boolean effettuato) {
        this.targa = targa;
        this.tipoLavoro = tipoLavoro;
        this.descLavoro = descLavoro;
        this.dataScandenza = dataScandenza;
        this.effettuato = effettuato;
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

    public Date getDataScandenza() {
        return dataScandenza;
    }

    public boolean isEffettuato() {
        return effettuato;
    }
}
