<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>About - Business Casual - Start Bootstrap Theme</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="brand">CNRS</div>
	<div class="address-bar">146 Rue L�o Saignat 33000 Bordeaux</div>

	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
				<a class="navbar-brand" href="index.html">Business Casual</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="index.html">Home</a></li>
					<li class="active"><a href="#">Ateliers</a></li>
					<li><a href="/Cnrs/atelier">Ajouter un Atelier</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="container">

		<c:forEach var="atelier" items="${ateliers}">

			<div class="row">
				<div class="box">
					<div>
						<h2 class="text-left">
							<strong><c:out value="${atelier.title}" /></strong>
						</h2>
					</div>
					<div>
						<p>
							<c:out value="${atelier.theme}" />
						</p>
					</div>
					<br>
					<div class="row" style="padding: 5px">
						<c:url value="/atelier" var="modify">
							<c:param name="idString">${atelier.idString}</c:param>
						</c:url>
						<a href="${modify}" class="btn btn-default"> <span
							class="glyphicon glyphicon-pencil"></span> Modifier
						</a>
						<c:url value="/atelier" var="voir">
							<c:param name="idString">${atelier.idString}</c:param>
							<c:param name="voir">voir</c:param>
						</c:url>
						<a href="${voir}" class="btn btn-primary"> <span
							class="glyphicon glyphicon-eye-open"></span> Voir
						</a>
						<c:url value="/atelier" var="delete">
							<c:param name="idString">${atelier.idString}</c:param>
							<c:param name="delete">delete</c:param>
						</c:url>
						<input name="idString" type="hidden" value="${atelier.idString}" />
						<a href="${delete}" class="btn btn-danger"> <span
							class="glyphicon glyphicon-remove"></span> Supprimer
						</a>
					</div>

					<div class="clearfix"></div>
				</div>
			</div>
		</c:forEach>

	</div>
	<!-- /.container -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<p>Copyright &copy; Cnrs</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- jQuery Version 1.11.0 -->
	<script src="js/jquery-1.11.0.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
