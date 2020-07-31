package com.datacar.controller;

import com.datacar.model.Officina;
import com.datacar.persistence.OfficinaEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;


@LocalBean
@Stateless
public class OfficinaRepository {

    @PersistenceContext
    EntityManager em;

    public void createOfficina(Officina officina){
        em.persist(new OfficinaEntity(officina));
        em.flush();
    }


    public OfficinaEntity findOfficinaByPiva(String p_iva){
        List<OfficinaEntity> officinaFound = em.createNamedQuery("Officina.findOfficinaByPiva").setParameter("p_iva",p_iva).getResultList();
        return officinaFound.get(0);
    }

    public boolean updateOfficina(String p_iva, Officina officina){
        OfficinaEntity updatedOfficina = findOfficinaByPiva(p_iva);
        if(updatedOfficina==null){
            return false;
        }
        updatedOfficina.setEmail(officina.getEmail());
        updatedOfficina.setIndirizzo(officina.getIndirizzo());
        updatedOfficina.setNum_telefono(officina.getNum_telefono());
        updatedOfficina.setPassword(officina.getPassword());
        updatedOfficina.setP_iva(officina.getP_iva());
        updatedOfficina.setRag_sociale(officina.getRag_sociale());
        em.merge(updatedOfficina);
        return true;
    }


}
