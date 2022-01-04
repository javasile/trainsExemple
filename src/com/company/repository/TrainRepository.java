package com.company.repository;

import com.company.model.Train;

import javax.persistence.EntityManager;
import java.util.List;

public class TrainRepository {
    private EntityManager entityManager;

    public TrainRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Train> findAll(){
        return entityManager.createQuery ("from Train", Train.class).getResultList ();
    }
}
