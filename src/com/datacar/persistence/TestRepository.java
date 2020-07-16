package com.datacar.persistence;

import com.datacar.model.Test;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class TestRepository {

    @PersistenceContext
    EntityManager em;


    public void createTest(Test test) {
        em.persist(new TestEntity(test));
        em.flush();
    }


}
