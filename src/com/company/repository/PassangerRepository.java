package com.company.repository;

import com.company.model.Passanger;

import javax.persistence.EntityManager;
import java.util.List;

public class PassangerRepository {
    private EntityManager entityManager;

    public PassangerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Passanger> findAll(){
        return entityManager.createQuery ("from Passanger", Passanger.class).getResultList ();
    }
}
