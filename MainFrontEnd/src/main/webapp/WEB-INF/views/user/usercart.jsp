<%@ page language="java" contentType="text/html; cha&#x20B9;et=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; cha&#x20B9;et=ISO-8859-1">
<style>
</style>
</head>
<body>
 <c:if test="${param.oos != null}">
	<script>alert("${param.oos}");
	</script>
	</c:if>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container-fluid" style="margin-top:7px;">
<h1 class="text-capitalize">Hello ${username},</h1>
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<c:forEach items="${cartlist}" var = "a">
					<tbody>
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="<c:url value='${a.product.prodImg_url}'/>" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<a href="${context}/product/display?pid=${a.product.prod_id}" style="text-decoration:none;color:black;"><h4 class="nomargin text-capitalize">${a.product.prod_name}</h4></a>
										<p class="text-capitalize">${a.product.prod_description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price"><input type="hidden" id="price" value="${a.product.price}"/><p id="setprice">&#x20B9; ${a.product.price}</p></td>
							<td data-th="Quantity">
							<form action="${context}/refreshcart" method="GET">
								<input type="number" id="cartid" name="quantity" class="form-control text-center" value="${a.sell_quantity}"/>
								<input type="hidden" value="${a.product.prod_id}" name="pid"/>
								<button type="submit" class="btn btn-info btn-sm" style="margin-left:10px;"><i class="fa fa-refresh"></i></button>
							</form>
							</td>
							<td data-th="Subtotal" class="text-center"><input type="hidden" id="subprice" value="${a.total_price}"/><p id="setsubprice">&#x20B9; ${a.total_price}</p></td>
							<td class="actions" data-th="">
								
								<a href="${context}/deletecartitem?cartid=${a.cartItem_Id}" class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></a>								
							</td>
						</tr>
					</tbody>
					</c:forEach>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total &#x20B9; ${total}</strong></td>
						</tr>
						<tr>
							<td><a href="${context}/index" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong><input type="hidden" id="totalprice" value="32999"/>Total &#x20B9; ${total}</strong></td>
							<c:if test="${csize > 0}">
							<td><a href="${context}/checkoutData" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
							</c:if>
							<c:if test="${csize <= 0}">
							<td><a href="#" class="btn btn-success btn-block" disabled onclick="alert('You Cannot Checkout. Add Some Product To Cart To Checkout')">Checkout <i class="fa fa-angle-right"></i></a></td>
							</c:if>
						</tr>
					</tfoot>
				</table>
</div>
<script>

</script>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>