package com.datacar.persistence;


import com.datacar.model.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@LocalBean
@Stateless
public class AutoRepository {

    @PersistenceContext
    EntityManager em;


    public void createAuto(Auto auto){
        em.persist(new AutoEntity(auto));
        em.flush();
    }

   /* public int getAutoIdByTarga(String targa){
      Query queryExecuted = em.createNamedQuery("Auto.findAutoByTarga").setParameter("targa",targa);
      return (int) queryExecuted.getSingleResult();
    }*/

    public AutoEntity getAutoById(int id){
        List<AutoEntity> autoEntities = em.createNamedQuery("Auto.getAutoById").setParameter("id", id).getResultList();
        System.out.println(autoEntities.get(0).getId());
        return autoEntities.get(0);
    }
}
