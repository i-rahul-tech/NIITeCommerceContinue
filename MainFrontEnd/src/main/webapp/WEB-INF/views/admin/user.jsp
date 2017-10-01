<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <c:set var="context" value="${pageContext.request.contextPath}" />
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Users</title>

</head>
<body>

<jsp:include page="/WEB-INF/views/admin/adminheader.jsp"></jsp:include>
<div class="container-fluid" style="margin-top:15px;">
	<h3 class="text-success">User Table</h3>
	<div class="row">
	<div class="col-sm-12 table-responsive">
		<table class="table table-hover table-border">
			<tr>
				<th>#</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Email Id</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Pincode</th>
				<th>State</th>
				<th>Country</th>
				<th>Role</th>
				<th>Enabled</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${user}" var = "a">
				<c:if test="${a.status == 1}">
				<tr class="success">
				<th>${a.user_id}</th>
				<td class="text-primary">${a.ufname}</td>
				<td class="text-primary">${a.ulname}</td>
				<td class="text-primary">${a.gender}</td>
				<td class="text-primary">${a.uemail}</td>
				<td class="text-primary">${a.dob}</td>
				<td class="text-primary">${a.address}</td>
				<td class="text-primary">${a.pincode}</td>
				<td class="text-primary">${a.state}</td>
				<td class="text-primary">${a.country}</td>
				<td class="text-primary">${a.role}</td>
				<td class="text-primary">${a.enable}</td>
				<c:if test="${a.status == 1}">
				<td class="text-info"><a href="${context}/updateuser?uid=${a.user_id}" class="btn btn-danger">Disable</a></td>
				</c:if>
				</tr>
				</c:if>
				<c:if test="${a.status == 0}">
				<tr class="danger">
				<th>${a.user_id}</th>
				<td class="text-primary">${a.ufname}</td>
				<td class="text-primary">${a.ulname}</td>
				<td class="text-primary">${a.gender}</td>
				<td class="text-primary">${a.uemail}</td>
				<td class="text-primary">${a.dob}</td>
				<td class="text-primary">${a.address}</td>
				<td class="text-primary">${a.pincode}</td>
				<td class="text-primary">${a.state}</td>
				<td class="text-primary">${a.country}</td>
				<td class="text-primary">${a.role}</td>
				<td class="text-primary">${a.enable}</td>
				<td class="text-info"><a href="${context}/updateuser?uid=${a.user_id}" class="btn btn-success">Enable</a></td>
				</tr>
				</c:if>
		</c:forEach>
		</table>
	</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>