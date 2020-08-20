package com.datacar.model;

import javax.json.bind.annotation.JsonbProperty;

public class AutoCliente {

    @JsonbProperty
    private String targa;

    @JsonbProperty
    private String cod_fiscale;

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



    public AutoCliente(){
    }


    public AutoCliente(String targa, String cod_fiscale, String marca, String modello, String motore, String cilindrata, String carburante) {
        this.targa = targa;
        this.cod_fiscale = cod_fiscale;
        this.marca = marca;
        this.modello = modello;
        this.motore = motore;
        this.cilindrata = cilindrata;
        this.carburante = carburante;
    }



    public void setCod_fiscale(String cod_fiscale) {
        this.cod_fiscale = cod_fiscale;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMotore() {
        return motore;
    }

    public void setMotore(String motore) {
        this.motore = motore;
    }

    public String getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(String cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String getCarburante() {
        return carburante;
    }

    public void setCarburante(String carburante) {
        this.carburante = carburante;
    }

    public String getCod_fiscale() {
        return cod_fiscale;
    }

    public String getTarga() {
        return targa;
    }

}
