<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JustBuy.com</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container"
		style="height: 500px; width: 60%; margin: 50px auto; text-algin: center">
		<div class="row  vertical-center">

			<div class="col-md-12" style="align: center;">

				<img src="<c:url value="/resources/images/about_bg.jpg" />"
					style="height: 400px; width: 1500px; border-radius:15px 15px 15px 15px;" class="img-responsive">

				<div class="carousel-caption">
					<h1>About Us !</h1>
					<h3>"JustBuy.com" is an E-Commerce
						portal.</h3>
					<h3>JustBuy enable customers to easily get the products on less
						price</h3>
					<h3>Here, customer can buy various goods at affordable prices</h3>
					<h3>There is a wide range of products to choose from...Happy Shopping with JustBuy</h3>
				</div>

			</div>



		</div>


	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>