<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload Image</title>
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

<link href='https://fonts.googleapis.com/css?family=Ubuntu+Mono'
	rel='stylesheet' type='text/css'>
 </head>  
 <body>  
<jsp:include page="/WEB-INF/views/admin/adminheader.jsp" />
<form:form method="post" action="savefile" enctype="multipart/form-data">
<input type="hidden" name="pid" value="${prod_id}" />  
<p><label for="image">Choose Image</label></p>  
<p><input name="file" id="fileToUpload" type="file" /></p> <br/> 
<p><input type="submit" class="btn btn-success" value="Upload"></p>  
</form:form>  
<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>  
</html>  