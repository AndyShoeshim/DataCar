package com.datacar.persistence;


import com.datacar.model.Cliente;

import javax.persistence.*;

@Entity(name = "cliente")
@Table(name = "cliente")
@NamedQueries({
        @NamedQuery(name = "Cliente.findClienteByCodFiscale" , query = " SELECT c FROM cliente c WHERE c.cod_fiscale = :cod_fiscale "),
        @NamedQuery(name = "Cliente.getAllCliente", query = "SELECT c FROM cliente c")
})
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_cliente;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    String cognome;

    @Column(nullable = false)
    String citta;

    @Column(nullable = false)
    String cap;

    @Column(nullable = false)
    String indirizzo;

    @Column(nullable = false)
    String sesso;

    @Column(nullable = false, unique = true)
    String cod_fiscale;

    @Column(nullable = false)
    int telefono;

    @Column(nullable = true)
    String email;

    public ClienteEntity(){
    }

    public ClienteEntity(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cognome = cliente.getCognome();
        this.citta = cliente.getCitta();
        this.cap = cliente.getCap();
        this.indirizzo = cliente.getIndirizzo();
        this.sesso = cliente.getSesso();
        this.cod_fiscale = cliente.getCod_fiscale();
        this.telefono = cliente.getTelefono();
        this.email = cliente.getEmail();
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getCod_fiscale() {
        return cod_fiscale;
    }

    public void setCod_fiscale(String cod_fiscale) {
        this.cod_fiscale = cod_fiscale;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
