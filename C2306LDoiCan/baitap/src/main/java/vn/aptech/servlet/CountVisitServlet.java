package vn.aptech.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountVisitServlet", urlPatterns = {"/visit-count-servlet"})
public class CountVisitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(true);
        int visitCount;
        if (session.getAttribute("visitCount") != null) {
            visitCount = Integer.parseInt(session.getAttribute("visitCount").toString());
            visitCount++;
            session.setAttribute("visitCount", visitCount);
        } else {
            visitCount = 1;
            session.setAttribute("visitCount", visitCount);
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html\">");
        out.println("<title>Servlet CountVisitServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Total Visit Count: " + visitCount + " </h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
