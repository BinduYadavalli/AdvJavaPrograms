<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="formvalidation.js"></script>
</head>
<body>
<div class="container mt-3 text-center text-bold">

<h2 class="text-center font-italic mb-5">SAVE PRODUCT DETAILS</h2>

<form method="post" action="./UpdateproductServlet" enctype="multipart/form-data" onsubmit="return validateform()">
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="proId">Product ID :</label>
		<input type="number" class="form-control-sm" id="proId" name="proId" value="${existing.proId}" required/>		
	</div>
	
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="proName">Product Name:</label>
		<input type="text" class="form-control-sm" id="proName" name="proName" value="${existing.proName}"  required/>		
	</div>
	
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="proPrice">Product Price:</label>
		<input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existing.proPrice}" required/>		
	</div>
	
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="proBrand">Brand:</label>
		<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existing.proBrand}"  required/>		
	</div>
	
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="promadeIn">Made In :</label>
		<input type="text" class="form-control-sm" id="promadeIn" name="promadeIn" value="${existing.promadeIn}" required/>		
	</div>
	
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="promfDate">Manufactured date:</label>
		<input type="date" class="form-control-sm" id="promfDate" name="promfDate" value="${existing.promfgDate}" required/>		
	</div>
	
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="proexDate">Expired Date:</label>
		<input type="date" class="form-control-sm" id="proexDate" name="proexDate" value="${existing.proexpDate}" required/>		
	</div>
	<!-- Display the current product image -->
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="proImage">Current Product Image:</label>
		<img id="currentImage" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existing.proImage)}" alt="product Image" style="max-width:100px;max-height:100px;">
		<input type="hidden" id="existingImage" name="existingImage" value="${Base64.getEncoder().encodeToString(existing.proImage)}">
	</div>
	
	
	 <!--  Allow the user to upload a new  image -->
     <div class="form-group">
        <label class="font-italic font-weight-bold" for="newproImage">New Product Image: </label>
        <input type="file"  class="form-control-sm"  id="newProImage" name="newProImage" accept="image/*"  required/>
     </div>
     
     
     <div class="form-group">
		<label class="font-italic font-weight-bold" for="proAudio">Current Product Audio:</label>
		<audio controls>
        <source src="data:audio/mp3;base64,${Base64.getEncoder().encodeToString(existingproduct.proAudio)}" type="audio/mp3">
        </audio>
        <input type="hidden" id="existingAudio" name="existingAudio" value="${Base64.getEncoder().encodeToString(existingproduct.proAudio)}">
      </div>
      
      
     <div class="form-group">
        <label class="font-italic font-weight-bold" for="newProAudio">New Product Audio:</label>
		<input type="file" id="newProAudio" name="newProAudio" accept="audio/*">
	</div>
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="proAudio">Current Product Video:</label>
		<video controls width="320" height="240">
        <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(existingproduct.proVideo)}" type="video/mp4">
        </video>
	    <input type="hidden" id="existingVideo" name="existingVideo" value="${Base64.getEncoder().encodeToString(existingproduct.proVideo)}">
	</div>
	
	<div class="form-group">
		<label class="font-italic font-weight-bold" for="newProVideo">New Product Video:</label>
		<input type="file" id="newProVideo" name="newProVideo" accept="video/*">
	</div>
	
	<div>
       <input type="submit" class="btn btn-success" value="Update product"/>
       <a href="Productlist.jsp" class="btn btn-primary">List of Products</a>
    </div>
	
	
	
               
	
	
	
	
     
			
     

		
	
	
	
</div>
</body>
</html>