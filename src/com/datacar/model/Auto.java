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


    public Auto() {
    }

    public Auto(String marca, String modello, String motore, String cilindrata, String carburante, String cavalli) {
        this.marca = marca;
        this.modello = modello;
        this.motore = motore;
        this.cilindrata = cilindrata;
        this.carburante = carburante;
        this.cavalli = cavalli;
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

}
