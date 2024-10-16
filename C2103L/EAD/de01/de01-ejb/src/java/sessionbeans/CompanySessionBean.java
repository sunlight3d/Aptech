/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import models.Company;

@Stateless
public class CompanySessionBean implements CompanySessionBeanLocal {    
    @PersistenceContext(unitName = "de01-ejbPU")
    private EntityManager entityManager;
        
    @Override
    public Company createCompany(String name, String key, String description, String address, boolean enabled) {    
        Company company = new Company();
        company.setName(name);
        company.setCompanyKey(key);
        company.setDescription(description);
        company.setAddress(address);
        company.setEnabled(enabled);

        entityManager.persist(company);
        entityManager.close();
        return company;
    }
    @Override
    public Company updateCompany(Integer id, String name, String key, String description, String address, boolean enabled) {
        Company company = entityManager.find(Company.class, id);
        if (company != null) {
            company.setName(name);
            company.setCompanyKey(key);
            company.setDescription(description);
            company.setAddress(address);
            company.setEnabled(enabled);
            entityManager.merge(company);
        }
        entityManager.close();
        return company;
    }
    @Override
    public Company getCompanyById(Integer id) { 
        return entityManager.find(Company.class, id);
    }
}
