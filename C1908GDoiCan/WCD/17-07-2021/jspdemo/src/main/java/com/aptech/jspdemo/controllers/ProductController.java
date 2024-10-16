package com.aptech.jspdemo.controllers;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Hashtable;
import java.util.stream.Collectors;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.aptech.jspdemo.models.*;
import com.google.gson.Gson;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
docker run -d --rm --name mysql-c1908g-doican -p 3308:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql:8.0.26
mysql -h localhost -P 3308 --protocol=tcp -u root -p 
run inside container:
docker exec -it mysql-c1908g-doican mysql -u root -p   
 
*/
public class ProductController extends HttpServlet {
	
    public ProductController() {
        // TODO Auto-generated constructor stub
    }

	//http://localhost:80/products?id=123
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer productId = request.getParameter("id") == null ? 1 :
							Integer.valueOf(request.getParameter("id"));
		//DAO = Data Access Object, object from your database
		//chuyen sang trang detail
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProduct(productId);
		
		//truyen object tu file jsp A sang file jsp B
		request.setAttribute("product", product);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("detailProduct.jsp");
		//redirect sang trang detailProduct.jsp
		requestDispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
