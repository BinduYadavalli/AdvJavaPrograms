package com.sathya.jdbc;

import java.sql.SQLException;

public class ClientCode {

	public static void main(String[] args) throws SQLException {
           EmployeeDao employeeDao=new EmployeeDao();
           
           
           int res1=employeeDao.save(new Employee(1001,"Thanuja",116.0));
           System.out.println("Data Inserted Successfully.."+res1);
           
           
           int res2=employeeDao.save(new Employee(1002,"Bindu",115.0));
           System.out.println("Data Inserted Successfully.."+res2);
           
           //Reading the Data From DataBase
           /*Employee emp=employeeDao.findById(1001);
           System.out.println(emp);*/
           
           /*Employee emp=employeeDao.findById(1003);
           System.out.println(emp);*/
           
           /*deleting the data from database
           int deletecount=employeeDao.DeleteById(1001);
           if(deletecount==1)
           {
        	   System.out.println("Deletion successfully..");
           }
           else
           {
        	   System.out.println("deletion failed..");
           }*/
           
  Employee emp=employeeDao.findBySal(115.0);
  System.out.println(emp);
	}

}