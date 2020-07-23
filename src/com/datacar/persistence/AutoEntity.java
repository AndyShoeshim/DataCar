package com.datacar.persistence;


import com.datacar.model.Auto;

import javax.persistence.*;

@Entity(name = "auto")
@Table(name = "auto")
@NamedQueries({
        @NamedQuery(name = "Auto.findAutoByTarga", query = "select a.id from auto a where a.targa=:targa"),
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

    @Column(nullable = false, unique = true)
    String targa;

    public AutoEntity() {
    }

    public AutoEntity(Auto auto) {
        this.marca = auto.getMarca();
        this.modello = auto.getModello();
        this.motore = auto.getMotore();
        this.cilindrata = auto.getCilindrata();
        this.carburante = auto.getCarburante();
        this.cavalli = auto.getCavalli();
        this.targa = auto.getTarga();
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

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }
}
