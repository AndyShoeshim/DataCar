package com.datacar.persistence;


import com.datacar.model.AutoCliente;
import com.datacar.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "auto_cliente")
@Table(name = "auto_cliente")
@NamedQueries( {
        @NamedQuery(name = "AutoCliente.getAutoIdByClienteId", query = "select ac.id_auto from auto_cliente ac where ac.id_cliente=:id_cliente"),
        @NamedQuery(name = "AutoCliente.findAutoOfCliente", query = "select a.id from auto_cliente ac, auto a where a.id=ac.id and ac.id_cliente=:id_cliente"),
        @NamedQuery(name = "AutoCliente.findAutoByTarga", query = "select ac from auto_cliente ac where ac.targa=:targa")
})
public class AutoClienteEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity id_cliente;


    @ManyToOne
    @JoinColumn(name = "ID_AUTO")
    private AutoEntity id_auto;

    @Column(nullable = false, unique = true)
    private String targa;



    public AutoClienteEntity(){
    }

    public AutoClienteEntity(String targa, ClienteEntity id_cliente, AutoEntity id_auto){
        this.targa = targa;
        this.id_cliente = id_cliente;
        this.id_auto = id_auto;
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

    public AutoEntity getId_auto() {
        return id_auto;
    }

    public ClienteEntity getId_cliente() {
        return id_cliente;
    }
}
