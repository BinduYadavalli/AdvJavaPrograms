package com.sathya.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bindu")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter writer=response.getWriter();
	response.setContentType("html");
	
	writer.println("<h1>Welcome to sathyatech</h1>");
	writer.println("<h2>This is helloworld application</h2>");
	writer.println("<h3>advance java classes</h3>/");
	writer.println("<h4>Ratan sir</h4>");
	writer.println("<h5>html classes</h5>");
	writer.println("<h6>bye</h6>");


	
	
		
	}

}
