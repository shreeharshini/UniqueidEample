<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Lastname</title>
</head>
<body>
<form action="EditOperation" method="post">  
	<table>  
		<tr >
			<td><input type= 'hidden' name="firstname" value = "${firstname}"/></td>
		</tr>  
		<tr>
			<td>Last Name:</td><td><input type="text" name="lastname" value = "${lastname}"/></td>
		</tr>  
		<tr>
			<td><h1>${uniqueid}</h1><input type='hidden' name="uniqueid" value = "${uniqueid}"/></td>
		</tr>
		
		<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
	</table>
</form>  
</body>
</html>