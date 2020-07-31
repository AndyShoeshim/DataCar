package com.datacar.controller;


import com.datacar.model.Auto;
import com.datacar.persistence.AutoEntity;
import com.datacar.utility.AutoDtoToEntity;
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
        em.persist(AutoDtoToEntity.autoEntityFromautoDto(auto));
        em.flush();
    }

    public AutoEntity getAutoByDesc(String marca, String modello, String cilindrata, String motore, String carburante){
      List<AutoEntity> list_of_auto_found = em.createNamedQuery("Auto.getAutoByDesc").setParameter("marca",marca)
              .setParameter("modello",modello).setParameter("cilindrata",cilindrata).setParameter("motore",motore)
              .setParameter("carburante",carburante).getResultList();
      return list_of_auto_found.get(0);
    }

    public AutoEntity getAutoById(int id){
        List<AutoEntity> autoEntities = em.createNamedQuery("Auto.getAutoById").setParameter("id", id).getResultList();
        System.out.println(autoEntities.get(0).getId());
        return autoEntities.get(0);
    }
}
