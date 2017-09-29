<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<!-- Carousel Start -->
	<div class="container-fluid">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="<c:url value='/resources/images/carousel1.PNG'/>"
						alt="Unable To Load Item1" style="width: 100%; height: 300px;">
				</div>

				<div class="item">
					<img src="<c:url value='/resources/images/carousel2.jpg'/>"
						alt="Unable To Load Item2" style="width: 100%; height: 300px;">
				</div>

				<div class="item">
					<img src="<c:url value='/resources/images/carousel3.jpg'/>"
						alt="Unable To Load Item3" style="width: 100%; height: 300px;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!-- Carousel End -->

	<div class="container-fluid" style="margin: 15px 2% 5px 2%">
		<h3>Trending</h3>
		<div class="row">
			<c:forEach items="${proEightList}" var="a">
				<div class="col-sm-3">
					<table>
						<tr>
							<td><a href="trending?pid=${a.prod_id}"><img
									src="<c:url value='${a.prodImg_url}'/>" class="img-thumbnail"
									alt="Unable to Load" style="width: 250px; height: 220px;" /></td>
						</tr>
						<tr>
							<td><a href="trending?pid=${a.prod_id}" style="text-decoration:none;"><p class="text-center text-capitalize"
									style="font-size: 16px;">
									<b>${a.prod_name}</b>
								</p></a></td>
						</tr>
						<tr>
							<td><p class="text-center"
									style="color: #1a66ff; font-size: 15px;">Price: &#x20B9;
									${a.price}</p></td>
						</tr>
					</table>
				</div>
			</c:forEach>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>