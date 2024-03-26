package com.sathya.productservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/UpdateproductServlet")
@MultipartConfig
public class UpdateproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private byte[] existingImage;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int proId=Integer.parseInt(request.getParameter("proId"));
		String updateproName=request.getParameter("proName");
		Double upadateproPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updateproBrand=request.getParameter("proBrand");
		String updatepromadeIn=request.getParameter("promadeIn");
		
		Date updatepromfgDate=Date.valueOf(request.getParameter("promfDate"));
		Date updateproexpDate=Date.valueOf(request.getParameter("proexDate"));
		
		Part part=request.getPart("newProImage");
		InputStream inputStream=part.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proImage=IOUtils.toByteArray(inputStream);
		
		
		Part part1=request.getPart("newProAudio");
		InputStream inputStream1=part1.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proAudio=IOUtils.toByteArray(inputStream1);
		
		Part part2=request.getPart("newProVideo");
		InputStream inputStream2=part2.getInputStream();
		//Conversion of inputStream into byte[]
		byte[] proVideo=IOUtils.toByteArray(inputStream2);
		
		

		
		Product prod=new Product();
		prod.setProId(proId);
		prod.setProName(updateproName);
		prod.setProPrice(upadateproPrice);
		prod.setProBrand(updateproBrand);
		prod.setPromadeIn(updatepromadeIn);
		prod.setPromfgDate(updatepromfgDate);
		prod.setProexpDate(updateproexpDate);
		prod.setProImage(proImage);
		prod.setProAudio(proAudio);
		prod.setProVideo(proVideo);

		/*//newProImageis the name of your file input field.
		Part filepart =request.getPart("newProImage");
		if(filepart != null && filepart.getSize() > 0)
		{
			InputStream inputStream=filepart.getInputStream();
			//coversion of inputstream into byte[] array.
			byte[] newProImage =IOUtils.toByteArray(inputStream);
			prod.setProImage(newProImage);
			
		}
		else
		{
			String s=request.getParameter("existingImage");
			
			byte[] existingImage =Base64.getDecoder().decode(s);
			prod.setProImage(existingImage);
		}*/
		ProductDao dao= new ProductDao();
		int result=dao.updateById(prod);
		if(result==1)
		{
			RequestDispatcher dispatcher= request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data updation fail check once..."+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("add-product.html");
			dispatcher.include(request, response);
		}	
	}

}
