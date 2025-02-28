/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.service;

import com.model.Company;
import java.util.*;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class CompanyService {

    @PersistenceContext(unitName = "ex002-ejbPU")
    private EntityManager em;

    public void createCompany(Company company) {
        em.persist(company);
    }

    public Company findCompanyById(int id) {
        return em.find(Company.class, id);
    }

    public void updateCompany(Company company) {
        em.merge(company);
    }

    public List<Company> getAllCompanies() {
        return em.createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }
}
