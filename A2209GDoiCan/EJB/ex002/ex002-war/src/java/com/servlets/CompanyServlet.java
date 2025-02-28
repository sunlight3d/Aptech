package com.servlets;

import com.model.*;
import com.service.CompanyService;
import java.io.IOException;

import java.util.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class CompanyServlet extends HttpServlet {

    @EJB
    private CompanyService companyService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Company> companies = companyService.getAllCompanies();
        request.setAttribute("companies", companies);
        request.getRequestDispatcher("companyList.jsp").forward(request, response);
    }
}
