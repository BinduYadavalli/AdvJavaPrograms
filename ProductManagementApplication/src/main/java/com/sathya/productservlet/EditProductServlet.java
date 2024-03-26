package com.sathya.productservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Product existing;
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the input
		Integer proId=Integer.parseInt(request.getParameter("proId"));
		
		ProductDao dao1=new ProductDao();
		  existing = dao1.findById(proId);
		  
		//sending the product object to edit-form
		  request.setAttribute("existing", existing);
		  
		//forward the request to edit form
		  RequestDispatcher dispatcher = request.getRequestDispatcher("edit_product.jsp");
		  dispatcher.forward(request, response);
		
		
		
	}

}
