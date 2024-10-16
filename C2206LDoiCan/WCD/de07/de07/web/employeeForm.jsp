<%-- 
    Document   : employeeForm
    Created on : Mar 25, 2024, 12:08:54 AM
    Author     : ChungTV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Employee</title>
        <style>
            .form-group {
                margin-bottom: 10px;
            }
            label {
                display: inline-block;
                width: 120px;
                text-align: left;
            }
            input[type="text"] {
                width: 200px;
            }
            .error-message {
                color: red;
                margin-left: 10px;
            }
        </style>
    </head>
    <body>
        <h2 class="error-message">${empty requestScope.errorMessage ? '' : requestScope.errorMessage}</h2>
        <form action="EmployeeServlet" method="POST">
            <input type="hidden" name="_method" value="CREATE">
            <div class="form-group">
                <label for="employeeNo">Employee No:</label>
                <input type="text" id="employeeNo" name="employeeNo" value="${empty param.employeeNo ? '' : param.employeeNo}">
                <span class="error-message">${empty requestScope.employeeNoError ? '' : requestScope.employeeNoError}</span>
            </div>
            <div class="form-group">
                <label for="employeeName">Employee Name:</label>
                <input type="text" id="employeeName" name="employeeName" value="${empty param.employeeName ? '' : param.employeeName}">
                <span class="error-message">${empty requestScope.employeeNameError ? '' : requestScope.employeeNameError}</span>
            </div>
            <div class="form-group">
                <label for="placeOfWork">Place of Work:</label>
                <input type="text" id="placeOfWork" name="placeOfWork" value="${empty param.placeOfWork ? '' : param.placeOfWork}">
                <span class="error-message">${empty requestScope.placeOfWorkError ? '' : requestScope.placeOfWorkError}</span>
            </div>
            <div class="form-group">
                <label for="phoneNo">Phone No:</label>
                <input type="text" id="phoneNo" name="phoneNo" value="${empty param.phoneNo ? '' : param.phoneNo}">
               <span class="error-message">${empty requestScope.phoneNoError ? '' : requestScope.phoneNoError}</span>
            </div>
            <input type="submit" value="Submit Query">
            <input type="reset" value="Reset">
        </form>
        <a href="EmployeeServlet">Back To List</a>
    </body>
</html>
