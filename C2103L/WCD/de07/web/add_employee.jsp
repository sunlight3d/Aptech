<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
    <h2>Add Employee</h2>
    <% 
        HashMap<String, String> errorMessages = (HashMap<String, String>) request.getAttribute("errorMessages");
        if (errorMessages != null && errorMessages.containsKey("duplicateName")) { %>
        <p style="color: red;"><%= errorMessages.get("duplicateName") %></p>
    <% } %>
    <form action="EmployeeServlet" method="POST">
        <input type="hidden" name="action" value="add">
        
        <label for="employeeNo">Employee No:</label>
        <input type="text" id="employeeNo" name="employeeNo">         
        <br>
        
        <label for="employeeName">Employee Name:</label>
        <input type="text" id="employeeName" name="employeeName">
        <span style="color: red;">
        <% String employeeNameErrorMessage = errorMessages != null ? errorMessages.get("employeeName") : null;
        if (employeeNameErrorMessage != null) { %>
            <%= employeeNameErrorMessage %>
        <% } %>
        </span>
        <br>
        
        <label for="placeOfWork">Place of Work:</label>
        <input type="text" id="placeOfWork" name="placeOfWork">
        <span style="color: red;">
        <% String placeOfWorkErrorMessage = errorMessages != null ? errorMessages.get("placeOfWork") : null;
        if (placeOfWorkErrorMessage != null) { %>
            <%= placeOfWorkErrorMessage %>
        <% } %>
        </span>
        <br>
        
        <label for="phoneNo">Phone No:</label>
        <input type="text" id="phoneNo" name="phoneNo">
        <span style="color: red;">
        <% String phoneNoErrorMessage = errorMessages != null ? errorMessages.get("phoneNo") : null;
        if (phoneNoErrorMessage != null) { %>
            <%= phoneNoErrorMessage %>
        <% } %>
        </span>
        <br>
        
        <input type="submit" value="Save">
        <input type="reset" value="Reset">
    </form>
    <a href="EmployeeServlet">Back to List</a>
</body>
</html>
