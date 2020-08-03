package com.datacar.persistence;


import javax.persistence.*;

@Entity(name = "tipo_lavoro")
@Table(name = "tipo_lavoro")
public class TipoLavoroEntity {


    public enum CategoriaLavoro{
        MANUTENZIONE,
        GUASTO,
        DIAGNOSI;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    /*
        @Column(nullable = false)
        private String cod_tipo_lavoro;
    */

    //@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaLavoro  categoriaLavoro;

    public TipoLavoroEntity() {
    }


    public CategoriaLavoro getCategoriaLavoro() {
        return categoriaLavoro;
    }

    public int getId() {
        return id;
    }
}
