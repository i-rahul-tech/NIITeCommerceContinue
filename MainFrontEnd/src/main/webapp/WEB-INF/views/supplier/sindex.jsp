<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <c:set var="context" value="${pageContext.request.contextPath}" />
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="style.css" rel="stylesheet" type="text/css" />
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Supplier</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/supplier/sheader.jsp"></jsp:include>
<div class="container-fluid" style="margin-top:15px;">
	<h3 class="text-success">Supplier Profile</h3>
	<div class="row">
	<div class="col-sm-5 table-responsive">
		<table class="table table-hover table-border">
			<tr>
				<th>First Name:</th><td>${supplier.ufname}</td>
				</tr>
				<tr>
				<th>Last Name:</th><td>${supplier.ulname}</td>
				</tr>
				<tr>
					<th>Company Name:</th><td>${supplier.s_comp_name}</td>
				</tr>
				<tr>
					<th>Email Id:</th><td>${supplier.uemail}</td>
				</tr>
				<tr>
					<th>Gender:</th><td>${supplier.gender}</td>
				</tr>
				<tr>
					<th>Contact:</th><td>${supplier.contact}</td>
				</tr>
				<tr>
					<th>Address:</th><td>${supplier.address}</td>
				</tr>
				<tr>
					<th>PinCode:</th><td>${supplier.pincode}</td>
				</tr>
				<tr>
					<th>State:</th><td>${supplier.state}</td>
				</tr>
				<tr>
				<th>No. Of Product Sold</th><td>${total}</td>
				</tr>
				<tr>
					<th>Country:</th><td>${supplier.country}</td>
				</tr>
		</table>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>