package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data
		String username=request.getParameter("username");
		int age=Integer.parseInt(request.getParameter("age"));
		
		//Create the Session object.
		HttpSession session=request.getSession();
		
		//Place the data into session object.
		session.setAttribute("user", username);
		session.setAttribute("age", age);
		
		//forword the form to another form.
		RequestDispatcher dispatched=request.getRequestDispatcher("form2.html");
		dispatched.forward(request,response);
		
	}

}
