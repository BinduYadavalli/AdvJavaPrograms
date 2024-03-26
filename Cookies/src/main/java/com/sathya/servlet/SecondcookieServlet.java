package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SecondcookieServlet")
public class SecondcookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qualification=request.getParameter("Qualification");
		String designation=request.getParameter("Designation");
		
		//Create the cookie objects.
		Cookie cookie3=new Cookie("qualification",qualification);
		Cookie cookie4=new Cookie("designation",designation);
		
		//add cookie into response object.
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
		//give the next form to client
		RequestDispatcher dispatched=request.getRequestDispatcher("third.html");
		dispatched.forward(request,response);
	
	}

}
