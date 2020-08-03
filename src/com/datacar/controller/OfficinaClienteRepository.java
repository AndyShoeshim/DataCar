package com.datacar.controller;


import com.datacar.persistence.ClienteEntity;
import com.datacar.persistence.OfficinaClienteEntity;
import com.datacar.persistence.OfficinaEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class OfficinaClienteRepository {

    @PersistenceContext
    EntityManager em;

    public void createOfficinaCliente(OfficinaEntity officinaEntity, ClienteEntity clienteEntity){
        em.persist(new OfficinaClienteEntity(officinaEntity,clienteEntity));
        em.flush();
    }

    public List<ClienteEntity> getClienteListOfOfficina(OfficinaEntity officinaEntity){
        List<ClienteEntity> clienteEntities = em.createNamedQuery("OfficinaCliente.getAllClienteOfOfficina").setParameter("id_officina", officinaEntity).getResultList();
        return clienteEntities;
    }
}
