package vn.aptech.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServletUseSession", urlPatterns = {"/account/login"})
public class LoginServletUseSession extends HttpServlet {
    private static final String USERNAME = "administrator";
    private static final String PASSWORD = "1234567";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LoginServletUseSession</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"/account/login\" method=\"post\">");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<td colspan=\"2\"><h1>Login</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Username: </td>");
        out.println("<td><input type=\"text\" name=\"username\" placeholder=\"Enter username\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Password: </td>");
        out.println("<td><input type=\"password\" name=\"password\" placeholder=\"Enter password\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td></td>");
        out.println("<td><input type=\"submit\" value=\"Login\"></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);

            response.sendRedirect("/welcome");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<span> Invalid username or password </span>");
        }
    }
}
