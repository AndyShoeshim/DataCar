package com.datacar.persistence;


import javax.persistence.*;
import java.util.List;

@Entity(name = "descrizione_lavoro")
@Table(name = "descrizione_lavoro")
@NamedQueries({
        @NamedQuery(name = "Descrizionelavoro.getLavoroIdByDesc", query = "select d from descrizione_lavoro d where d.descrizioneLavoro=:descrizioneLavoro"),
        @NamedQuery(name = "Descrizionelavoro.getLavoroDescById",query = "select d from descrizione_lavoro d where d.id=:id")
})
public class DescrizioneLavoroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Column(nullable = false)
    String descrizioneLavoro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_desc_lavoro", orphanRemoval = true)
    List<LavoroEntity> lavoroEntities;

    public DescrizioneLavoroEntity() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescrizioneLavoro(String descrizioneLavoro) {
        this.descrizioneLavoro = descrizioneLavoro;
    }

    public void setLavoroEntities(List<LavoroEntity> lavoroEntities) {
        this.lavoroEntities = lavoroEntities;
    }

    public int getId() {
        return id;
    }

    public String getDescrizioneLavoro() {
        return descrizioneLavoro;
    }

    public List<LavoroEntity> getLavoroEntities() {
        return lavoroEntities;
    }
}
