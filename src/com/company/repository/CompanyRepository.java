package com.company.repository;

import com.company.model.Company;
import com.company.model.Passanger;

import javax.persistence.EntityManager;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class CompanyRepository {
    private EntityManager entityManager;

    public CompanyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Company> findAll(){
        return entityManager.createQuery ("from Company", Company.class).getResultList ();
    }
    public void saveCompany(Company company) {
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
    }

}
