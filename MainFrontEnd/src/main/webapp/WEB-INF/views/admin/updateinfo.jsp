 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Info</title>
<style>
	body
	{
	background:url("<c:url value='/resources/images/registerbg.jpg'/>") center no-repeat;
	background-size:100% 100%;
	}
	.form-control
	{
	width:300px;
	}
	table 
	{
  	border-collapse: separate;
  	border-spacing: 40px 0;
	}

	td 
	{
  	padding: 3px 0;
	}
	</style>
	</head>
 <body>
 <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
		<div class="container-fluid">
		<div class=""row">
		<div class="col-sm-4" style="margin:0 0 0 90px;">
		<c:if test="${param.msg != null}">
		<script>alert("${param.msg}")</script>
		</c:if>
		<h2 style="margin-left:210px;"><b>Update Info</b></h2>
				<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
				 <div class="form-group">
				<table>
				<col width="200">
				<col width="200">
				<form action="${context}/admin/updateuserinfo" method="POST"><br />
					<tr>
					<th>Name<sup>*</sup></th>
					</tr>
					<tr>
					<th>First Name</th>
					<th>Last Name</th>
					</tr>
					<tr>
					<td><input type="text" name="ufname" class="form-control" value="${user.ufname}" required/></td>
					<td><input type="text" name="ulname" class="form-control" value="${user.ulname}" required/></td>
					</tr>
					
					<tr>
					<th>Date Of Birth<sup>*</sup></th>
					</tr>
					<tr>
					<td><input type="text" name="dob" value="${user.dob}" class="form-control" required/></td>
					</tr>
					
					<tr>
					<th>Contact<sup>*</sup></th>
					</tr>
					<tr>
					<td><input type="tel" name="contact" value = "${user.contact}" class="form-control" required/></td>
					</tr>
					
					<tr>
					<th>Address<sup>*</sup></th>
					</tr>
					<tr>
					<td><input type="text" name="address" value="${user.address}" class="form-control" required/></td>
					</tr>
					
					<tr>
					<th>Pincode<sup>*</sup></th>
					</tr>
					<tr>
					<td><input type="text" name="pincode" value="${user.pincode}" class="form-control" required/></td>
					</tr>
					
					<tr>
					<th>State<sup>*</sup></th>
					</tr>
					<tr>
					<td><input type="text" name="state" value="${user.state}" class="form-control" required/></td>
					
					<tr>
					<th>Country<sup>*</sup></th>
					</tr>
					<tr>
					<td><input type="text" name="country" value="India" class="form-control" disabled="true"/></td>
					</tr>
					
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					
					<tr>
					<td><input name="submit" type="submit" value="Update" class="btn btn-primary"/></td>
					</tr>
				</form>
				</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>