/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityTransaction;
import models.Mobile;

//@WebServlet("/MobileListServlet")
public class MobileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // Khai báo thuộc tính EntityManagerFactory
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        // Tạo EntityManagerFactory trong phương thức init() của servlet
        emf = Persistence.createEntityManagerFactory("de04PU");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        // Tạo EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            // Thực hiện truy vấn để lấy danh sách Mobile
            List<Mobile> mobiles = em.createNamedQuery("Mobile.findAll", Mobile.class).getResultList();

            // Đặt danh sách Mobile vào request attribute để truy cập từ JSP
            request.setAttribute("mobiles", mobiles);

            // Chuyển hướng đến trang JSP để hiển thị danh sách Mobile
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } finally {
            // Đóng EntityManager
            em.close();
        }
    }
    @Override
    public void destroy() {
        // Đóng EntityManagerFactory trong phương thức destroy() của servlet
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ biểu mẫu tạo sản phẩm mới
        String mobileName = request.getParameter("mobileName");
        String warranty = request.getParameter("warranty");
        String inOutStockStr = request.getParameter("inOutStock");
        String priceStr = request.getParameter("price");
        String accessories = request.getParameter("accessories");
        String imageSrc = request.getParameter("imageSrc");

        try {
            // Chuyển đổi dữ liệu từ chuỗi sang kiểu dữ liệu tương ứng
            short inOutStock = Short.parseShort(inOutStockStr);
            float price = Float.parseFloat(priceStr);

            // Tạo đối tượng Mobile từ thông tin nhận được
            Mobile newMobile = new Mobile();
            newMobile.setMobileName(mobileName);
            newMobile.setWarranty(warranty);
            newMobile.setInOutStock(inOutStock);
            newMobile.setPrice(price);
            newMobile.setAccessories(accessories);
            newMobile.setImageSrc(imageSrc);
           
            EntityManager em = emf.createEntityManager();
            // Bắt đầu giao dịch
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Thêm đối tượng Mobile vào cơ sở dữ liệu
            em.persist(newMobile);

            // Kết thúc giao dịch (lưu thay đổi vào cơ sở dữ liệu)
            transaction.commit();
            // Đóng EntityManager
            em.close();
            // Đóng EntityManagerFactory
            emf.close();
            // Redirect người dùng đến trang danh sách sản phẩm sau khi thêm thành công
            response.sendRedirect("home.jsp");
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu có dữ liệu không hợp lệ
            // ... (Bạn có thể thêm xử lý lỗi ở đây)
        }
    }
}

