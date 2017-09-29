function verifyname()
{
	var getfname=document.getElementById("fname").value;
	if(getfname=="")
	{
		document.getElementById("fnamerr").innerHTML="This Field Cannot Be Empty";
	}
	else if(getfname!="")
	{
			document.getElementById("fnamerr").innerHTML="";
	}
}
function verifygender()
{
	var gender=document.getElementById("ugender").value;
	if(gender=="")
	{
		document.getElementById("gendererr").innerHTML="This Field Cannot Be Empty";
	}
	else if(gender!="")
	{
			document.getElementById("gendererr").innerHTML="";
	}
}
function verifyemail()
{
	var email=document.getElementById("email").value;
	if(email=="")
	{
		document.getElementById("emailerr").innerHTML="This Field Cannot Be Empty";
	}
	else if(email!="")
	{
			document.getElementById("emailerr").innerHTML="";
	}
}
function verifypwd()
{
	var pwd=document.getElementById("pwd").value;
	var len=pwd.length;
	if(pwd=="")
	{
		document.getElementById("pwderr").innerHTML="This Field Cannot Be Empty";
	}
	else if((len<6) || (len>16))
	{
		document.getElementById("pwderr").innerHTML="";
		alert("Password Should Be Greater than 6 Letters And Less Than 16 Letters");
	}
}
function checkpwd()
{
	var cnfpwd=document.getElementById("cpwd").value;
	if(cnfpwd=="")
	{
		document.getElementById("pwderrs").innerHTML="This Field Cannot Be Empty";
	}
	else if(cnfpwd!="")
	{
			document.getElementById("pwderrs").innerHTML="";
			var pwd=document.getElementById("pwd").value;
			if(pwd!=cpwd)
			{
				alert("Password Not Same");
			}
			else
			{
				document.getElementById("pwderrs").innerHTML="";
			}
			
	}
}
function verifydob()
{
	var dob=document.getElementById("dob").value;
	if(dob=="")
	{
		document.getElementById("doberr").innerHTML="This Field Cannot Be Empty";
	}
	else if(dob!="")
	{
			document.getElementById("doberr").innerHTML="";
	}
}