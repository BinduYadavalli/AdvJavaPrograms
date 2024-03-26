package jdbc;

import java.sql.SQLException;
import java.util.List;

public class ProductClientCode {

	public static void main(String[] args) throws SQLException {
		
		ProductDao productdao=new ProductDao();
		
		/*int res1=productdao.createProductTable();
		System.out.println("table is created successfully"+res1);*/
		
		int res2=productdao.saveProduct(new product(1,"soap",98.7));
		System.out.println(res2);
		int res3=productdao.saveProduct(new product(2,"rice",899.6));
		System.out.println(res3);
		int res4=productdao.saveProduct(new product(3,"mouce",155.6));
		System.out.println(res4);
		
		 product product=productdao.getProductById(1);  
    	System.out.println(product);
    	
    	
    	
    	
    	
    	List<product> pro=productdao.getAllProducts();
		for(product p: pro)
			System.out.println(p);
		
		
		
		
		
		
		int updatecount=productdao.updateByPrice(400,50);

		System.out.println(updatecount+" rows updated");
		
		
		
		int deleterecord=productdao.deleteById(1);
		if(deleterecord==1) {
			System.out.println("deleted record successfully");
		}
		else
			System.out.println("deleted record  not successfully");
	}


     double deleterecord= ProductDao.deleteByPrice(1699);
	if(deleterecord==1) 
		System.out.println("deleted record successfully");
	
	else
		System.out.println("deleted record  not successfully");

	
	int deletetable=ProductDao.dropTable();
	System.out.println("deleted successfully");

}
		
		

	}


