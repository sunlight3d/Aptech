<%@page import="javax.naming.InitialContext"%>
<%@page import="models.Company"%>
<%@page import="sessionbeans.CompanySessionBeanLocal"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Company Information</title>
</head>
<body>
    <%
        // Lookup the Local Session Bean using JNDI
        Context context = new InitialContext();
        CompanySessionBeanLocal companyBean = (CompanySessionBeanLocal) context.lookup("java:module/CompanySessionBean");

        // Create or retrieve Company information
        Company company = companyBean.getCompanyById(1); // Replace with the actual company ID
        
        // Display Company information
    %>
    <h1>Company Information</h1>
    <p>Name: <%= company.getName() %></p>
    <p>Key: <%= company.getCompanyKey() %></p>
    <p>Description: <%= company.getDescription() %></p>
    <p>Address: <%= company.getAddress() %></p>
    <p>Enabled: <%= company.getEnabled() %></p>
</body>
</html>
