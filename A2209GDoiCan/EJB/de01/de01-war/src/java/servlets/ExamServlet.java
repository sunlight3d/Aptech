/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.ExamSessionBeanLocal;

/**
 *
 * @author hoangnd
 */
public class ExamServlet extends HttpServlet {

    @EJB
    private ExamSessionBeanLocal examSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "list"; // Mặc định hiển thị danh sách lịch thi
        }

        switch (action) {
            case "list":
                listSchedules(req, resp);
                break;
            case "cancel":
                cancelSchedule(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action: " + action);
        }
    }

    private void listSchedules(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> schedules = examSessionBean.findAllSchedules();
        req.setAttribute("schedules", schedules);
        req.getRequestDispatcher("/schedules.jsp").forward(req, resp);
    }

    private void cancelSchedule(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idParam = req.getParameter("id");
        if (idParam != null) {
            int scheduleId = Integer.parseInt(idParam);
            examSessionBean.cancelSchedule(scheduleId);
            resp.getWriter().println("Schedule with ID " + scheduleId + " has been canceled.");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing schedule ID.");
        }
    }

}
