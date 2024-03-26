function validateform()
{
	//Read the form data.
	var proId=document.getElementById("proId").value;
	var proName=document.getElementById("proName").value;
	var proPrice=document.getElementById("proPrice").value;
	var proBrand=document.getElementById("proBrand").value;
	var promadeIn=document.getElementById("promadeIn").value;
	
	
	if(proId.trim()==="" || proName.trim()==="" || proPrice.trim()==="" || proBrand.trim()===""|| promadeIn.trim()==="" )
	   {
		   alert("All fields must be filled out");
		   return false;
	   }
	   if(parseFloat(proPrice)<0)
	   {
		   alert("Product Price must be non-negative value");
		   return false;
	   }
	   if(proName.length >20 || proBrand.length >20)
	   {
		   alert("Product name and Product Brand must be Less then 20 characters ");
		   return false;
	   }
	   //get the mfdate and exdate.
	   var promfdate=document.getElementById("promfDate").value;
	   var proexdate=document.getElementById("proexDate").value;
	   
	   //the above fields are convert into date format.
	   var mfdateobj=new Date(promfdate);
	   var exdateobj=new Date(proexdate);
	   
	   if(mfdateobj>exdateobj)
	   {
		   alert("Manufacturing date can not be Greater then Expired date");
		   return false;
	   }
	   return true;	   
    }