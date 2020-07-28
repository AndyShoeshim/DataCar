package com.datacar.persistence;


import com.datacar.model.Auto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "auto")
@Table(name = "auto")
@NamedQueries({
        @NamedQuery(name = "Auto.getAutoById", query = "select a from auto a where a.id=:id")
}
)
public class AutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Column(nullable = false)
    String marca;

    @Column(nullable = false)
    String modello;

    @Column(nullable = false)
    String motore;

    @Column(nullable = false)
    String cilindrata;

    @Column(nullable = false)
    String carburante;

    @Column(nullable = false)
    String cavalli;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_auto", orphanRemoval = true)
    private List<AutoClienteEntity> autoClienteEntities;


    public AutoEntity() {
    }

    public AutoEntity(Auto auto) {
        this.marca = auto.getMarca();
        this.modello = auto.getModello();
        this.motore = auto.getMotore();
        this.cilindrata = auto.getCilindrata();
        this.carburante = auto.getCarburante();
        this.cavalli = auto.getCavalli();
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
