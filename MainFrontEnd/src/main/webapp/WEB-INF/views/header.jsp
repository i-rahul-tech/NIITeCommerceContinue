<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script-->
<style>
* 
{
	margin: 0px;
	padding: 0px;
}

#imaginary_container {
	margin-top: 2%;
}

.stylish-input-group .input-group-addon {
	background: white !important;
}

.stylish-input-group .form-control {
	border-right: 0;
	box-shadow: 0 0 0;
	border-color: #ccc;
}

.stylish-input-group button {
	border: 0;
	background: transparent;
}

.dropdownstyle {
	width: 30px;
	left: 50%;
	right: auto;
	text-align: center;
	transform: translate(-40%, 0);
}

@import url(http://fonts.googleapis.com/css?family=Roboto);

/****** LOGIN MODAL ******/
.loginmodal-container {
	padding: 30px;
	max-width: 350px;
	width: 100% !important;
	background-color: #F7F7F7;
	margin: 0 auto;
	border-radius: 2px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	overflow: hidden;
	font-family: roboto;
}

.loginmodal-container h1 {
	text-align: center;
	font-size: 1.8em;
	font-family: roboto;
}

.loginmodal-container input[type=submit] {
	width: 100%;
	display: block;
	margin-bottom: 10px;
	position: relative;
}

.loginmodal-container input[type=text], input[type=password] {
	height: 44px;
	font-size: 16px;
	width: 100%;
	margin-bottom: 10px;
	-webkit-appearance: none;
	background: #fff;
	border: 1px solid #d9d9d9;
	border-top: 1px solid #c0c0c0;
	/* border-radius: 2px; */
	padding: 0 8px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
}

.loginmodal-container input[type=text]:hover, input[type=password]:hover
	{
	border: 1px solid #b9b9b9;
	border-top: 1px solid #a0a0a0;
	-moz-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
	-webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
	box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
}

.loginmodal {
	text-align: center;
	font-size: 14px;
	font-family: 'Arial', sans-serif;
	font-weight: 700;
	height: 36px;
	padding: 0 8px;
	/* border-radius: 3px; */
	/* -webkit-user-select: none;
  user-select: none; */
}

.loginmodal-submit {
	/* border: 1px solid #3079ed; */
	border: 0px;
	color: #fff;
	text-shadow: 0 1px rgba(0, 0, 0, 0.1);
	background-color: #4d90fe;
	padding: 17px 0px;
	font-family: roboto;
	font-size: 14px;
	/* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
}

.loginmodal-submit:hover {
	/* border: 1px solid #2f5bb7; */
	border: 0px;
	text-shadow: 0 1px rgba(0, 0, 0, 0.3);
	background-color: #357ae8;
	/* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#357ae8)); */
}

.loginmodal-container a {
	text-decoration: none;
	color: #666;
	font-weight: 400;
	text-align: center;
	display: inline-block;
	opacity: 0.6;
	transition: opacity ease 0.5s;
}

.login-help {
	font-size: 12px;
}

.dropdown-menu.multi-column {
	width: 400px;
}

.astyle {
	text-decoration: none;
	color: white;
	font-size: 16px;
}

.dropdown a:hover {
	text-decoration: none;
	color:yellow;
}
</style>
</head>
<body>
	<div class="container-fluid" style="background: #232f3e; height: 60px;">
		<div class="row">
			<!--Space For Company Logo-->
			<div class="col-sm-2" style="padding: 0 0 0 4%;">
				<a href="${context}/index"><img src="<c:url value='/resources/images/companylogo.png'/>"
					width="120px" height="60px" alt="Space For Company Logo"></a>
			</div>
			<!--End Of Company Logo Space-->
			<!--Search Bar-->
			<div class="col-sm-6" style="margin: 15px 0 0 4%;">
				<form action="${context}/product/search" method="GET">
					<div class="input-group">
						<input type="text" id="searchfor" name="product_name"
							onkeydown="return check(event)" class="form-control"> <span
							class="input-group-btn"> <input class="btn btn-primary"
							type="submit" value="Search" onclick="return redirect()">
						</span>
					</div>
				</form>
			</div>
			<!--End Of Search Bar Container-->
			<div class="col-sm-3" style="padding: 10px 0 0 17%;">
				<p style="color: white">
				<c:if test="${username == null}">
					<b>Wecome To <br>&nbsp;&nbsp;&nbsp;JustBuy</b>
					</c:if>
					<c:if test="${username != null}">
					<b class="text-capitalize" style="padding-left:8px;">Welcome,</b><b class="text-capitalize" style="padding-left:15px;"> &nbsp;${username}</b>
					</c:if>
				</p>
			</div>
		</div>
		<!--End Of Row Container-->
	</div>
	<!-- div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Login to Your Account</h1><br>
				  <form action="login/user" method="POST"> 
				  <div><span style="color:red"></span></div>
					<input type="text" name="user" placeholder="Username">
					<input type="password" name="pass" placeholder="Password">
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </form>
					
				  <div class="login-help">
					<a href="#">Forgot Password</a>
					<a href="registration.obj"> | Register Now</a>
				  </div>
				</div>
			</div>
</div-->
	<!--Start of sub header-->
	<div class="container-fluid"
		style="background: #232f3f; height: 45 px; padding-bottom: 5px;">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-1" style="padding: 11px 6px 0 20px;">
				<div class="dropdown">
					<a href="#" class="dropdown-toggle astyle" id="dropdownMenu1"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						Appliances </a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<c:forEach var="a" items="${appliancesList}">
							<li><a href="${context}/Appliances?name=${a.subcategory_name}">${a.subcategory_name}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="dropdown">
			<div class="col-sm-1" style="padding: 11px 6px 0 24px;">
				<a href="#" class="dropdown-toggle astyle" id="dropdownMenu2"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					Electronics </a>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
					<c:forEach var="a" items="${electronicsList}">
						<li><a href="${context}/Electronics?name=${a.subcategory_name}">${a.subcategory_name}</a></li>
					</c:forEach>
				</ul>
				</div>
			</div>
			<div class="col-sm-1" style="padding: 11px 6px 0 30px;">
			<div class="dropdown">
				<a href="#" class="dropdown-toggle astyle" id="dropdownMenu3"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					Fashion</a>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
					<c:forEach var="a" items="${fashionList}">
						<li><a href="${context}/Fashion?name=${a.subcategory_name}">${a.subcategory_name}</a></li>
					</c:forEach>
				</ul>
				</div>
			</div>
			<div class="col-sm-1" style="padding: 11px 26px 0 15px;">
			<div class="dropdown">
				<a href="#" class="dropdown-toggle astyle" id="dropdownMenu3"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
					Books </a>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
					<c:forEach var="a" items="${bookList}">
						<li><a href="${context}/Books?name=${a.subcategory_name}">${a.subcategory_name}</a></li>
					</c:forEach>
				</ul>
				</div>
			</div>
			<div class="col-sm-3" style="padding: 0 0 0 31%;">
				<div class="dropdown">
					<input type="image"
						src="<c:url value='/resources/images/userlogin.png'/>"
						width="40px" height="40px" class="dropdown-toggle"
						data-toggle="dropdown" style="border-radius: 50%;">
					<ul class="dropdown-menu dropdown-menu-left dropdownstyle">
						<c:if test="${pageContext.request.userPrincipal.name == null}">
						<li><a href="${context}/registration.obj">Create Account</a></li>
						<li><a href="${context}/sregistration.obj">Become Supplier</a></li>
						<li><a href="${context}/login/user">Login</a></li>
						<li><a href="${context}/user/usercart">View Cart</a></li>
						<li class="divider"></li>
						<li><a href="${context}/aboutus">About Us</a></li>
						<li><a href="${context}/contactus">Contact Us</a></li>
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a href="${context}/index">Home</a></li>
						<li><a href="${context}/user/updateinfo">Update Profile</a></li>
						<li><a href="${context}/user/updatepwd">Update Password</a></li>
						<li><a href="${context}/user/usercart">View Cart</a></li>
						<li><a href="${context}/logout">Logout</a></li>
						<li class="divider"></li>
						<li><a href="${context}/aboutus">About Us</a></li>
						<li><a href="${context}/contactus">Contact Us</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>


	<!--This Is JavaScript-->
	<script>
		function redirect() {
			var search = document.getElementById("searchfor").value;
			if (search == "") {
				alert("Enter Something To Be Searched");
			}
		}
		function check(e) {
			var search = document.getElementById("searchfor").value;
			if (e.keyCode == 13) {
				if (search == "") {
					alert("Enter Something To Be Searched");
				}
			}
		}
	</script>
	<!--End Of JavaScript-->


</body>
</html>