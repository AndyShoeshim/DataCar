package com.datacar.controller;


import com.datacar.persistence.TipoLavoroEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@LocalBean
@Stateless
public class TipoLavoroRepository {

    @PersistenceContext
    EntityManager em;

    public TipoLavoroEntity getLavoroEntityByDesc(String categoriaLavoro){
        List<TipoLavoroEntity> tipoLavoroEntities = em.createNamedQuery("Tipolavoro.getLavoroIdByDesc").setParameter("categoriaLavoro",categoriaLavoro).getResultList();
        return tipoLavoroEntities.get(0);
    }

    public TipoLavoroEntity getLavoroEntityById(int id){
        List<TipoLavoroEntity> tipoLavoroEntities = em.createNamedQuery("Tipolavoro.getLavoroDescById").setParameter("id",id).getResultList();
        return tipoLavoroEntities.get(0);
    }
}
