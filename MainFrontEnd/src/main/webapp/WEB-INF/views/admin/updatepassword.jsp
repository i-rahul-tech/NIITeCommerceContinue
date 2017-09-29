<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<style>
	.form-control
	{
	width:400px;
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
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
		<div class="container-fluid">
		<div class="row">
		<div class="col-sm-4" style="margin:0 0 0 90px;">
		<c:if test="${param.msg != null}">
		<script>alert("${param.msg}")</script>
		<a href="${context}/login/user" class = "btn btn-primary" style="margin:20px 0 0 10%;">Click Here To Continue</a></span></div>
		</c:if>
		<c:if test="${param.msg == null}">
		<h2 style="margin-left:40px;"><b>Update Password</b></h2>
				 <div class="form-group">
				<table>
				<col width="200">
				<col width="200">
				<form action="${context}/admin/updatepassword" method="POST">
					<input type = "hidden" id="oldpassword" value="${upwd}"/>
					<tr>
					<th>Old Password<sup>*</sup></th>
					</tr>
					<tr>
					<td><input type="password" id="oldpwd" name="oldpwd" class="form-control" onblur="chkpwd()" required/></td>
					<td><span style = "color:red;" id = "errormsg"></span></td>
					</tr>
					<tr>
					<th>New Password<sup>*</sup></th>
					</tr>
					<tr>
					<td><input type="password" name="newpwd" class="form-control" required/></td>
					</tr>
					<tr>
					<td><input name="submit" type="submit" value="Update Password" class="btn btn-primary"/></td>
					</tr>
					</form>
					</table>
				</div>
				</c:if>
			</div>
		</div>
</div>
<script>
function chkpwd()
{
	var pwd = document.getElementById('oldpassword').value;
	var opwd = document.getElementById('oldpwd').value;
	if(opwd != "")
	{
		if(opwd != pwd)
			{
				document.getElementById('errormsg').innerHTML = "Old Password Not Correct";
			}
		else if( opwd == pwd)
			{
				document.getElementById('errormsg').innerHTML = "";
			}
	}
}
</script>		
</body>
</html>