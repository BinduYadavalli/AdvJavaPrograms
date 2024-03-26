package com.sathya.productservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/AddproductServlet")
@MultipartConfig
public class AddproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		//Reading the data from form(html).
		int proId=Integer.parseInt(request.getParameter("proId"));
		String proName=request.getParameter("proName");
		Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String promadeIn=request.getParameter("promadeIn");
		
		Date promfgDate=Date.valueOf(request.getParameter("promfDate"));
		Date proexpDate=Date.valueOf(request.getParameter("proexDate"));
		
		Part part =request.getPart("proImage");
		InputStream inputStream=part.getInputStream();	
		
		//coversion of inputstream into byte[] array.
		byte[] proImage =IOUtils.toByteArray(inputStream);
		
		Part part1 =request.getPart("proAudio");
		InputStream inputStream1=part.getInputStream();	
		
		//coversion of inputstream into byte[] array.
		byte[] proAudio =IOUtils.toByteArray(inputStream1);
		
		Part part2 =request.getPart("proImage");
		InputStream inputStream2=part.getInputStream();	
		
		//coversion of inputstream into byte[] array.
		byte[] proVideo =IOUtils.toByteArray(inputStream2);
		
		
		//PrintWriter writer=response.getWriter();
		//response.setContentType("text/html");
		//writer.println("save Product Successfully");
		
		//Using  above Details create the Product Object.
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setPromadeIn(promadeIn);
		product.setPromfgDate(promfgDate);
		product.setProexpDate(proexpDate);
		product.setProImage(proImage);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
		
		//Giving the Product object to ProductDao layer.
		ProductDao productdao=new ProductDao();
		
			
		int result = 0;
		try {
			result = productdao.save(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==1)
		{
			//to send the data to JSP file add the data into request object
			request.setAttribute("saveResult",result );
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data Inserted failed"+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
			dispatcher.include(request, response);
		}
	}

}
