package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
	
	
	public int save(Employee emp) throws SQLException 
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		try {
			connection = DBConnection.createConnection();
			preparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");
			
			preparedStatement.setInt(1, emp.getEmpId());
			preparedStatement.setString(2, emp.getEmpName());
			preparedStatement.setDouble(3, emp.getEmpSalary());
			count=preparedStatement.executeUpdate();
			
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
				
					connection.close();
				
			if(preparedStatement!=null)
				
					preparedStatement.close();
				
		}
		return count;
	}
	
	/*public Employee findById(int empId) { 
	
		Employee employee=null;
		try {
	
			Connection connection= DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select * from emp where empId=?");
			
			//set the Data to parameter
			preparedStatement.setInt(1, empId);
			
			//execute query
			ResultSet resultSet=preparedStatement.executeQuery();
			
			//If the record is present execute below code,if the record is not present it returns null
			if(resultSet.next()) 
			{
				//reading the data from ResultSet setting to Employee 
				
				employee=new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return employee;
		}*/
	
	
	
	/*public int DeleteById(int empId) throws SQLException
	{
		int count1=0;
		try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Delete from emp where empId=?"))
		{
			preparedStatement.setInt(1, empId);
			int count1=preparedStatement.executeUpdate();
			
			
		}
		catch(SQLException e)
		{
			e=printStackTrace();
		}
		return count1;
	}*/
	public Employee findBySal(double empSalary) {
		Employee emp=null;
		try {
			Connection connection=DBConnection.createConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("select * from emp where empSalary=?");
			//set the data
			preparedstatement.setDouble(1, empSalary);
			ResultSet resultSet=preparedstatement.executeQuery();
			if(resultSet.next()) {
				emp=new Employee();
				emp.setEmpId(resultSet.getInt(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setEmpSalary(resultSet.getDouble(3));
				
			
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return emp;
		
	}

	
	}