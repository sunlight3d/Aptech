package com.aptech.controllers;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(value = "/users") //giong route trong .net
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserController() {
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher;
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		if(username.equalsIgnoreCase("userA") == true && 
				password.equals("123456")) {
			String userId = UUID.randomUUID().toString();			
			HttpSession session= request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			//login thanh cong
			requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		} else {
			//login failed
			requestDispatcher = request.getRequestDispatcher("error.jsp");	
			request.setAttribute("errorMessage", "Cannot login");
			//ViewBag, ViewData trong asp .net mvc
			requestDispatcher.forward(request, response);
		}
		
				
	}

}
