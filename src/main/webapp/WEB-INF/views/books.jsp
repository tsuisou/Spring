<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
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
				<h1>Books</h1>
				<p>All available books in library</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<c:forEach items="${book}" var="books">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<img src="<c:url value="/resource/images/${books.id}.jpg"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${books.title}</h3>
							<p>${books.authorFirstName}</p>
							<p>${books.authorLastName}</p>
							<p>${books.category}</p>
							<p>
								<a
									href=" <spring:url value="/collection/book?id=${books.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
