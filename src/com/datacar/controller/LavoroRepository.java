package com.datacar.controller;


import com.datacar.model.Lavoro;
import com.datacar.persistence.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class LavoroRepository {

    @PersistenceContext
    EntityManager em;


    public void createLavoro(OfficinaEntity officinaEntity,Lavoro lavoro, TipoLavoroEntity tipoLavoroEntity, DescrizioneLavoroEntity descrizioneLavoroEntity) {
        LavoroEntity lavoroEntity = new LavoroEntity(officinaEntity,lavoro.getTarga(),tipoLavoroEntity,descrizioneLavoroEntity, lavoro.getDataScandenza(), lavoro.isEffettuato());
        em.persist(lavoroEntity);
        em.flush();
    }

    public List<LavoroEntity> getAllLavoro(OfficinaEntity officinaEntity){
        List<LavoroEntity> list_of_lavoro = em.createNamedQuery("Lavoro.getAllLavoro").setParameter("id_officina",officinaEntity).getResultList();
        return list_of_lavoro;
    }

    public List<LavoroEntity> getLavoroByTarga(String targa, OfficinaEntity officinaEntity){
        List<LavoroEntity> list_of_lavoro = em.createNamedQuery("Lavoro.getLavoroByTarga").setParameter("targa",targa)
                .setParameter("id_officina",officinaEntity).getResultList();
        return list_of_lavoro;
    }

    public boolean updateLavoroStatus(int id_lavoro){
        LavoroEntity lavoroEntity = em.find(LavoroEntity.class,id_lavoro);
        if(!lavoroEntity.isEffettuato()){
            lavoroEntity.setEffettuato(true);
            em.merge(lavoroEntity);
            em.flush();
            return true;
        } else
            return false;
    }



}
