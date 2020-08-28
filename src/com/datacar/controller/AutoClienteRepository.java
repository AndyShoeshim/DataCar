package com.datacar.controller;


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

    public ClienteEntity getClienteByTarga(String targa){
        List<ClienteEntity> clienteList = em.createNamedQuery("AutoCliente.getClienteIdByTarga").setParameter("targa",targa).getResultList();
        return clienteList.get(0);
    }

    public AutoClienteEntity getAutoClienteByTarga(String targa){
        List<AutoClienteEntity> autoCliente = em.createNamedQuery("AutoCliente.findAutoByTarga").setParameter("targa",targa).getResultList();
        return autoCliente.get(0);
    }

    public List<String> getTargaOfCliente(String cod_fiscale){
        List<String> list_of_cliente_targhe = em.createNamedQuery("AutoCliente.finTargaOfCliente").setParameter("cod_fiscale",cod_fiscale).getResultList();
        return list_of_cliente_targhe;
    }

    public boolean deleteByCliente(ClienteEntity clienteEntity){
        try {
            em.createNamedQuery("AutoCliente.deleteByCliente").setParameter("id_cliente", clienteEntity).executeUpdate();
            em.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
