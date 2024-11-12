package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Product;

public class ProductServlet extends HttpServlet {
    private List<Product> products = new ArrayList<>(List.of(
            new Product("iphone 15 pro 128gb 8 RAM", 1234.7f, 23, "This is iphone"), 
            new Product("Samsung galaxy dnuhd 12", 872.7f, 23, "sam sunggg"), 
            new Product("laptop gaming", 983.7f, 2, "lap riuehjru kjd")
        ));
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String httpMethod = request.getParameter("_method");
        if(httpMethod != null && httpMethod.equals("update")) {
            Integer id = Integer.valueOf(request.getParameter("id")); 
            Product foundProduct = null;
            for(Product product: this.products) {
                if(product.getId() == id) {
                    foundProduct = product;
                    break;
                }
            }
            if(foundProduct != null) {
                request.setAttribute("product", foundProduct);
                request.getRequestDispatcher("updateProduct.jsp").forward(request, response);  
            }            
        } else {
            request.setAttribute("products", products);
            request.getRequestDispatcher("products.jsp").forward(request, response);  
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         // Lấy dữ liệu từ form
        try {
            String name = request.getParameter("name");            
            String httpMethod = request.getParameter("_method");
            if(httpMethod.equals("delete")) {
                Integer id = Integer.valueOf(request.getParameter("id"));                  
                this.products.removeIf(p -> p.getId()==id);                
            } else if(httpMethod.equals("update")) {
                Integer id = Integer.valueOf(request.getParameter("id"));                                  
                String productName = request.getParameter("productName");
                float price = Float.parseFloat(request.getParameter("price"));
                float quantity = Float.parseFloat(request.getParameter("quantity"));
                String description = request.getParameter("description");

                // Find the product by id and update its details
                for (Product product : products) {
                    if (product.getId() == id) {
                        product.setName(productName);
                        product.setPrice(price);
                        product.setQuantity(quantity);
                        product.setDescription(description);
                        break;
                    }
                }              
            } else {
                float price = Float.parseFloat(request.getParameter("price"));
                float quantity = Float.parseFloat(request.getParameter("quantity"));
                String description = request.getParameter("description");

                // Tạo đối tượng Product mới từ dữ liệu form
                Product newProduct = new Product(name, price, quantity, description);//builder pattern        
                this.products.add(newProduct);
            }
            
        }catch(Exception e) {
            System.err.println("Error when inserting data");
        } finally {
            // Chuyển hướng về trang danh sách sản phẩm sau khi thêm thành công
            response.sendRedirect("products");        
        }        
    }

    
}