package com.datacar.persistence;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "tipo_lavoro")
@Table(name = "tipo_lavoro")
@NamedQueries({
        @NamedQuery(name = "Tipolavoro.getLavoroIdByDesc", query = "select t from tipo_lavoro t where t.categoriaLavoro=:categoriaLavoro"),
        @NamedQuery(name = "Tipolavoro.getLavoroDescById",query = "select t from tipo_lavoro t where t.id=:id")
})
public class TipoLavoroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    /*
        @Column(nullable = false)
        private String cod_tipo_lavoro;
    */


    @Column(nullable = false)
    private String categoriaLavoro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_tipo_lavoro", orphanRemoval = true)
    List<LavoroEntity> lavoroEntities;

    public TipoLavoroEntity() {
    }

    public List<LavoroEntity> getLavoroEntities() {
        return lavoroEntities;
    }

    public String getCategoriaLavoro() {
        return categoriaLavoro;
    }

    public int getId() {
        return id;
    }
}
