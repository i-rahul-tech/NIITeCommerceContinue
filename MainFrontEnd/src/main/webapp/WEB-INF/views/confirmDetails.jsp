<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Confirm Details</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
 	<style>
 	table 
	{
  	border-collapse: separate;
  	border-spacing: 40px 0;
	}

	td 
	{
  	padding: 3px 0;
	}
	
	.txt
	{
		font-size:16px;
	}
	
 	</style>
	<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
		<div class="container txt" style="margin-top:10px;">
			<fieldset>
				<legend>Confirm Details</legend>
				<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
				 <table class="table">
				<sf:form modelAttribute="user">
				<tr>
					<th><sf:label path="ufname">First Name:</sf:label></th><td>${user.ufname}</td>
				</tr>
				<tr>
					<th><sf:label path="ulname">Last Name:</sf:label></th><td>${user.ulname}</td>
				</tr>
				<tr>
					<th><sf:label path="uemail">Email Id:</sf:label></th><td>${user.uemail}</td>
				</tr>
				<tr>
					<th><sf:label path="password">Password:</sf:label></th><td>${user.password}</td>
				</tr>
				<tr>
					<th><sf:label path="gender">Gender:</sf:label></th><td>${user.gender}</td>
				</tr>
				<tr>
					<th><sf:label path="contact">Contact:</sf:label></th><td>${user.contact}</td>
				</tr>
				<tr>
					<th><sf:label path="address">Address:</sf:label></th><td>${user.address}</td>
				</tr>
				<tr>
					<th><sf:label path="pincode">PinCode:</sf:label></th><td>${user.pincode}</td>
				</tr>
				<tr>
					<th><sf:label path="state">State:</sf:label></th><td>${user.state}</td>
				</tr>
					
				<tr>
					<th><sf:label path="country">Country:</sf:label></th><td>${user.country}</td>
				</tr>
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<tr>
					<td><input name="_eventId_edit" class="btn btn-primary" type="submit" value="Edit" /></td> 
					<td><input name="_eventId_submit" class="btn btn-success" type="submit" value="Confirm Details" /></td>
					</tr>
				</sf:form>
				</table>
			</fieldset>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</body>
</html>
