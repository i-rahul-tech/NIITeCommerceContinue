<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Error</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" />
<div class="container" style="margin-top:15px;">
<h3 class="text-danger">Oops....Something Went Wrong</h3>
<small>Maybe User Already Exist...Try Again With Another Email Id</small>
<br/><br/>
<sf:form modelAttribute="user">
<input name="_eventId_edit" class="btn btn-success" type="submit" value="Try Again" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</sf:form>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>