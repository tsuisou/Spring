<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Books</title>
</head>
<body>

		<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
						data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href='<spring:url value="/collection/all"/>'>Library</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href='<spring:url value="/collection/all"/>'>Home</a></li>
						<li><a href='<spring:url value="/collection/add"/>'>Add</a></li>
						<li><a href='<spring:url value="/collection/search"/>'>Search</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>


	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Search book</h1>
			</div>
<%-- 			<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">wyloguj</a>	 --%>
		</div>
	</section>
<!-- 	<div class="pull-right" style="padding-right:50px"> -->
<!-- 				<a href="?language=pl" >polski</a>|<a href="?language=nl" >holenderski</a>					 -->
<!-- 			</div> -->
	<section class="container">
		<form:form  modelAttribute="formSearch" class="form-horizontal">
			<fieldset>
				<legend>Search by category</legend>
<%-- 				<form:errors path="*" cssClass="alert alert-danger" element="div"/> --%>

				<div class="form-group">
					<label class="control-label col-lg-2" for="title">Title</label>
					<div class="col-lg-10">
						<form:input id="title" path="title" type="text" class="form:input-large"/>
						<form:errors path="title" cssClass="text-danger"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="category">Category</label>
					<div class="col-lg-10">
						<form:input id="category" path="category" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Search"/>
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
