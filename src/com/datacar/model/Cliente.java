package com.datacar.model;

import javax.json.bind.annotation.JsonbProperty;

public class Cliente {

    @JsonbProperty
    String nome;

    @JsonbProperty
    String cognome;

    @JsonbProperty
    String citta;

    @JsonbProperty
    String cap;

    @JsonbProperty
    String indirizzo;

    @JsonbProperty
    String sesso;

    @JsonbProperty
    String cod_fiscale;

    @JsonbProperty
    int telefono;

    @JsonbProperty
    String email;

    @JsonbProperty
    int id_officina;

    public Cliente(){

    }

    public Cliente(String nome, String cognome, String citta, String cap, String indirizzo, String sesso, String cod_fiscale, int telefono, String email, int id_officina) {
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
        this.cap = cap;
        this.indirizzo = indirizzo;
        this.sesso = sesso;
        this.cod_fiscale = cod_fiscale;
        this.telefono = telefono;
        this.email = email;
        this.id_officina = id_officina;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCitta() {
        return citta;
    }

    public String getCap() {
        return cap;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getSesso() {
        return sesso;
    }

    public String getCod_fiscale() {
        return cod_fiscale;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public int getId_officina() {
        return id_officina;
    }
}
