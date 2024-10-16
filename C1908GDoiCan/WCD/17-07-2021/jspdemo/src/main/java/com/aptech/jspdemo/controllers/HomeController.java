package com.aptech.jspdemo.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Hashtable;
import java.util.stream.Collectors;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.aptech.jspdemo.models.Point;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//trong .net mvc => [Route("homes")] => config trong web.xml
public class HomeController extends HttpServlet {
	private ServletOutputStream out;
	private Gson gson = new Gson();
    public HomeController() {
        super();        
    }
    //trong .net mvc => [HttpGet]
    //Gui params.VD: http://localhost:80/homes?x=1&y=2
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		out = response.getOutputStream();
		Integer x = Integer.valueOf(request.getParameter("x"));
		Integer y = Integer.valueOf(request.getParameter("y"));		
		out.println(String.format("x = %d, y = %d", x, y));

	}
	//trong .net mvc => [HttpPost]
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//test bang postman, trong .net api => test bang swagger
		//out = response.getOutputStream();	
		BufferedReader reader = request.getReader();
		Point point = gson.fromJson(reader, Point.class);
		System.out.println("haha");	
		PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(gson.toJson(point));
        out.flush();                   	
	}

}
