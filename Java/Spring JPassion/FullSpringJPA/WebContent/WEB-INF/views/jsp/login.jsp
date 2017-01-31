<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="resources/css/bootstrap.css" rel="stylesheet" />

<script src="resources/js/jquery-3.1.0.min.js"></script>
<script src="resources/js/angular.js"></script>
<script src="resources/js/angular-resource.js"></script>
<script src="resources/js/angular-ui-router.js"></script>
<script src="resources/js/bootstrap.js"></script>

</head>
<body>
	<div class="container">

		<div class="row">

			<div class="col-xs-12">
				<h2 class="text-center">Login</h2>
				<!-- 
				<div>
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
						<font color="red"> Your login attempt was not successful
							due to <br /> <br /> <c:out
								value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
						</font>
					</c:if>
				</div>
				 -->
				<c:url value="/login.html" var="loginVar" />
				<form method="POST" action="${loginVar}">
					<div class="form-group">
						<label for="email">Email address</label> <input type="email"
							name="email" class="form-control" placeholder="Enter email" />
					</div>

					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							name="password" class="form-control" placeholder="Enter password" />
					</div>

					<div class="checkbox">
						<label> <input type="checkbox" id="rememberMe">
							Remember me
						</label>
					</div>
					<security:csrfInput />
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							Invalid email or password.
						</div>
					</c:if>
					
					<c:if test="${param.logout != null}">
						<div class="alert alert-info">
							You have successfully been logged out.
						</div>
					</c:if>
					<input type="submit" class="btn btn-primary" value="login" />
				</form>
			</div>

		</div>

	</div>
</body>
</html>