package com.company.repository;

import javax.persistence.EntityManager;
import javax.swing.text.Document;
import java.util.List;

public class DocumentRepository {
    private EntityManager entityManager;

    public DocumentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Document> findAll(){
        return entityManager.createQuery ("from Document", Document.class).getResultList ();
    }
}
