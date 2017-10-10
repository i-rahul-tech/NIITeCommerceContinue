<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.imgcont
{
width:400px;
height:300px
}
.imgcont img {
    width: 350px;
    height: 280px;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" />
<div class="container" style="margin:15px 0 0 10px;">
	<c:if test="${param.msg != null}">
	<script>alert("${param.msg}");</script>
	</c:if>
    <div class="row">
    <c:forEach items="${prod_list}" var="a">
        <div class="col-sm-4">
              <div class="thumbnail">
                <div class="imgcont"><img src=<c:url value="${a.prodImg_url}" /> alt="${a.prodImg_url}" class="img-responsive"></div>
                <div class="caption">
                  <h4 class="pull-right">&#8377; ${a.price}</h4>
                  <h4 class="text-capitalize"><a href="${context}/product/display?pid=${a.prod_id}">${a.prod_name}</a></h4>
                  <small class="text-capitalize text-info">Sold By: ${a.user.s_comp_name}</small>

                </div>
           
                <div class="space-ten"></div>
                <div class="btn-ground text-center">
                	<c:if test="${a.quantity <= 0}">
                	<a href="${context}" class="btn btn-primary" disabled = "true"><i class="fa fa-shopping-cart"></i> Out Of Stock</a>
                	</c:if>
                    <c:if test="${a.quantity > 0}">
                	<a href="${context}/user/product?pid=${a.prod_id}" class="btn btn-primary" id="addcart" onclick="add2cart()"><i class="fa fa-shopping-cart"></i> Add To Cart</a>
                	</c:if>
                    <a href="${context}/product/display?pid=${a.prod_id}" class="btn btn-primary"><i class="fa fa-search"></i> Quick View</a>
                </div>
                <div class="space-ten"></div>
              </div>
            </div>
            </c:forEach>
           </div>
    </div>
    <jsp:include page="/WEB-INF/views/footer.jsp" />
    <script>
    function add2cart()
    {
    	//alert("Product Added To Cart");
    }
    </script>
 </body>
</html>