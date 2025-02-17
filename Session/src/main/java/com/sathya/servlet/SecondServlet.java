package com.sathya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //get the data
				String qualification=request.getParameter("Qualification");
				String designation=request.getParameter("Designation");
				
				//locate the Session object.
				HttpSession session=request.getSession(false);
				
				//Place the data into session object.
				session.setAttribute("qualification", qualification);
				session.setAttribute("designation", designation);
				
				//forword the form to another form.
				RequestDispatcher dispatched=request.getRequestDispatcher("form3.html");
				dispatched.forward(request,response);
				
	}
	
	

}
