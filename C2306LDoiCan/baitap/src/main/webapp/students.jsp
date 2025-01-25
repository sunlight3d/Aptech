<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/asset/css/style.css"/>"/>
</head>
<body class="main">
<div class="container">
    <jsp:include page="layout/header.jsp"/>
    <div class="row text-center">
        <div class="col-md-12 col-xs-12 col-sm-12">
            <h1>Student Management</h1>
            <table class="table table-bordered table-striped">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="student" items="${requestScope.students}">
                    <tr>
                        <td>${student.getId()}</td>
                        <td>${student.getName()}</td>
                        <td>${student.getEmail()}</td>
                        <td>${student.getAge()}</td>
                        <td>
                            <a href="<c:url value="/students?action=delete&id=${student.getId()}"/>"
                               class="btn btn-danger">Delete</a>
                            <a class="btn btn-info" href="<c:url value="/students?action=showFrmU&id=${student.id}"/>">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:if test="${currentPage > 1}">
                        <li class="page-item"><a class="page-link" href="<c:url value="/students?page=${currentPage-1}"/>">Previous</a></li>
                    </c:if>
                    <c:forEach var="page" begin="1" end="${totalPages}">
                        <c:choose>
                            <c:when test="${currentPage == page}">
                                <li class="page-item active"><a class="page-link" href="<c:url value="/students?page=${page}"/>">${page}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="<c:url value="/students?page=${page}"/>">${page}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${currentPage < totalPages}">
                        <li class="page-item"><a class="page-link" href="<c:url value="/students?page=${currentPage+1}"/>">Next</a></li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 col-xs-12 col-sm-12">
           <a href="<c:url value="/students?action=showFrmC"/>">Add new Student</a>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
</body>
</html>
