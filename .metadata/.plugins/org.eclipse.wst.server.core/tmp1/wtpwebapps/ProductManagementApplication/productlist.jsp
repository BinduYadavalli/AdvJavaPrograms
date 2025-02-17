<%@page import="com.sathya.productservlet.ProductDao" import="java.util.Base64"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>List of Products</title>
<!-- Bootstrap CDN link to get the support of Bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
	
</head>
<body>
		<h1 class="text-center font-italic text-success mb-5">List Of Products</h1>
		
		<div>
		<a href="add-product.html"  class="btn btn-success mb-1">Save Product</a>
		</div>
		
		<div>
		    <input type="text" placeholder="search"/>
		</div>
		
	<div>
		<c:if test="${saveResult==1}">
			<h1 class="text-success text-center">Data Inserted Successfully</h1>
		</c:if>
	</div>
	
	<div>
		<c:if test="${deleteResult==1}">
			<h1 class="text-danger text-center">Data Deleted Successfully</h1>
		</c:if>
	</div>
	
	<div>
		<c:if test="${deleteResult==0}">
			<h1 class="text-danger text-center">Data Deleted Failed</h1>
		</c:if>
	</div>
	
	<div>
		<c:if test="${updateresult==1}">
		<h2 class="text-success text-center">Data Updated Successfully</h2>
		</c:if>
	</div>
	
	<div>
		<c:if test="${updateresult==0}">
		<h2 class="text-success text-center">Data Updated Failed</h2>
		</c:if>
	</div>
	
	
<table class="table table-bordered table-striped mt-3">
	<thead class="thead-dark">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Cost</th>
			<th>Product Brand</th>
			<th>Product Made In</th>
			<th>Product Manufactured Date</th>
			<th>Product Expired Date</th>
			<th>Product Image</th>
			<th>Product Audio</th>
			<th>Product Video</th>
			<th>Action</th>
			
		</tr>
    </thead>
  <tbody>
    <c:forEach var="product" items="<%=new ProductDao().findAll()%>">
    <tr>
       <td>${product.proId}</td>
       <td>${product.proName}</td>
       <td>${product.proPrice}</td>
       <td>${product.proBrand}</td>
       <td>${product.promadeIn}</td>
       <td>${product.promfgDate}</td>
       <td>${product.proexpDate}</td>
       
       <!-- Display img using img tag -->
       
       <td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="product Image" style="max-width:100px;max-height:100px;">
       </td>
       
       <!-- Display Audio using audio tag -->
       
       <td>
       <audio controls>
       <source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}"></audio>
       </td>
       
       <!-- Display video using video tag -->
       
       <td>
       <video controls width="320" height="240">
       <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}">
       </video>
      </td>
      
       <td>
       <a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId}">Delete</a>
       <a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId}">Edit</a>
       </td>
    </tr>
   </c:forEach> 
</tbody>
</table>

</body>
</html>