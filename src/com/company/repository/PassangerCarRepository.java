package com.company.repository;

import com.company.model.PassangerCar;

import javax.persistence.EntityManager;
import java.util.List;

public class PassangerCarRepository {
    private EntityManager entityManager;

    public PassangerCarRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<PassangerCar> findAll(){
        return entityManager.createQuery ("from PassangerCar", PassangerCar.class).getResultList ();
    }
    public void savePassangerCar(PassangerCar passangerCar){
        entityManager.getTransaction ().begin ();
        entityManager.persist (passangerCar);
        entityManager.getTransaction ().commit ();
    }
}
