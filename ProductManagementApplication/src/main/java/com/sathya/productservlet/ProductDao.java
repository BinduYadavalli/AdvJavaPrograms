package com.sathya.productservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;







public class ProductDao {
	private static Object Product;
	private int proId;
	public int save(Product product) throws  SQLException
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int saveResult=0;
		
		try
		{
			connection=dbconnection.createConnection();
			preparedStatement=connection.prepareStatement("insert into Product_data3 values(?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getPromadeIn());
			preparedStatement.setDate(6, product.getPromfgDate());
			preparedStatement.setDate(7, product.getProexpDate());
			
			preparedStatement.setBytes(8,product.getProImage());
			
			preparedStatement.setBytes(9, product.getProAudio());
			preparedStatement.setBytes(10,product.getProVideo());
			
			saveResult=preparedStatement.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connection!=null)
				connection.close();
		}
		return saveResult;
	}
	
	 public List<Product> findAll() {
			
			
			List<Product> productList=new ArrayList<Product>();
			
			try(Connection connection=dbconnection.createConnection();
					Statement statement=connection.createStatement()){
				//execute the query
				ResultSet resultset=statement.executeQuery("select * from Product_data3");
				
				while(resultset.next())
				{
					Product product3 = new Product();
					product3.setProId(resultset.getInt("proId"));
					product3.setProName(resultset.getString("proName"));
					product3.setProPrice(resultset.getDouble("proPrice"));
					product3.setProBrand(resultset.getString("proBrand"));
					product3.setPromadeIn(resultset.getString("promadeIn"));
					product3.setPromfgDate(resultset.getDate("promfgDate"));
					product3.setProexpDate(resultset.getDate("proexpDate"));
					product3.setProImage(resultset.getBytes("proImage"));
					product3.setProAudio(resultset.getBytes("proAudio"));
					product3.setProVideo(resultset.getBytes("proVideo"));
					
					
					productList.add(product3);
				}
       }
			catch(SQLException e) {
				e.printStackTrace();
			}
		return productList;
		
}
	 public int deleteById(int proId )
	 {
		 Connection connection=null;
			PreparedStatement preparedStatement=null;
			int deleteResult=0; 
			
			try
			{
				connection=dbconnection.createConnection();
				preparedStatement=connection.prepareStatement("delete from Product_data3 where proId=?");
				
				
				preparedStatement.setInt(1,proId);
				deleteResult=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return deleteResult;
	 }

	 public  Product findById(int proId) {
	       Product pro=null;
			
			try(Connection connection=dbconnection.createConnection();

				PreparedStatement preparedstatement =connection.prepareStatement("select * from Product_data3 where proId=?"))
			{
				//set the data
				preparedstatement.setInt(1,proId);
				
				//execute the query
				ResultSet resultset=preparedstatement.executeQuery();
				
				if(resultset.next())
				{
				    pro=new Product();
					pro.setProId(resultset.getInt(1));
					pro.setProName(resultset.getString(2));
					pro.setProPrice(resultset.getDouble(3));
					pro.setProBrand(resultset.getString(4));
					pro.setPromadeIn(resultset.getString(5));
					pro.setPromfgDate(resultset.getDate(6));
					pro.setProexpDate(resultset.getDate(7));
					pro.setProImage(resultset.getBytes(8));
					pro.setProAudio(resultset.getBytes(9));
					pro.setProVideo(resultset.getBytes(10));
				}
			}
				catch(SQLException e)
				{
				e.printStackTrace();	
				}
			return pro;
			}
			

public int updateById(Product product )
{
	int updatecount=0;
	try(Connection connection=dbconnection.createConnection();
	PreparedStatement preparedstatement=connection.prepareStatement("update Product_data3 set proName=?,proPrice=?,proBrand=?,promadeIn=?,promfgDate=?,proexpDate=? ,proImage=?,proAudio=?,proVideo=? where ProId=?"))			
	{
		preparedstatement.setString(1,product.getProName());
		preparedstatement.setDouble(2,product.getProPrice());
		preparedstatement.setString(3,product.getProBrand());
		preparedstatement.setString(4,product.getPromadeIn());
		preparedstatement.setDate(5, product.getPromfgDate());
		preparedstatement.setDate(6, product.getProexpDate());
		preparedstatement.setBytes(7, product.getProImage());
		preparedstatement.setBytes(8, product.getProAudio());
		preparedstatement.setBytes(9, product.getProVideo());
		
		preparedstatement.setInt(10, product.getProId());
		
	
		updatecount=preparedstatement.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return updatecount;
}
}


			
		
	
	



