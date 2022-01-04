package com.company.repository;

import com.company.model.Ticket;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketRepository {
    private EntityManager entityManager;

    public TicketRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Ticket> findAll(){
        return entityManager.createQuery ("from Ticket", Ticket.class).getResultList ();
    }
}
