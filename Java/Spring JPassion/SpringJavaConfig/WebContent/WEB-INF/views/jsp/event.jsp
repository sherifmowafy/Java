<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Event</title>
<style type="text/css">
.error{
	color: #ff000000;
}

.errorblock{
	color:#000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 10px;
	margin:20px;
}

</style>

</head>
<body>

	<div>
		<a href="?lang=en">English</a>
			|
		<a href="?lang=ar">عربى</a>
				<br/>
		<br/>
	</div>

	<form:form commandName="event" >
		<form:errors path="*" cssClass="errorblock" element="div" />
		<label for="inputEventName"><spring:message code="event.name"/></label>
		<form:input path="name" cssErrorClass="error" name="inputEventName"/>
		<form:errors path="name" cssClass="error" />
		
		<br/>
		
		<input type="submit" class="btn" value="Enter event" />
	
	</form:form>
</body>
</html>