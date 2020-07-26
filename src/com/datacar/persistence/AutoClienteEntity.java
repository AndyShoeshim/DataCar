package com.datacar.persistence;


import com.datacar.model.AutoCliente;
import com.datacar.model.Cliente;

import javax.persistence.*;
import java.util.List;

@Entity(name = "auto_cliente")
@Table(name = "auto_cliente")
public class AutoClienteEntity {


    /*
        @NamedQuery(name = "Auto.findAutoByTarga", query = "select a.id from auto a where a.targa=:targa"

        query per la ricerca della targa da modificare

     */


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    ClienteEntity id_cliente;

    @ManyToOne
    @JoinColumn(name = "ID_AUTO")
    AutoEntity id_auto;

    @Column(nullable = false, unique = true)
    String targa;



    public AutoClienteEntity(){
    }

    public AutoClienteEntity(String targa, ClienteEntity id_cliente, AutoEntity id_auto){
        this.targa = targa;
        this.id_cliente = id_cliente;
//        this.id_auto = id_auto;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }

    public int getId() {
        return id;
    }

//    public AutoEntity getId_auto() {
//        return id_auto;
//    }

    public ClienteEntity getId_cliente() {
        return id_cliente;
    }
}
