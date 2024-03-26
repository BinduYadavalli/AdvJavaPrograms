package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//STEP-1:read the data.
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("operation");
		
		//STEP-2:Process the data.
		int result = 0;
		switch(operation)
		{
		case "+": result=num1+num2;
					break;
		case "-": result=num1+num2;
					break;
		case "*": result=num1+num2;
					break;
		case "/": result=num1+num2;
					break;
		case "%": result=num1+num2;
					break;
		}			
		//STEP-3:render the response to client.
					PrintWriter writer=response.getWriter();
					response.setContentType("text/html");
					writer.println("<h1>Calculator Results...</h1>");
					writer.println("<body bgcolor=pink>");
					writer.println("<html>");
					writer.println(" <b>The first number=</b>"+num1);
					writer.println("<br><br>");
					writer.println("<b>The second number=</b>"+num2);
					writer.println("<br><br>");
					writer.println("<b>Operation is=</b>"+operation);
					writer.println("<br><br>");
					writer.println("the Result is="+result);
					writer.println("</html>");				
		}
		
	}


