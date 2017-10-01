<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Product</title>
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
<style>
.monospaced {
	font-family: 'Ubuntu Mono', monospaced;
}

.add-to-cart .btn-qty {
	width: 52px;
	height: 46px;
}

.add-to-cart .btn {
	border-radius: 0;
}

.add-to-cart {
	margin: 25px auto 10px 5px;
}

.imgcont img {
	width: 350px;
	height: 470px;
}

.input-xlarge {
	width: 100%;
	padding: 9px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 20px;
}
</style>
</head>
<body>
	<c:if test="${param.err != null}">
		<script>
			alert('${param.err}');
		</script>

	</c:if>
	<jsp:include page="/WEB-INF/views/supplier/sheader.jsp" />
	<div class="container" id="product-section">
		<div class="row" style="margin: 40px auto 10px 50px;">
			<div class="col-md-6" style="background: #ECF0F1;">
				<form action="${context}/saddproduct" method="POST"> 
						<label>Brand Name<span
						class="text-danger">*</span> :
					</label> <input required type="text" name="prodbrand"
						class="input-xlarge" autofocus />
						<label>Product Name<span
						class="text-danger">*</span> :
					</label> <input required type="text" name="prodname"
						class="input-xlarge" autofocus />

					<label>Product Description<span class="text-danger">*</span> :
					</label> <textarea rows="7" cols="7" required name="description"
						 class="input-xlarge" > </textarea>
						 
				 <label>Price<span
						class="text-danger">*</span> :
					</label> <input required type="number" name="price"
						 class="input-xlarge" />

				 <label>Quantity<span
						class="text-danger">*</span> :
					</label> <input required type="text" name="quantity" class="input-xlarge" />
						
						<select name="subcategory" required class="input-xlarge">
						<option disabled selected value>---Category---</option>
						<c:forEach items="${categoryList}" var="a">
						<option value="${a.subcategory_name}">${a.subcategory_name}</option>
						</c:forEach>
						</select>

					<input type="submit"
						class="btn btn-primary btn-lg glyphicon glyphicon-arrow-up"
						value="Save" />

				</form>
			</div>
			<!-- end row -->

		</div>
	</div>


<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>