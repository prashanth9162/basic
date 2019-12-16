<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${errorMsg}
<h3>Update User Details</h3>
	<form action="updateUser">
		Id : <input type="text" name="id" readonly="readonly" value="${userObj.id}"><br> <br>
		Name : <input type="text" name="name" value="${userObj.name}"><br> <br>
		Mobile : <input type="text" name="mobile" value="${userObj.mobile}"><br> <br>
		City : <input type="text" name="city" value="${userObj.city}"><br> <br>
		Password : <input type="text" name="password" value="${userObj.password}"><br> <br>
		
		<input type="submit" value="Update">
	</form>

</body>
</html>