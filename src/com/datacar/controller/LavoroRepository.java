package com.datacar.controller;


import com.datacar.model.Lavoro;
import com.datacar.persistence.DescrizioneLavoroEntity;
import com.datacar.persistence.LavoroEntity;
import com.datacar.persistence.OfficinaEntity;
import com.datacar.persistence.TipoLavoroEntity;

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


    public void createLavoro(OfficinaEntity officinaEntity, String targa, TipoLavoroEntity tipoLavoroEntity, DescrizioneLavoroEntity descrizioneLavoroEntity) {
        LavoroEntity lavoroEntity = new LavoroEntity(officinaEntity,targa,tipoLavoroEntity,descrizioneLavoroEntity);
        em.persist(lavoroEntity);
        em.flush();
    }

    public List<LavoroEntity> getAllLavoro(OfficinaEntity officinaEntity){
        List<LavoroEntity> list_of_lavoro = em.createNamedQuery("Lavoro.getAllLavoro").setParameter("id_officina",officinaEntity).getResultList();
        return list_of_lavoro;
    }

    public List<LavoroEntity> getLavoroByTarga(String targa){
        List<LavoroEntity> list_of_lavoro = em.createNamedQuery("Lavoro.getLavoroByTarga").setParameter("targa",targa).getResultList();
        return list_of_lavoro;
    }


}
