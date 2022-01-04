package com.company.repository;

import com.company.model.Schedule;

import javax.persistence.EntityManager;
import java.util.List;

public class ScheduleRepository {
    private EntityManager entityManager;

    public ScheduleRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Schedule> findAll(){
        return entityManager.createQuery ("from Schedule", Schedule.class).getResultList ();
    }

}
