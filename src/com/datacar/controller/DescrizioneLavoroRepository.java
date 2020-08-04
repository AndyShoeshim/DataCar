package com.datacar.controller;


import com.datacar.persistence.DescrizioneLavoroEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class DescrizioneLavoroRepository {

    @PersistenceContext
    EntityManager em;

    public DescrizioneLavoroEntity getLavoroEntityByDesc(String descrizioneLavoro){
        List<DescrizioneLavoroEntity> descrizioneLavoroEntities = em.createNamedQuery("Descrizionelavoro.getLavoroIdByDesc").setParameter("descrizioneLavoro",descrizioneLavoro).getResultList();
        return descrizioneLavoroEntities.get(0);
    }

    public DescrizioneLavoroEntity getLavoroEntityById(int id){
        List<DescrizioneLavoroEntity> descrizioneLavoroEntities = em.createNamedQuery("Descrizionelavoro.getLavoroDescById").setParameter("id",id).getResultList();
        return descrizioneLavoroEntities.get(0);
    }
}
