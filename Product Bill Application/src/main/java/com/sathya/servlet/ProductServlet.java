package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("./ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//STEP-1:Read the data.
		int prodID=Integer.parseInt(request.getParameter("prodID"));
		String prodName=request.getParameter("prodName");
		Double ProdPrice=Double.parseDouble(request.getParameter("prodQuantity"));
		int prodQuantity=Integer.parseInt(request.getParameter("prodQuantity"));
		
		//STTEP-2:Process the data.
				double TotalBill=Double.parseDouble(request.getParameter("proPrice"))*Double.parseDouble(request.getParameter("proPrice"));
				double discount=0.0;
				double netBill=0.0;
				if(TotalBill<1000) {
					discount=0.0;
					
				   }
				else if(TotalBill>1000 && TotalBill<5000)
					{
						discount=(0.05*TotalBill)/100;
					}
				else if(TotalBill>5000 || TotalBill<10000)
					{
						discount=(0.01*TotalBill)/100;
					
				     }
				else {
						discount=(0.01*TotalBill)/100;
					 }
					
				     netBill=TotalBill-discount;
				     //STEP-3:render the response to client.
					response.setContentType("text/html");
					 PrintWriter writer=response.getWriter();
					 writer.println("<html>");
					 
					 writer.println("<body bgcolor=violet>");
					 writer.println("<h1>Product Bill Invoice</h1>");
					 writer.println("<p>ProductId: " + prodID+ "</p>");
					 writer.println("<p>ProductName: "+prodName+"</p>");
					 writer.println("<p>ProductPrice:"+ProdPrice+"</p>");
					 writer.println("<p>ProductQuantity:"+prodQuantity+"</p>");
					 writer.println("<p>Discountamount:$"+discount+"</p>");
					 writer.println("<p>TotalBill:$"+TotalBill+"</p>");
					 writer.println("<p>NetBill:$"+netBill+"</p>");
					 writer.println("</html>");
			}
		
		
		
		
	}

