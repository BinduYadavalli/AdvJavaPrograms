package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//STEP-1:Read the data.
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		int pprice=Integer.parseInt(request.getParameter("proprice"));
		int pQuan=Integer.parseInt(request.getParameter("pquanntity"));
		
		int total;
		//STEP-2:Process the data.
		Double discount,netbill;
		total=pprice*pQuan;
		if(total>=10000)
		{
			discount=0.15*total/100;
		}
		else if(((total>5000)&&(total<=10000)))
		{
			discount=0.10*total/100;
		}
		else if(((total>1000)&&(total<=5000)))
		{
			discount=0.5*total/100;
		}
		else
		{
			discount=0.0;
		}
		netbill=total-discount;
		//Step-3:response to client.
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<h1>PRODUCT BILL INVOICE</h1>");
		writer.println("<b>Product Id        :</b>"+pid);
		writer.println("<br><br>");
        writer.println("<b>product Name      :</b>"+pname);
        writer.println("<br><br>");
		writer.println("<b>Product price     :</b>"+pprice);
		writer.println("<br><br>");
		writer.println("<b>Product Quantity  :</b>"+pQuan);
		writer.println("<br><br>");
		writer.println("<b>Total Bill Amount :</b>"+total);
		writer.println("<br><br>");
		writer.println("<b>Discount Amount   :</b>"+discount);
		writer.println("<br><br>");
		writer.println("<b>Net Amount To Pay : </b>"+netbill);
		writer.println("</html>");
		
		
		
		
		
			
			
		
		
		
	}

}
