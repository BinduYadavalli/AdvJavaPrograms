package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//STEP-1:Read the data.
		int eid=Integer.parseInt(request.getParameter("Eid"));
		String ename=request.getParameter("Ename");
		int esal=Integer.parseInt(request.getParameter("Esal"));
		
		//STEP-2:Process the data
		float hra,da,pf,gross_sal;
		if(esal>50000)
		{
			hra=30*esal/100;
			da=10*esal/100;
			pf=6*esal/100;
			gross_sal=esal+hra+da-pf;
		}
			else if(((esal>25000)&&(esal<=50000)))
			{
				hra=20*esal/100;
				da=5*esal/100;
				pf=3*esal/100;
				gross_sal=esal+hra+da-pf;
			}
				else
				{
					hra=10*esal/100;
					da=3*esal/100;
					pf=2*esal/100;
					gross_sal=esal+hra+da-pf;
					
				}
		
		//Step-3:render the response to client
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("Employee ID :"+eid);
		writer.println("Employee Name :"+ename);
		writer.println("Employee Salary :"+esal);
		writer.println("Employee HRA :"+hra);
		writer.println("Employee DA :"+da);
		writer.println("Employee PF :"+pf);
		writer.println("Employee GROSS_AMOUNT :"+gross_sal);
		writer.println("</html>");			
			}
		
	}


