package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GenerateServlet")
public class GenerateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int fact;
	private int sum;
	private int i;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//STEP-1:Read the data.
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("operation");
		
		//STEP-2:Process the data.
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>GENERATE THE NUMBER LIST</h1>");
		writer.println("<b>first nnumber is:</b>"+num1);
		writer.println("<b>second number is:</b>"+num2);
		
		
		int rem;
		switch(operation)
		{
		case "even":for(int i=num1;i<=num2;i++)
		            {
			           if(i%2==0)
			        	   writer.println("<b>even numbers:</b>"+i);
			               writer.println("<br><br>");
		            }
		             break;
		 case "odd":for(int i=num1;i<=num2;i++)
		            {
			           if(i%2==1)
			        	  writer.println("<b>odd numbers are :</b>"+i);
			              writer.println("<br><br>");
			         }
		             break;
		 case "prime":  int count=0;
			            for(int i=num1;i<=num2;i++)
                         {
			               for(int j=1;j<=i;j++)
			               {
			            	   if(i%j==0)
			            		   count++;
			               }
                         }
		              if(count==2)
		              {
	                     int i=0; 
						writer.println("prome numbers are :"+i);
					
		              }
		 case "strong":int temp=0;rem=0; fact = 1; sum=0;
		                for(int i=num1;i<=num2;i++)
		                {
		                	temp=i;
		                	rem=i%10;
		                }
		                	for(int j=1;j<=rem;j++)
		                	{
		                		fact=fact*j;
		                     }
		                	sum=sum+fact;
		                	i=i/10;
		                	if(sum==temp)
		                	{
		                		writer.println("")
		                	}
		                	
		               
	}
		
	}
}
	
	


