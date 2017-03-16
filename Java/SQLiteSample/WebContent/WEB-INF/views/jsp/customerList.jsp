<%@page import="com.sherif.entity.Customer"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
</head>
<body>

	<table border="1">
		<c:forEach items="${customers}" var='customer'>
			<tr>
					<td><c:out value="${customer.id}"></c:out></td>
					<td><c:out value="${customer.name}"></c:out></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>