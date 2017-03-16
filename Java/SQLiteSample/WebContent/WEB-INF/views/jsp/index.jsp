<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Springy</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />

<script src="resources/js/jquery-3.1.0.min.js"></script>
<script src="resources/js/angular.js"></script>
<script src="resources/js/angular-resource.js"></script>
<script src="resources/js/angular-ui-router.js"></script>
<script src="resources/js/bootstrap.js"></script>

<script src="app/services/erp/erp.services.module.js"></script>
<script src="app/services/erp/customerService.js"></script>

<script src="app/app.js"></script>

<script src="app/views/customer/CustomerListController.js"></script>
<script src="app/views/customer/CustomerDetailsController.js"></script>
<script src="app/views/customer/CustomerAddController.js"></script>

</head>

<body ng-app="app" ng-controller="appController">
	<%@ include file="header.jsp" %>
    <div ui-view ></div>
</body>
</html>