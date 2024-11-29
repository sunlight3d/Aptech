package com.example.web;

// Import thực thể và EJB phù hợp
import com.example.ejb.Exam;
import com.example.ejb.ExamSessionBeanLocal;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExamServlet extends HttpServlet {
    @EJB
    private ExamSessionBeanLocal examSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "list" : action;

        switch (action) {
            case "edit":
                showEditForm(req, resp);
                break;
            case "add":
                showAddForm(req, resp);
                break;
            case "list":
            default:
                listExams(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "create";  // Mặc định là thêm kỳ thi
        }

        switch (action) {
            case "update":
                updateExam(req, resp);
                break;
            case "delete":
                deleteExam(req, resp);
                break;
            case "create":
            default:
                createExam(req, resp);
                break;
        }
    }

    // Hiển thị form thêm kỳ thi
    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add-exam.jsp").forward(req, resp);
    }

    // Hiển thị form chỉnh sửa thông tin kỳ thi
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Exam existingExam = examSessionBean.findExamById(id);
        req.setAttribute("exam", existingExam);
        req.getRequestDispatcher("/update-exam.jsp").forward(req, resp);
    }

    // Hiển thị danh sách kỳ thi
    private void listExams(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Exam> exams = examSessionBean.getAllExams();
        req.setAttribute("exams", exams);
        req.getRequestDispatcher("/exams.jsp").forward(req, resp);
    }

    // Cập nhật thông tin kỳ thi
    private void updateExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int duration = Integer.parseInt(req.getParameter("duration"));
        String description = req.getParameter("description");

        Exam exam = new Exam(id, name, duration, description);
        examSessionBean.updateExam(exam);

        resp.sendRedirect("ExamServlet?action=list");
    }

    // Tạo kỳ thi mới
    private void createExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int duration = Integer.parseInt(req.getParameter("duration"));
        String description = req.getParameter("description");

        Exam exam = new Exam();
        exam.setName(name);
        exam.setDuration(duration);
        exam.setDescription(description);
        examSessionBean.addExam(exam);

        resp.sendRedirect("ExamServlet?action=list");
    }

    // Xóa kỳ thi
    private void deleteExam(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        examSessionBean.deleteExam(id);
        resp.sendRedirect("ExamServlet?action=list");
    }
}
