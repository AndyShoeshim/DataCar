package com.datacar.controller;


import com.datacar.model.AutoCliente;
import com.datacar.persistence.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class AutoClienteRepository {

    @PersistenceContext
    EntityManager em;


    public void createAutoCliente(String targa, ClienteEntity clienteEntity, AutoEntity autoEntity){
        em.persist(new AutoClienteEntity(targa,clienteEntity,autoEntity));
        em.flush();
    }

    public List<AutoEntity> getAllClienteAuto(ClienteEntity clienteEntity){
        List<AutoEntity> list_of_auto_entities = em.createNamedQuery("AutoCliente.getAutoIdByClienteId").setParameter("id_cliente",clienteEntity).getResultList();
        return list_of_auto_entities;
    }

    public AutoClienteEntity getAutoClienteByTarga(String targa){
        List<AutoClienteEntity> autoCliente = em.createNamedQuery("AutoCliente.findAutoByTarga").setParameter("targa",targa).getResultList();
        return autoCliente.get(0);
    }
}
