<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<c:set var="uname" value="${user.ufname}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Address Confirmation</title>

<s:url value="/resources/css" var="css" />
<s:url value="/resources/js" var="js" />
<s:url value="/resources/fonts" var="fonts" />

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
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<!-- Form Container -->

		<div class="form-container">

			<h1>Address Confirmation</h1>
			<form:form method="POST" commandName="user" modelAttribute="user"
				class="form-horizontal">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="ufname">Name</label>
						<div class="col-md-7">
							<form:input type="text" path="ufname" id="ufname"
								class="form-control input-sm text-capitalize" />
							<div class="has-error">
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('ufname')}"
									var="err">
									<div>
										<span style="color: red;">${err.text}</span>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="uemail">Email
							Id</label>
						<div class="col-md-7">
							<form:input type="text" path="uemail" id="uemail"
								class="form-control input-sm" />
							<div class="has-error">
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('uemail')}"
									var="err">
									<div>
										<span style="color: red;">${err.text}</span>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="contact">Contact</label>
						<div class="col-md-7">
							<form:input type="text" path="contact" id="contact"
								class="form-control input-sm" />
							<div class="has-error">
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('contact')}"
									var="err">
									<div>
										<span style="color: red;">${err.text}</span>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
	

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable text-capitalize"
							for="address">address</label>
						<div class="col-md-7">
							<form:input type="text" path="address" id="address"
								class="form-control input-sm" />
							<div class="has-error">
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
									var="err">
									<div>
										<span style="color: red;">${err.text}</span>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable text-capitalize"
							for="pincode">pincode</label>
						<div class="col-md-7">
							<form:input type="text" path="pincode" id="pincode"
								class="form-control input-sm" />
							<div class="has-error">
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('pincode')}"
									var="err">
									<div>
										<span style="color: red;">${err.text}</span>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable text-capitalize"
							for="State">State</label>
						<div class="col-md-7">
							<form:input type="text" path="state" id="state"
								class="form-control input-sm" />
							<div class="has-error">
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('state')}"
									var="err">
									<div>
										<span style="color: red;">${err.text}</span>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable text-capitalize"
							for="country">Country</label>
						<div class="col-md-7">
							<form:input type="text" path="country" id="country"
								class="form-control input-sm" />
							<div class="has-error">
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
									var="err">
									<div>
										<span style="color: red;">${err.text}</span>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>


				<div class="row">
					<div style="text-align: center;">
						<input type="submit" value="Next" name="_eventId_addressSubmit"
							class="btn btn-primary btn-sm">
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>