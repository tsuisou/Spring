<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Books</title>
</head>
<body>
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
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${book.title}</h3>
							<p>${book.authorFirstName}</p>
							<p>${book.authorLastName}</p>
							<%-- 							<p>Liczba sztuk w magazynie: ${product.unitsInStock}</p> --%>
							<p>
								<a href="#" class="btn btn-warning btn-large"> <span
									class="glyphicon-shopping-cart glyphicon"></span> Order now
								</a> <a href="<spring:url value="/collection/all" />" class="btn btn-default"> <span
									class="glyphicon-hand-left glyphicon"></span> back
								</a>

							</p>
						</div>
					</div>
				</div>
		</div>
	</section>
</body>
</html>
