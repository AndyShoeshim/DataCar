package com.datacar.persistence;


import com.datacar.model.Officina;

import javax.persistence.*;

@Entity(name = "officina")
@Table(name = "officina")
public class OfficinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_officina;

    @Column(nullable = false)
    private String rag_sociale;

    @Column(nullable = false)
    private String p_iva;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String num_telefono;

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
}
