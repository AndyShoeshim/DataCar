package com.datacar.persistence;


import com.datacar.model.Auto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "auto")
@Table(name = "auto")
@NamedQueries({
        @NamedQuery(name = "Auto.getAutoByDesc" , query =
                "select a from auto a where a.marca=:marca and a.modello=:modello and a.cilindrata=:cilindrata and a.motore=:motore and a.carburante=:carburante and a.cavalli=:cavalli"),
        @NamedQuery(name = "Auto.getAutoById", query = "select a from auto a where a.id=:id")
}
)
public class AutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modello;

    @Column(nullable = false)
    private String motore;

    @Column(nullable = false)
    private String cilindrata;

    @Column(nullable = false)
    private String carburante;

    @Column(nullable = false)
    private String cavalli;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_auto", orphanRemoval = true)
    private List<AutoClienteEntity> autoClienteEntities;


    public AutoEntity() {
    }

    public AutoEntity(String marca, String modello, String motore, String cilindrata, String carburante, String cavalli) {
        this.marca = marca;
        this.modello = modello;
        this.motore = motore;
        this.cilindrata = cilindrata;
        this.carburante = carburante;
        this.cavalli = cavalli;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCavalli() {
        return cavalli;
    }

    public void setCavalli(String cavalli) {
        this.cavalli = cavalli;
    }

    public void setAutoClienteEntities(List<AutoClienteEntity> autoClienteEntities) {
        this.autoClienteEntities = autoClienteEntities;
    }

    public List<AutoClienteEntity> getAutoClienteEntities() {
        return autoClienteEntities;
    }
}
