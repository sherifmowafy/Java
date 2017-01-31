<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" ui-sref="home">My New Site ISA</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li ui-sref-active="active"><a ui-sref="home">Home</a></li>
				<li ui-sref-active="active"><a
					ui-sref="customersList({page:1})"> Customers </a></li>
				<li ui-sref-active="active"><a
					ui-sref="customerAdd({customerId:0})"><i
						class="glyphicon glyphicon-plus"></i>Add Customer</a></li>
			</ul>
			<security:authorize access="authenticated" var="authenticated" />
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${authenticated}">
						<li>
							<p class="navbar-text">
								Welcome <security:authentication property="name"/>
								<a id="logout" href='#' >Logout</a>
							</p>
							<form id="logoutForm" action='<c:url value="/logout.html" />' method="POST">
								<security:csrfInput/>
							</form>
						</li>
					</c:when>
					<c:otherwise>
						
							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
									Sign Up</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
									Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>