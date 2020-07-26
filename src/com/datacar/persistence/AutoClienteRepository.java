package com.datacar.persistence;


import com.datacar.model.AutoCliente;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class AutoClienteRepository {

    @PersistenceContext
    EntityManager em;

    ClienteRepository clienteRepository;
    AutoRepository autoRepository;

    public void createAutoCliente(String targa, ClienteEntity clienteEntity, AutoEntity autoEntity){
        em.persist(new AutoClienteEntity(targa,clienteEntity,autoEntity));
        em.flush();
    }
}
