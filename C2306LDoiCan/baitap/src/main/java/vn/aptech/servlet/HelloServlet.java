package vn.aptech.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello-servlet"})
public class HelloServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Hello Servlet init !!!!!" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"/hello-servlet\" method=\"post\">");
        out.println("Username: <input type=\"text\" name=\"username\" placeholder=\"Enter your username\"><br>");
        out.println("Password: <input type=\"text\" name=\"password\" placeholder=\"Enter your password\"><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(resp.getContentType());
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Cookie cookie = new Cookie("username", username);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        System.out.println("Processing login request with username: " + username + " and password: " + password);
        resp.sendRedirect("https://www.google.co.uk/");
    }

    @Override
    public void destroy() {
        System.out.println("Hello Servlet destroy!!!!!" );
    }
}
