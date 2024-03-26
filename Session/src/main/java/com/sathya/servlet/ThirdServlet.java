package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//display total details.
		//tatal 6=req(2)+sessions(4).
		
		//locate the session object.
		HttpSession session=request.getSession(false);
		
		PrintWriter writer=response.getWriter();
		response.setContentType("html");
		writer.println("<html>");
		writer.println("<center><h1>USER DETAILS</h1></center>");
		
		writer.println("<body>");
		writer.println("<center>");
		writer.println("<pre style='color:green'>");
		writer.println("USER NAME : "+session.getAttribute("user"));
		writer.println("AGE : "+session.getAttribute("age"));
		writer.println("QUALIFICATION  : "+session.getAttribute("qualification"));
		writer.println("DESIGNATION : "+session.getAttribute("designation"));
		writer.println("EMAIL-ID : "+request.getParameter("email"));
		writer.println("PHONE NUMBER : "+request.getParameter("phno"));
		writer.println("</pre>");
		writer.println("</center>");
		writer.println("</body>");
		writer.println("</html>");
		
		
		
		
		
				
				
			
		
		
	}


	private void println(String string) {
		// TODO Auto-generated method stub
		
	}


	private String getAttribute(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
