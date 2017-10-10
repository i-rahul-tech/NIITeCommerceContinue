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
<style>
.cssTable th,td 
{
    text-align:center; 
    vertical-align:middle;
}
</style>
<title>Welcome Admin</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/admin/adminheader.jsp"></jsp:include>
<div class="container " style="margin-top:30px;">
	<h3 class="text-success">Tables In Database</h3>
	<div class="row">
	<div class="col-sm-12 table-responsive">
		<table class="table table-hover table-bordered cssTable">
		<thead>
			<tr>
				<th>#</th>
				<th>Table Name</th>
				<th>Table Description</th>
				<th>View</th>
			</tr>
		</thead>
		<tr>
		<th>1</th>
		<td class="text-primary">User</td>
		<td class="text-success">Contains All Data About User</td>
		<td class="text-info"><center><a href="${context}/viewuser" class="btn btn-info">View User</a></center></td>
		</tr>
		<tr>
		<th>2</th>
		<td class="text-primary">Supplier</td>
		<td class="text-success">Contains All Data About Supplier</td>
		<td class="text-info"><center><a href="${context}/viewsupplier" class="btn btn-info">View Supplier</a></center></td>
		</tr>
		<tr>
		<th>3</th>
		<td class="text-primary">Products</td>
		<td class="text-success">Contains All Data About Product</td>
		<td class="text-info"><center><a href="${context}/viewproduct" class="btn btn-info">View Product</a></center></td>
		</tr>
		</table>
	</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>