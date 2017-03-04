<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Event</title>
<style type="text/css">
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 10px;
}
</style>

</head>
<body>

	<div>
		<a href="?lang=en">English</a> | <a href="?lang=ar">عربى</a> <br /> <br />
	</div>


	<c:url var="formUrl" value="/event" />
	<form:form action="${formUrl}" method="POST" modelAttribute="event" >

		<table>
			<tbody>
				<tr>
					<td>
						<form:errors path="*" cssClass="errorblock" element="div" />
					</td>
				</tr>
				<tr>
					<td><spring:message code="event.name" />:</td>
					<td><input type="text" name="name" /></td>
					<td><form:errors path="name" cssClass="error"/></td>
				</tr>

				<tr>
					<td>Date:</td>
					<td><input type="text" name="eventDate" /></td>
				</tr>
				
				<tr>
					<td>Hoppy:</td>
					<td><input type="text" name="hoppy" /></td>
				</tr>

				<tr>
					<td>Speakers:</td>
					<td><select name="speakers" multiple>
							<option value="SherifMowafy">Sherif Mowafy</option>
							<option value="ZakyGom3a">Zaky Gom3a</option>
							<option value="ElDfaas">El Dfaas</option>
					</select></td>
				</tr>
				<tr>
					<td><br /> <input type="submit" class="btn" value="Enter event" /></td>
				</tr>
			</tbody>
		</table>


		

	</form:form>
</body>
</html>