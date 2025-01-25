package vn.aptech.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Cookie userCookie = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                userCookie = cookie;
                break;
            }
        }
        if (userCookie != null) {
            String userLogin = userCookie.getValue();
            out.println("<h1> Hello " + userLogin + "</h1>");
        } else {
            out.println("<h1>User not login</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
