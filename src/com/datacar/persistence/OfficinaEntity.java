package com.datacar.persistence;


import com.datacar.model.Officina;

import javax.persistence.*;

@Entity(name = "officina")
@Table(name = "officina")
@NamedQuery(name = "Officina.findOfficinaByPiva" , query = " SELECT o FROM officina o WHERE o.p_iva = :p_iva ")
public class OfficinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_officina;

    @Column(nullable = false)
    private String rag_sociale;

    @Column(nullable = false, unique = true)
    private String p_iva;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int num_telefono;

    @Column(nullable = false)
    private String indirizzo;

    public OfficinaEntity(){
    }

    public OfficinaEntity(Officina officina){
        this.rag_sociale = officina.getRag_sociale();
        this.email = officina.getEmail();
        this.password = officina.getPassword();
        this.p_iva = officina.getP_iva();
        this.num_telefono = officina.getNum_telefono();
        this.indirizzo = officina.getIndirizzo();
    }

    public int getId_officina() {
        return id_officina;
    }

    public void setId_officina(int id_officina) {
        this.id_officina = id_officina;
    }

    public String getRag_sociale() {
        return rag_sociale;
    }

    public void setRag_sociale(String rag_sociale) {
        this.rag_sociale = rag_sociale;
    }

    public String getP_iva() {
        return p_iva;
    }

    public void setP_iva(String p_iva) {
        this.p_iva = p_iva;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(int num_telefono) {
        this.num_telefono = num_telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
