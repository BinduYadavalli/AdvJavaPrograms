package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FirstcookieServlet")
public class FirstcookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String username=request.getParameter("username");
		String age=request.getParameter("age");
		
		//Create the cookie objects.
		Cookie cookie1=new Cookie("username",username);
		Cookie cookie2=new Cookie("age",age);
		
		//add cookie into response object.
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		//give the next form to client
		RequestDispatcher dispatched=request.getRequestDispatcher("Second.html");
		dispatched.forward(request,response);
	
		
	
	}

}
