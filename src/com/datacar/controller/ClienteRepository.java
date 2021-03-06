package com.datacar.controller;


import com.datacar.model.Cliente;
import com.datacar.persistence.ClienteEntity;
import com.datacar.utility.ClienteDtoToEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class ClienteRepository {

    @PersistenceContext
    EntityManager em;

    public void createCliente(Cliente cliente){
        em.persist(ClienteDtoToEntity.clienteEntityFromClienteDto(cliente));
        em.flush();
    }

    public ClienteEntity findClienteByCodFiscale(String cod_fiscale){
        List<ClienteEntity> clientFound = em.createNamedQuery("Cliente.findClienteByCodFiscale")
                .setParameter("cod_fiscale", cod_fiscale).getResultList();
        return clientFound.get(0);
    }

    public ClienteEntity findClienteById(int id){
       return em.find(ClienteEntity.class,id);
    }

    public boolean updateCliente(int id, Cliente clienteUpdated){
        ClienteEntity clienteOld = findClienteById(id);

        if(clienteOld==null){
            return false;
        }

        clienteOld.setNome(clienteUpdated.getNome());
        clienteOld.setCognome(clienteUpdated.getCognome());
        clienteOld.setCitta(clienteUpdated.getCitta());
        clienteOld.setCap(clienteUpdated.getCap());
        clienteOld.setIndirizzo(clienteUpdated.getIndirizzo());
        clienteOld.setSesso(clienteUpdated.getSesso());
        clienteOld.setCod_fiscale(clienteUpdated.getCod_fiscale());
        clienteOld.setTelefono(clienteUpdated.getTelefono());

        if(clienteUpdated.getEmail()!=null){
            clienteOld.setEmail(clienteUpdated.getEmail());
        }

        em.merge(clienteOld);
        em.flush();
        return true;
    }

    public List<ClienteEntity> getAllCliente(){
        List<ClienteEntity> clientFound = em.createNamedQuery("Cliente.getAllCliente").getResultList();
        return clientFound;
    }

    public boolean deleteClienteByCodFiscale(String cod_fiscale){
        ClienteEntity clienteToDelete = this.findClienteByCodFiscale(cod_fiscale);
        if(clienteToDelete==null){
            return false;
        }
        em.remove(clienteToDelete);
        return true;
    }
}
