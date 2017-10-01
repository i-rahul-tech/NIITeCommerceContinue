<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome To JustBuy</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
		<div class="container">
			<fieldset>
				<legend>Registered Succesfully</legend>
				<!-- here the href's value will be used to decide the 
					 controller to be executed on click of this link.
					 here "home" is mapped in spring mvc controller-->
				
				<br /><br />
				<h2 class="text-success">Welcome ${user.ufname}&nbsp;${user.ulname}, You Have Been Registered Successfully....<br>Hope To Serve You Better</h2>
				<br/>
				<a href="index">Click Here To Continue</a>
			</fieldset>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</body>
</html>