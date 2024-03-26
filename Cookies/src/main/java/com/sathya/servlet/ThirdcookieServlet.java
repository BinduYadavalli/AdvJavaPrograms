package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThirdcookieServlet")
public class ThirdcookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		Cookie[] cookies=request.getCookies();
		
		writer.println("<html>");
		writer.println("<center><h1>USER DETAILS</h1></center>");
		writer.println("<body>");
		writer.println("<center>");
		writer.println("<pre style='color:green'>");
		writer.println("USER NAME : "+cookies[0].getValue());
		writer.println("AGE : "+cookies[1].getValue());
		writer.println("QUALIFICATION  : "+cookies[2].getValue());
		writer.println("DESIGNATION : "+cookies[3].getValue());
		writer.println("EMAIL-ID : "+request.getParameter("email"));
		writer.println("PHONE NUMBER : "+request.getParameter("phno"));
		writer.println("</pre>");
		writer.println("</center>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
