package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	private Object connection;

	/*public int createProductTable(){
		Connection connection=null;
		Statement statement=null;
		int count=0;
		try
		{
		 connection=Dbconnection.createConnection();
		 statement=connection.createStatement();
		 count= statement.executeUpdate("create table product(ProdId number,ProdName varchar2(20),Price number)");
		 System.out.println("table is created successfully"+count);
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return count;
	} */
	
	public int saveProduct(product product1) throws SQLException
	{		
		 Connection connection=null;
		 PreparedStatement preparedstatement=null;
		 int count1=0;
		 try
		 {
			//get the connection
			connection=Dbconnection.createConnection();
			preparedstatement=connection.prepareStatement("insert into product values(?,?,?)");
			//add the data values into parameters.
			preparedstatement.setInt(1,product1.getProdId());
			preparedstatement.setString(2, product1.getProdname());
			preparedstatement.setDouble(3,product1.getPrice());
			
			count1=preparedstatement.executeUpdate();
		 }
		 catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 if(connection!=null)
				 connection.close();
			 if(preparedstatement!=null)
				 preparedstatement.close();
			 
		 }
		 return count1;
	
	}
	 //getting details based on id
	 
	 public product getProductById(int productId) {
        product product=null;
		
		try(Connection connection=Dbconnection.createConnection();

			PreparedStatement preparedstatement =connection.prepareStatement("select * from product2 where productId=?"))
		{
			
			
	
			//set the data
			preparedstatement.setInt(1,productId);
			
			//execute the query
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				product=new product();
				product.setProdId(resultset.getInt(1));
				product.setProdname(resultset.getString(2));
				product.setPrice(resultset.getDouble(3));
				
				
				
				
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public List<product> getAllProducts() {
			
			
			List<product> products=new ArrayList<product>();
			try(Connection connection=Dbconnection.createConnection();
					Statement statement=connection.createStatement()){
				//execute the query
				ResultSet resultset=statement.executeQuery("select * from product");
				
				while(resultset.next())
				{
					product product3 = new product();
					product3.setProdId(resultset.getInt(1));
					product3.setProdname(resultset.getString(2));
					product3.setPrice(resultset.getDouble(3));
					
					products.add(product3);
				
			}
				
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return products;
}
	 
	 
	 
	 //update by price  
	 
	 
	 public int updateByPrice(double priceRange, double IncrementValue)
		{
			int count=0;
			try(Connection connection=Dbconnection.createConnection();
			PreparedStatement preparedstatement=connection.prepareStatement("update product2 set ProductPrice=ProductPrice+? where ProductPrice>?"))			
			{
				preparedstatement.setDouble(1, priceRange);
				preparedstatement.setDouble(2, IncrementValue);
			
				count=preparedstatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
	 
	 
	 
	 
	 public int deleteById(int productId) throws SQLException
		{
			int count=0;
			try(Connection connection=Dbconnection.createConnection();
				PreparedStatement preparedstatement=connection.prepareStatement("delete from product2 where productId=?"))
			{
				preparedstatement.setInt(1,productId);
				count=preparedstatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}

	 
	 


	 public static double deleteByPrice(double productPrice) throws SQLException
		{
			int count=0;
			try(Connection connection=Dbconnection.createConnection();
				PreparedStatement preparedstatement=connection.prepareStatement("delete from product2 where productPrice=?"))
			{
				preparedstatement.setDouble(1,productPrice);
				count=preparedstatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
	 
	 
	 public static int dropTable() {
			

		   
        // Establishing a connection to the database
    		try(Connection connection=Dbconnection.createConnection();
        Statement statement = connection.createStatement() ) 
    		{
        // Executing the SQL command to drop the table
        statement.executeUpdate("DROP TABLE product2");
        System.out.println("Table dropped successfully.");
    } catch (SQLException e) {
        // Handling any SQL exceptions
        e.printStackTrace();
    }
				return 0;
	
	 
	 }
}
	
		
		
		
		
	


