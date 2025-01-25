package vn.aptech.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome"}, initParams = {@WebInitParam(name = "username", value = "password")})
public class WelcomeServlet extends HttpServlet {

    private String username;
    @Override
    public void init(ServletConfig config) throws ServletException {
        username = config.getInitParameter("username");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if (session != null) {
            String userLogin = (String) session.getAttribute("username");
            out.println("<h1> Hello " + userLogin + "</h1>");
        } else {
            out.println("<h1>User not login</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
