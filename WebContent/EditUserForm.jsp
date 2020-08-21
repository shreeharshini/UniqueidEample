<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Lastname</title>
<style type="text/css">
	body {
	    text-align: center;
	}
	form {
	    display: inline-block;
	}
</style>
</head>
<body>
<form action="EditOperation" method="post" id = "form">  
	<table>  
		<tr >
			<td><input type= 'hidden' name="firstname" value = "${firstname}"/></td>
		</tr>  
		<tr >
			<td><input type= 'hidden' id="oldlstname" value = "${lastname}"/></td>
		</tr>
		<tr>
			<td>Existing Last Name:</td><td><input type="text" name="origlastname" id= "origlastname" onblur = "lastnamevalid();" /></td>
		</tr> 
		<tr>
			<td>New Last Name:</td><td><input type="text" name="newlastname" id = "newlastname"/></td>
		</tr> 
		<tr>
			<td>Confirm new Last Name:</td><td><input type="text" name="confirmnewlastname" id = "confirmnewlastname" /></td>
		</tr> 
		<tr>
			<td><h1>${uniqueid}</h1><input type='hidden' name="uniqueid" value = "${uniqueid}"/></td>
		</tr>
		
		<tr><td colspan="2"><input type="button" value="Submit" onclick='checkBeforeSubmit();'/></td></tr>  
	</table>
</form>  
</body>
<script type="text/javascript">

var checkBeforeSubmit = function(){
        
	var firstInput = document.getElementById("newlastname").value;
	var secondInput = document.getElementById("confirmnewlastname").value;
    
    if(firstInput == secondInput)
    	document.getElementById("form").submit();
    else 
	    alert("new password and confirm password should be same");
}

function lastnamevalid()
	{ 
	
	var lstnm = document.getElementById("origlastname").value;
	var oldlstnm = document.getElementById("oldlstname").value;
	
	if(lstnm == oldlstnm)
	{
		alert(oldlstnm);
		document.getElementById("origlastname").value = lstnm;
	}
	else
	{
	alert('Please enter valid lastname');
	}
}

</script>
</html>