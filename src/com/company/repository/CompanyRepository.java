package com.company.repository;

import com.company.model.Company;

import javax.persistence.EntityManager;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class CompanyRepository {
    private EntityManager entityManager;

    public CompanyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
//    public List<Company>insert(){
//        return entityManager.createNamedQuery ("to Company", Menu.class).getResultList ();
//    }

    public List<Company> findAll(){
        return entityManager.createQuery ("from Company", Company.class).getResultList ();
    }


}
