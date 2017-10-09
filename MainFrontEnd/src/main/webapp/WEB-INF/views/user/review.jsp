<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body
{
background:url("<c:url value='/resources/images/review1.jpg'/>") center no-repeat;
	background-size:cover; 
}
.input-xlarge {
	width: 400px;
	padding: 9px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 20px;
}
table 
	{
  	border-collapse: separate;
  	border-spacing: 20px 0;
	}

	td 
	{
  	padding: 3px 0;
	}
</style>
<body>
<c:if test="${param.msg != null}">
<script>
alert("${param.msg}");
window.location.href = "${context}/index";
</script>
</c:if>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container-fluid" style="margin:60px 0  0 30%;">
<div class="row">
<div class="col-sm-9 table-responsive">
	<table>
		<form action="${context}/review" method="post">
		<input type="hidden" value="${pid}" name="pid"/>
		<input type="hidden" value="${uid}" name="uid"/>
			<tr>
				<th>Name</th>
				<td><input type="text" class="input-xlarge text-capitalize text-info" name="name"
					value="${uname}" required></td>
			</tr>
			<tr>
				<th>Product Name</th>
				<td><input type="text" class="input-xlarge text-capitalize text-info" name="pname"
					value="${pname}" disabled></td>
			</tr>
			<tr>
				<th>Rating*</th>
				<td><select class="input-xlarge" name="rating"  required>
						<option disabled selected value>-- Rating --</option>
						<option value="1">1 Star</option>
						<option value="2">2 star</option>
						<option value="3">3 Star</option>
						<option value="4">4 Star</option>
						<option value="5">5 Star</option></td>
			</tr>
			<tr>
				<th>Review</th>
				<td><textarea class="input-xlarge text-success" rows="7" cols="100"
						placeholder="What Do You Think About Product..." name="review"
						required maxlength="150"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><span style="margin:10px 0 0 200px;"><input
					type="image" src="<c:url value="/resources/images/review_btn.png"/>" name="submit"></span></td>
			</tr>
		</form>
	</table>
	</div>
	</div>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>