package com.datacar.persistence;

import com.datacar.model.Officina;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@LocalBean
@Stateless
public class OfficinaRepository {

    @PersistenceContext
    EntityManager em;

    public void createOfficina(Officina officina){
        em.persist(new OfficinaEntity(officina));
        em.flush();
    }

    public void updateOfficina(Officina officina){
        em.merge(new OfficinaEntity(officina));
        em.flush();
    }
}
