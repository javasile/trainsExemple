package com.company.repository;

import com.company.model.Train;
import com.company.model.TrainStation;

import javax.persistence.EntityManager;
import java.util.List;

public class TrainStationRepository {
    private EntityManager entityManager;

    public TrainStationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<TrainStation> findAll(){
        return entityManager.createQuery ("from TrainStation", TrainStation.class).getResultList ();
    }
    public void saveTrainStation(TrainStation trainStation){
        entityManager.getTransaction ().begin ();
        entityManager.persist (trainStation);
        entityManager.getTransaction ().commit ();
    }
}
