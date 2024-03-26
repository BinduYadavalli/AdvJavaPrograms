function validateform()
{
	//Read the form data.
	var proId=document.getElementById("proId").value;
	var proname=document.getElementById("proname").value;
	var proprice=document.getElementById("proprice").value;
	var probrand=document.getElementById("brand").value;
	var proMadeIn=document.getElementById("madeIn").value;
	
	
	if(proId.trim()==="" || proname.trim()==="" || proprice.trim()==="" || probrand.trim()===""|| proMadeIn.trim()==="" )
	   {
		   alert("All fields must be filled out");
		   return false;
	   }
	   if(parseFloat(proprice)<0)
	   {
		   alert("Product Price must be non-negative value");
		   return false;
	   }
	   if(proname.length >20 || probrand.length >20)
	   {
		   alert("Product name and Product Brand must be Less then 20 characters ");
		   return false;
	   }
	   //get the mfdate and exdate.
	   var proMfdate=document.getElementById("mfDate").value;
	   var proExdate=document.getElementById("exDate").value;
	   
	   //the above fields are convert into date format.
	   var mfdateobj=new Date(proMfdate);
	   var exdateobj=new Date(proExdate);
	   
	   if(mfdateobj>exdateobj)
	   {
		   alert("Manufacturing date can not be Greater then Expired date");
		   return false;
	   }
	   return true;	   
    }