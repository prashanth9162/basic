<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cr" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
		function deleteUser(id) {

			alert('triggred Delete button' + id);
			document.forms[0].action = "${pageContext.request.contextPath}/deleteUser?idToDelete="
					+ id;
			document.forms[0].method = "post";
			document.forms[0].submit();
		}

		function editUser(id) {
			alert('triggered Edit button' + id);
			document.forms[0].action="${pageContext.request.contextPath}/editView?idtoedit="+id;
			document.forms[0].method="post";
			document.forms[0].submit();	
		}
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
<form action="deleteUser">
		<!-- Need to write for each in jsp to iterate userList -->
		<table border="3">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>City</th>
				<th>Password</th>
			</tr>
			<cr:forEach var="userObject" items="${userList}">
				<tr>
					<td>${userObject.id}</td>
					<td>${userObject.name}</td>
					<td>${userObject.mobile}</td>
					<td>${userObject.city}</td>
					<td>${userObject.password}</td>
					<td><input type="button"
						onclick="editUser('${userObject.id}')" value="Edit"></td>
					<td><input type="button"
						onclick="deleteUser('${userObject.id}')" value="Delete"></td>
				</tr>
			</cr:forEach>
		</table>
	</form>

</body>
</html>