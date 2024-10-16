/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Local;
import models.Company;

/**
 *
 * @author sunli
 */
@Local
public interface CompanySessionBeanLocal {
    public Company createCompany(String name, String key, String description, String address, boolean enabled);
    public Company updateCompany(Integer id, String name, String key, String description, String address, boolean enabled);
    public Company getCompanyById(Integer id);
    
}
