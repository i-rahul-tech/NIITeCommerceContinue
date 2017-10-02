<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.cont
{
margin:5px 0 0 40%;
font-size:20px;
font-weight:bold;
}
</style>
</head>
<body>
<div class="container-fluid" style="height:40px;margin-top:5px;">
<div class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
    <div class="row">
    <div class="col sm-3">
      <p class="navbar-text pull-left">© 2017 - Owned By GeekY_WeBBeR
           <a href="http://tinyurl.com/tbvalid" target="_blank" >JustBuy.com</a>
      </p>
     </div>
     <div class="col-sm-6" style="margin:8px 0 0 20%;">
      <form action="subscribe/user" method="get">
      <div class="input-group">
      <input type="email" id="userid" name="email_sbc" class="form-control" placeholder="abc@gmail.com" onkeydown="return check1(event)">
      <span class="input-group-btn">
        <button class="btn btn-danger" type="button" onclick="return thanks()">Subscribe</button>
      </span>
    </div>
      </form>	
    </div>
    </div>
</div>
</div>
</div>
<script>
function thanks()
{
var id=document.getElementById("userid").value;
if(id!="")
	{
		var y = window.confirm("Thanks For Showing You Interest In JustBuy. Please Confirm If You Want To Subscribe...");
		if(y)
		{
			window.location.href="Cart.jsp";
			return false;
	    }
		else
		{
			window.location.href="Landing.jsp";
		}
	}
else
	{
		alert("Please Enter A Valid Email ID.....");
	}
}
function check1(e)
{
	if (e.keyCode == 13) {
		var id=document.getElementById("userid").value;
		if(id!="")
			{
				var y = window.confirm("Thanks For Showing You Interest In JustBuy. Please Confirm If You Want To Subscribe...");
				if(y)
				{
					window.location.href="Cart.jsp";
					return false;
			    }
				else
				{
					window.location.href="Landing.jsp";
				}
			}
		else
			{
				alert("Please Enter A Valid Email ID.....");
			}	   
	}
	
}

</script>
</body>
</html>