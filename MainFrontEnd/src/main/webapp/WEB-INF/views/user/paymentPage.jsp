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
<title>Payment Gateway</title>

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
<style>
body {
	margin-top: 0px;
}

.panel-title {
	display: inline;
	font-weight: bold;
}

.checkbox.pull-right {
	margin: 0;
}

.pl-ziro {
	padding-left: 0px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-4"></div>
			<div class="panel-primary col-xs-12 col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Payment Details</h3>
						<div class="checkbox pull-right">
							<label> <input type="checkbox" /> Remember
							</label>
						</div>
					</div>
					<div class="panel-body">
						<form:form method="POST" commandName="payment"
							modelAttribute="payment">
							<div class="form-group">
								<label class="control-label" for="cardNumber"> CARD
									NUMBER</label>
								<div class="input-group">
									<form:input type="text" class="form-control" path="cardno"
										id="cardno" placeholder="Valid Card Number" autofocus="true" />
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-lock"></span></span>
								</div>
								<div>
									<div class="has-error">
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('cardno')}"
										var="err">
										<div>
											<span style="color: red;">${err.text}</span>
										</div>
									</c:forEach>
							</div>

							<div class="form-group">
								<label class="control-label" for="cardName">NAME ON CARD</label>
								<div class="input-group">
									<form:input type="text" class="form-control" path="cardName"
										id="cardName" placeholder="Valid Card Name" />
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-lock"></span></span>
								</div>
								<div class="has-error">
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('cardName')}"
										var="err">
										<div>
											<span style="color: red;">${err.text}</span>
										</div>
									</c:forEach>
								</div>
							</div>

							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label class="control-label" for="expityMonth"> EXPIRY
											DATE</label>
										<div class="col-xs-6 col-lg-6 pl-ziro">
											<form:input type="text" class="form-control" path="mm"
												id="mm" placeholder="MM" />
										</div>
										<div class="has-error">
											<c:forEach
												items="${flowRequestContext.messageContext.getMessagesBySource('mm')}"
												var="err">
												<div>
													<span style="color: red;">${err.text}</span>
												</div>
											</c:forEach>
										</div>
										<div class="col-xs-6 col-lg-6 pl-ziro">
											<form:input type="text" class="form-control" path="yy"
												id="yy" placeholder="YY" />
										</div>
										<div class="has-error">
											<c:forEach
												items="${flowRequestContext.messageContext.getMessagesBySource('yy')}"
												var="err">
												<div>
													<span style="color: red;">${err.text}</span>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<div class="col-xs-5 col-md-5 pull-right">
									<div class="form-group">
										<label class="control-label" for="cvv"> CVV</label>
										<form:input type="password" class="form-control" path="cvv"
											id="cvv" placeholder="CVV" />
									</div>
									<div class="has-error">
											<c:forEach
												items="${flowRequestContext.messageContext.getMessagesBySource('cvv')}"
												var="err">
												<div>
													<span style="color: red;">${err.text}</span>
												</div>
											</c:forEach>
										</div>
								</div>
							</div>

							<ul class="nav nav-pills nav-stacked">
								<li class="active"><a href="#"><span
										class="badge pull-right"><span
											class="glyphicon glyphicon-inr"></span>&#8377
											${cart.getGrandTotal()}</span> Final Payment</a></li>
							</ul>
							<br />
							<input type="submit" value="Pay" name="_eventId_paymentSubmit"
								class="btn btn-success btn-lg btn-block" />
						</form:form>
					</div>
				</div>
			</div>

			<div class="col-xs-12 col-md-4"></div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>