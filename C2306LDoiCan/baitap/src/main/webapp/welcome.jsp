
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>JSP Demo</title>
</head>
<body>
<%
    String msg = "Hello world !!!";
    int a = 5;
    int b = 10;
    int c = a + b;

    response.sendRedirect("/students");

%>
<%--<jsp:forward page="/students">
    <jsp:param name="name" value="aaaa"/>
</jsp:forward>--%>
<%-- Display message and result of a + b --%>
<h1><%= msg %><%=a + b%></h1>
<%@ include file="index.jsp"%>
</body>
</html>
