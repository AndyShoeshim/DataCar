package com.datacar.model;

import javax.json.bind.annotation.JsonbProperty;

public class Officina {

    @JsonbProperty
    private String rag_sociale;

    @JsonbProperty
    private String p_iva;

    @JsonbProperty
    private String email;

    @JsonbProperty
    private String password;

    @JsonbProperty
    private String num_telefono;

    @JsonbProperty
    private String indirizzo;

    public Officina(String rag_sociale, String p_iva, String email, String password, String num_telefono, String indirizzo) {
        this.rag_sociale = rag_sociale;
        this.p_iva = p_iva;
        this.email = email;
        this.password = password;
        this.num_telefono = num_telefono;
        this.indirizzo = indirizzo;
    }

    public String getRag_sociale() {
        return rag_sociale;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getNum_telefono() {
        return num_telefono;
    }

    public String getP_iva() {
        return p_iva;
    }
}
