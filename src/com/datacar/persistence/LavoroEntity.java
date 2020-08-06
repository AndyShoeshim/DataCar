package com.datacar.persistence;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.sql.Date;

@Entity(name = "lavoro")
@Table(name = "lavoro")
@NamedQueries( {
        @NamedQuery(name = "Lavoro.getAllLavoro", query = "select l from lavoro l where l.id_officina=:id_officina"),
        @NamedQuery(name = "Lavoro.getLavoroByTarga", query = "select l from lavoro l where l.targa=:targa and l.id_officina=:id_officina")
})
public class LavoroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @ManyToOne
    @JoinColumn(name = "ID_OFFICINA", nullable = false)
    OfficinaEntity id_officina;


    @Column(nullable = false)
    String targa;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_LAVORO", nullable = false)
    TipoLavoroEntity id_tipo_lavoro;

    @ManyToOne
    @JoinColumn(name = "ID_DESCRIZIONE_LAVORO", nullable = false)
    DescrizioneLavoroEntity id_desc_lavoro;

    @Column
    @JsonbDateFormat("dd.MM.yyyy")
    Date dataScandenza;

    @Column
    boolean effettuato;

    public LavoroEntity() {
    }

    public LavoroEntity(OfficinaEntity id_officina, String targa, TipoLavoroEntity id_tipo_lavoro, DescrizioneLavoroEntity id_desc_lavoro) {
        this.id_officina = id_officina;
        this.targa = targa;
        this.id_tipo_lavoro = id_tipo_lavoro;
        this.id_desc_lavoro = id_desc_lavoro;
    }

    public LavoroEntity(OfficinaEntity id_officina, String targa, TipoLavoroEntity id_tipo_lavoro, DescrizioneLavoroEntity id_desc_lavoro, Date dataScandenza, boolean effettuato) {
        this.id_officina = id_officina;
        this.targa = targa;
        this.id_tipo_lavoro = id_tipo_lavoro;
        this.id_desc_lavoro = id_desc_lavoro;
        this.dataScandenza = dataScandenza;
        this.effettuato = effettuato;
    }

    public int getId() {
        return id;
    }

    public OfficinaEntity getId_officina() {
        return id_officina;
    }

    public TipoLavoroEntity getId_tipo_lavoro() {
        return id_tipo_lavoro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_officina(OfficinaEntity id_officina) {
        this.id_officina = id_officina;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setId_tipo_lavoro(TipoLavoroEntity id_tipo_lavoro) {
        this.id_tipo_lavoro = id_tipo_lavoro;
    }

    public void setId_desc_lavoro(DescrizioneLavoroEntity id_desc_lavoro) {
        this.id_desc_lavoro = id_desc_lavoro;
    }

    public DescrizioneLavoroEntity getId_desc_lavoro() {
        return id_desc_lavoro;
    }

    public String getTarga() {
        return targa;
    }

    public Date getDataScandenza() {
        return dataScandenza;
    }

    public void setEffettuato(boolean effettuato) {
        this.effettuato = effettuato;
    }

    public boolean isEffettuato() {
        return effettuato;
    }
}
