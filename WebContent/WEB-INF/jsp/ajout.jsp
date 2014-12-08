<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Circuit scientifique bordelais</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery Version 1.11.0 -->
<script src="js/jquery-1.11.0.js"></script>
<script src="js/jquery-ui.js"></script>
<link href="css/jquery-ui.css" rel="stylesheet">

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

<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>

</head>

<body>

	<div class="brand">CNRS</div>
	<div class="address-bar">146 Rue Léo Saignat 33000 Bordeaux</div>

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
					<li><a href="/Cnrs/ateliers">Ateliers</a></li>
					<li class="active"><a href="/Cnrs/atelier">Ajouter un Atelier</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="container">

		<%-- Formulaire d'ajout --%>
		<form role="form" action="/Cnrs/atelier" method="POST">
			<input type="hidden" value="${idString}" />
			<div class="form-group">
				<label for="date">Date</label> <span class="text-danger">*</span>
				<div class="controls">
					<div class="input-group">
						<input id="date" name="date" type="text"
							value="<fmt:formatDate value="${atelier.date}" pattern="dd/MM/yyyy" />"
							class="datepicker form-control"> <label for="date"
							class="input-group-addon btn"> <span
							class="glyphicon glyphicon-calendar"></span>
						</label>
					</div>
				</div>
				<span class="text-danger"><c:out
						value="${erreurs['erreurDate']}" /></span>

			</div>

			<div class="form-group">
				<label for="title">Titre</label> <span class="text-danger">*</span>
				<input name="title" value="<c:out value="${atelier.title}"/>"
					type="text" class="form-control" id="title" placeholder="Titre">
				<span class="text-danger"><c:out
						value="${erreurs['erreurTitle']}" /></span>

			</div>

			<div class="form-group">
				<label for="labo">Théme</label> <span class="text-danger">*</span>
				<select id="theme" name="theme" class="form-control">
					<c:forEach var="theme" items="${themes}">
						<option value="${theme.value}">${theme.value}</option>
					</c:forEach>
				</select> <span class="text-danger"><c:out
						value="${erreurs['erreurTheme']}" /></span>

			</div>

			<div class="form-group">
				<label for="labo">Laboratoire</label> <span class="text-danger">*</span>
				<input name="labo" value="<c:out value="${atelier.labo}"/>"
					type="text" class="form-control" id="labo"
					placeholder="Laboratoire"> <span class="text-danger"><c:out
						value="${erreurs['erreurLabo']}" /></span>
			</div>

			<div class="form-group">
				<label for="address">Adresse</label> <span class="text-danger">*</span>
				<input name="address" value="<c:out value="${atelier.address}"/>"
					type="text" class="form-control" id="address" placeholder="Adresse">
				<span class="text-danger"><c:out
						value="${erreurs['erreurAddress']}" /></span>
			</div>

			<div class="form-group">
				<label for="city">Ville</label> <span class="text-danger">*</span> <input
					name="city" value="<c:out value="${atelier.city}"/>" type="text"
					class="form-control" id="city" placeholder="Ville"> <span
					class="text-danger"><c:out value="${erreurs['erreurCity']}" /></span>
			</div>

			<div class="form-group">
				<label for="cp">CP</label> <span class="text-danger">*</span> <input
					name="cp" value="<c:out value="${atelier.cp}"/>" type="text"
					class="form-control" id="cp" placeholder="CP"> <span
					class="text-danger"><c:out value="${erreurs['erreurCp']}" /></span>
			</div>

			<div class="form-group">
				<label for="description">Description</label>
				<textarea name="description" rows="5"
					class="form-control placeholder="Description" value="<c:out value="${atelier.description}"/>"></textarea>
				<br> <span class="text-danger"><c:out
						value="${erreurs['erreurDescription']}" /></span>
			</div>

			<button type="submit" class="btn btn-default">Enregistrer</button>
		</form>
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

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
