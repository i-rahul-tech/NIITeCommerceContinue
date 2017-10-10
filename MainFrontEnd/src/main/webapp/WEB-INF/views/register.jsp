<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>JustBuy:Register Now</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
	body
	{
	background:url("<c:url value='/resources/images/registerbg.jpg'/>") center no-repeat;
	background-size:100% 100%;
	}
	.form-control
	{
	width:300px;
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
	</head>
 <body>
		<div class="container-fluid">
		<div class=""row">
		<div class="col-sm-4"><h2>Welcome To JustBuy.....</h2>
		<h3>SignUp For free.....</h3>
		</div>
		<div class="col-sm-4" style="margin:0 0 0 140px;">
		<h2 style="margin-left:210px;"><b>Registration</b></h2>
				<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
				 <div class="form-group">
				<table>
				<col width="200">
				<col width="200">
				<sf:form modelAttribute="user"><br />
					<tr>
					<th>Name<sup>*</sup></th>
					</tr>
					<tr>
					<td><sf:label path="ufname">First Name</sf:label></td>
					<td><sf:label path="ulname">Last Name</sf:label></td>
					</tr>
					<tr>
					<td><sf:input path="ufname" name="ufname" class="form-control" placeholder="Friends Call You....."/></td>
					<td><sf:input path="ulname" name="ulname" class="form-control"/></td>
					</tr>
					<tr>
					<!-- to display First Name validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('ufname')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					<tr>
					<td><sf:label path="gender">Gender<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td>
					<sf:select path="gender" class="form-control">
            		<sf:option value="null" label="----I Am----"/>
            		<sf:option value="Male" label="Male"/>
                	<sf:option value="Female" label="Female"/>
                	</sf:select>
					</td>
					<!-- to display First Name validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('gender')}" var="err">
					 <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					
					<tr>
					<td><sf:label path="uemail">Email Id<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td><sf:input path="uemail" name="uemail" placeholder="email" class="form-control"/></td>
					<!-- to display Email validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('uemail')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					<tr>
					<td><sf:label path="password">Password<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td><sf:password name="password" path="password" class="form-control"/></td>
					<!-- to display Password validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					
					<tr>
					<td><sf:label path="dob">Date Of Birth<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td><sf:input type="date" name="dob" path="dob" placeholder="01/01/1970" class="form-control"/></td>
					<!-- to display Password validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('dob')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					
					<tr>
					<td><sf:label path="contact">Contact<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td><sf:input type="tel" name="contact" path="contact" placeholder="95**********" class="form-control"/></td>
					<!-- to display Contact validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('contact')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					
					<tr>
					<td><sf:label path="address">Address<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td><sf:input name="address" path="address" class="form-control"/></td>
					<!-- to display Address validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('address')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					
					<tr>
					<td><sf:label path="pincode">Pincode<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td><sf:input name="pincode" path="pincode" class="form-control"/></td>
					<!-- to display Pincode validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('pincode')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					
					<tr>
					<td><sf:label path="state">State<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td><sf:input name="state" path="state" placeholder="Delhi" class="form-control"/></td>
					<!-- to display State validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('state')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					
					<tr>
					<td><sf:label path="country">Country<sup>*</sup></sf:label></td>
					</tr>
					<tr>
					<td><sf:input name="country" path="country" value="India" class="form-control"/></td>
					<!-- to display Pincode validation messages -->
					<td><c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('country')}" var="err">
					  <div><span style="color:red;">${err.text}</span></div>
					</c:forEach></td>
					</tr>
					
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					
					<tr>
					<td><input name="_eventId_submit" type="submit" value="Submit" class="btn btn-primary"/></td>
					</tr>
				</sf:form>
				</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>