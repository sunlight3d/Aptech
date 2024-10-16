/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Company;
import sessionbeans.CompanySessionBeanLocal;

@WebServlet("/updateCompany")
public class UpdateCompanyServlet extends HttpServlet {
    @EJB
    private CompanySessionBeanLocal companyBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        Company company = companyBean.getCompanyById(companyId);

        request.setAttribute("company", company);
        request.getRequestDispatcher("/update-company.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        String name = request.getParameter("name");
        String key = request.getParameter("key");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        boolean enabled = Boolean.parseBoolean(request.getParameter("enabled"));

        Company updatedCompany = companyBean.updateCompany(companyId, name, key, description, address, enabled);

        request.setAttribute("company", updatedCompany);
        request.setAttribute("message", "Company information updated successfully!");
        request.getRequestDispatcher("/update-company.jsp").forward(request, response);
    }
}

