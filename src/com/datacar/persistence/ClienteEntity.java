package com.datacar.persistence;


import javax.persistence.*;
import java.util.List;

@Entity(name = "cliente")
@Table(name = "cliente")
@NamedQueries({
        @NamedQuery(name = "Cliente.findClienteByCodFiscale" , query = "SELECT c FROM cliente c WHERE c.cod_fiscale =:cod_fiscale "),
        @NamedQuery(name = "Cliente.getAllCliente", query = "SELECT c FROM cliente c")
})
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private String citta;

    @Column(nullable = false)
    private String cap;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String sesso;

    @Column(nullable = false, unique = true)
    private String cod_fiscale;

    @Column(nullable = false)
    private long telefono;

    @Column(nullable = true)
    String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_cliente", orphanRemoval = true)
    private List<AutoClienteEntity> autoClienteList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_cliente", orphanRemoval = true)
    List<OfficinaClienteEntity> officinaClienteList;

    public ClienteEntity(){
    }

    public ClienteEntity(String nome, String cognome, String citta, String cap, String indirizzo, String sesso, String cod_fiscale, long telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
        this.cap = cap;
        this.indirizzo = indirizzo;
        this.sesso = sesso;
        this.cod_fiscale = cod_fiscale;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_cliente) {
        this.id = id_cliente;
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AutoClienteEntity> getAutoClienteList() {
        return autoClienteList;
    }

    public void setAutoClienteList(List<AutoClienteEntity> autoClienteList) {
        this.autoClienteList = autoClienteList;
    }

    public List<OfficinaClienteEntity> getOfficinaClienteList() {
        return officinaClienteList;
    }

    public void setOfficinaClienteList(List<OfficinaClienteEntity> officinaClienteList) {
        this.officinaClienteList = officinaClienteList;
    }
}
