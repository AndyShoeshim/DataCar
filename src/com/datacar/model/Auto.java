package com.datacar.model;

import javax.json.bind.annotation.JsonbProperty;

public class Auto {

    @JsonbProperty
    String marca;

    @JsonbProperty
    String modello;

    @JsonbProperty
    String motore;

    @JsonbProperty
    String cilindrata;

    @JsonbProperty
    String carburante;

    @JsonbProperty
    String cavalli;

    @JsonbProperty
    String targa;

    public Auto() {
    }

    public Auto(String marca, String modello, String motore, String cilindrata, String carburante, String cavalli, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.motore = motore;
        this.cilindrata = cilindrata;
        this.carburante = carburante;
        this.cavalli = cavalli;
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getMotore() {
        return motore;
    }

    public String getCilindrata() {
        return cilindrata;
    }

    public String getCarburante() {
        return carburante;
    }

    public String getCavalli() {
        return cavalli;
    }

    public String getTarga() {
        return targa;
    }
}
