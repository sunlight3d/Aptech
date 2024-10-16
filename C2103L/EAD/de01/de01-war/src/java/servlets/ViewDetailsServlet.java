/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Company;
import sessionbeans.CompanySessionBeanLocal;

@WebServlet("/viewDetails")
public class ViewDetailsServlet extends HttpServlet {
    @EJB
    private CompanySessionBeanLocal companyBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int companyId = Integer.parseInt(request.getParameter("companyId"));
        Company company = companyBean.getCompanyById(companyId);

        request.setAttribute("company", company);
        request.getRequestDispatcher("/view-details.jsp").forward(request, response);
    }
}

