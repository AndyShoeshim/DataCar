package com.datacar.persistence;


import javax.persistence.*;

@Entity(name = "officina_cliente")
@Table(name = "officina_cliente")
@NamedQueries( {
        @NamedQuery(name = "OfficinaCliente.getOfficinaCliente" , query = "select oc from officina_cliente oc where oc.id_officina=:id_officina and oc.id_cliente=:id_cliente"),
        @NamedQuery(name = "OfficinaCliente.getAllClienteOfOfficina", query = "select c.id_cliente from officina_cliente c where c.id_officina=:id_officina"),
})
public class OfficinaClienteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ID_OFFICINA")
    private OfficinaEntity id_officina;


    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity id_cliente;

    public OfficinaClienteEntity() {
    }

    public OfficinaClienteEntity(OfficinaEntity id_officina, ClienteEntity id_cliente) {
        this.id_officina = id_officina;
        this.id_cliente = id_cliente;
    }

    public ClienteEntity getId_cliente() {
        return id_cliente;
    }

    public OfficinaEntity getId_officina() {
        return id_officina;
    }


}
