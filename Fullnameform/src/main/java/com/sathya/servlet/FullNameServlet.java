package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FullNameServlet")
public class FullNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//STEP-1 : Read the data 
		String firstname=request.getParameter("First Name");
		String middlename=request.getParameter("Middle Name");
		String lastname=request.getParameter("Last Name");
		
		//STEP-2 :process the data
		String fullname;
		fullname=firstname+" "+middlename+" "+lastname;
		
		//STEP-3 : Render the response to client
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>FULLNAME OF USER</h1>"+fullname);
		writer.println("</html>");
		
		
	}

}
