<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
ul > li{margin-right:25px;font-weight:lighter;cursor:pointer}
li.active{border-bottom:3px solid silver;}

.item-photo{display:flex;justify-content:center;align-items:center;border-right:1px solid #f6f6f6;}
.menu-items{list-style-type:none;font-size:11px;display:inline-flex;margin-bottom:0;margin-top:20px}
.btn-success{width:100%;border-radius:0;}
.section{width:100%;margin-left:-15px;padding:2px;padding-left:15px;padding-right:15px;background:#f8f9f9}
.title-price{margin-top:30px;margin-bottom:0;color:black}
.title-attr{margin-top:0;margin-bottom:0;color:black;}
.btn-minus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-right:0;}
.btn-plus{cursor:pointer;font-size:7px;display:flex;align-items:center;padding:5px;padding-left:10px;padding-right:10px;border:1px solid gray;border-radius:2px;border-left:0;}
div.section > div {width:100%;display:inline-flex;}
div.section > div > input {margin:0;padding-left:5px;font-size:10px;padding-right:5px;max-width:18%;text-align:center;}
.attr,.attr2{cursor:pointer;margin-right:5px;height:20px;font-size:10px;padding:2px;border:1px solid gray;border-radius:2px;}
.attr.active,.attr2.active{ border:1px solid orange;}

@media (max-width: 426px) {
    .container {margin-top:0px !important;}
    .container > .row{padding:0 !important;}
    .container > .row > .col-xs-12.col-sm-5{
        padding-right:0 ;    
    }
    .container > .row > .col-xs-12.col-sm-9 > div > p{
        padding-left:0 !important;
        padding-right:0 !important;
    }
    .container > .row > .col-xs-12.col-sm-9 > div > ul{
        padding-left:10px !important;
        
    }            
    .section{width:104%;}
    .menu-items{padding-left:0;}
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
 <div class="container-fluid" style="margin:10px 0 10px 5%;">
 <c:if test="${param.msg != null}">
	<div><span class="text-success text-capitalize">${param.msg}, <a href="${context}/user/usercart" style="text-decoration:none,color:cyan">View Cart</a></span></div>
	</c:if>
        	<div class="row">
               <div class="col-xs-4 item-photo">
                    <img style="max-width:100%;" src=<c:url value = "${product.prodImg_url}" /> />
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                    <h3 class="text-capitalize">${product.prod_name}</h3>    
                    <h5 style="color:#337ab7"><u>Sold By ${product.user.s_comp_name}</u></h5> <small>&nbsp;&nbsp;Quantity Left: ${product.quantity}</small>
        
                    <h6 class="title-price"><small>Price</small></h6>
                    <h3 style="margin-top:0px;">&#8377; ${product.price}</h3>
        
                   <form action="${context}/user/userproductdisplay" method="get">
         <input type="hidden" name="pid" value="${product.prod_id}" />
                    <div class="section" style="padding-bottom:20px;">
                        <h6 class="title-attr"><small>Quantity</small></h6>                    
                        <div>
                            <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
                            <input name="quant" value="1" />
                            <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
                        </div>
                    </div>                       			
        			<div class="section">
        			<c:if test="${(product.category.category_id == 16) || (product.category.category_id == 17)|| (product.category.category_id == 18) || (product.category.category_id == 19)}">
        				<select class="form-control" style="width:100px;">
        				<c:forEach begin="1" end="10" var = "b">
        				<option value="${b}">${b}</option>
        				</c:forEach>
        				</select>
        			</c:if>
        			<c:if test="${(product.category.category_id == 14) || (product.category.category_id == 15)}">
        				<select name="size" class="form-control" style="width:100px;">
        				<option value="small">S</option>
        				<option value="small">M</option>
        				<option value="small">L</option>
        				<option value="small">XL</option>
        				<option value="small">XXL</option>
        				</select>
        			</c:if>
        			</div>
                    
                    <div class="section" style="padding:10px 2% 20px 2%;">
                    <c:if test="${product.quantity > 0}">
                        <button type="submit" class="btn btn-success"><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add To Cart</button>
                    </c:if>
                    <c:if test="${product.quantity <= 0}">
                        <button type="submit" class="btn btn-success" disabled><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Out Of Stock</button>
                    </c:if>
                    </div>
                    </form>
                    <br/> 
                    <div>
                    <small>Note:</small><br/>
                    <span style="background:#f0f0f5;"><b>Available Only In: New Delhi, Mumbai<b></b></span>
                    </div>                                       
                </div>                              
        
                <div class="col-xs-9">
                    <ul class="menu-items">
                        <li class="active">Product Details</li>
                    </ul>
                    <div style="width:100%;border-top:1px solid silver">
                         <p style="padding:15px;" class="text-justify">
                            ${product.prod_description}
                        </p>
                        <!-- small>
                            <ul>
                                <li>Super AMOLED capacitive touchscreen display with 16M colors</li>
                                <li>Available on GSM, AT T, T-Mobile and other carriers</li>
                                <li>Compatible with GSM 850 / 900 / 1800; HSDPA 850 / 1900 / 2100 LTE; 700 MHz Class 17 / 1700 / 2100 networks</li>
                                <li>MicroUSB and USB connectivity</li>
                                <li>Interfaces with Wi-Fi 802.11 a/b/g/n/ac, dual band and Bluetooth</li>
                                <li>Wi-Fi hotspot to keep other devices online when a connection is not available</li>
                                <li>SMS, MMS, email, Push Mail, IM and RSS messaging</li>
                                <li>Front-facing camera features autofocus, an LED flash, dual video call capability and a sharp 4128 x 3096 pixel picture</li>
                                <li>Features 16 GB memory and 2 GB RAM</li>
                                <li>Upgradeable Jelly Bean v4.2.2 to Jelly Bean v4.3 Android OS</li>
                                <li>17 hours of talk time, 350 hours standby time on one charge</li>
                                <li>Available in white or black</li>
                                <li>Model I337</li>
                                <li>Package includes phone, charger, battery and user manual</li>
                                <li>Phone is 5.38 inches high x 2.75 inches wide x 0.13 inches deep and weighs a mere 4.59 oz </li>
                            </ul>  
                        </small-->
                    </div>
                </div>		
            </div>
            <div class="row" style="margin-top:8px; border-top:2px black">
            <h3 style="margin-left:18px;"><b>Reviews</b></h3>
            <c:forEach items="${review}" var = "a">
            <div class="col-sm-9">
            <div class="thumbnail">
            <h4 class="text-capitalize text-primary"><b>${a.name}</b></h4>
            <small><b>${a.verified}</b></small><br/>
            <c:forEach begin="1" end="${a.rating}">
               <span class="glyphicon glyphicon-star"></span>
            </c:forEach>
            <p>${a.review}</p>
            </div>
            </div>
            </c:forEach>
            </div>
        </div>
<script src=<c:url value="/resources/javascript/content.js" /> type="text/javascript"></script>

</body>
</html>