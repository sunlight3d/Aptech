package vn.aptech.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangeColorServlet", urlPatterns = {"/change-color-servlet"}, loadOnStartup = 1)
public class ChangeColorServlet extends HttpServlet {
    private static final String COOKIE_NAME = "color";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie colorCookie = getCookie(req);
        String defaultColor = colorCookie == null ? "white" : colorCookie.getValue();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ChangeColorServlet</title>");
        out.println("</head>");
        out.println("<body bgcolor='" + defaultColor + "'>");
        out.println("<form action=\"change-color-servlet\" method=\"post\">");
        out.println("<h1>Select Color</h1>");
        out.println("<select name=\"color\">");
        if (colorCookie == null) {
            colorCookie = new Cookie(COOKIE_NAME, "white");
            colorCookie.setPath("/");
            colorCookie.setMaxAge(600);
            resp.addCookie(colorCookie);
            out.println("<option value=\"white\" selected>White</option>");
            out.println("<option value=\"black\">Black</option>");
            out.println("<option value=\"red\">Red</option>");
        } else {
            String value = colorCookie.getValue();
            getContentSelect(value, out);
        }
        out.println("</select>");
        out.println("<input type=\"submit\" value=\"Change Color\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String color = req.getParameter("color");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Cookie colorCookie = getCookie(req);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ChangeColorServlet</title>");
        out.println("</head>");
        out.println("<body bgcolor='" + color + "'>");
        out.println("<form action=\"change-color-servlet\" method=\"post\">");
        out.println("<h1>Select Color</h1>");
        out.println("<select name=\"color\">");
        if (colorCookie == null) {
            colorCookie = new Cookie(COOKIE_NAME, color);
            colorCookie.setPath("/");
            colorCookie.setMaxAge(600);
            resp.addCookie(colorCookie);
        } else {
            colorCookie.setValue(color);
            resp.addCookie(colorCookie);
        }
        getContentSelect(color, out);
        out.println("</select>");
        out.println("<input type=\"submit\" value=\"Change Color\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    private void getContentSelect(String color, PrintWriter out) {
        switch (color) {
            case "white":
                out.println("<option value=\"white\" selected>White</option>");
                out.println("<option value=\"black\">Black</option>");
                out.println("<option value=\"red\">Red</option>");
                break;
            case "black":
                out.println("<option value=\"white\">White</option>");
                out.println("<option value=\"black\" selected>Black</option>");
                out.println("<option value=\"red\">Red</option>");
                break;
            case "red":
                out.println("<option value=\"white\">White</option>");
                out.println("<option value=\"black\">Black</option>");
                out.println("<option value=\"red\" selected>Red</option>");
                break;
        }
    }

    public Cookie getCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(COOKIE_NAME)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
