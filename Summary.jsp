<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "com.ts.dao.CustomerDAO" %>
<%@ page import = "com.ts.dto.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
<title>Summary</title>
<style>
body{
height:100%;
margin:0;
background-image:url("images/pic05.jpg");
height:100%;
background-position:center;
background-repeat:no-repeat;
background-size:cover;
}
</style>
</head>
<body>
<div class="jumbotron">
	<div class="img">
  <div class="container text-center">
    <h1><b>AMENITE</b></h1>      
    <h3><b>Your search for Home services ends here.</b></h3>
  </div>
  </div>
</div>


<%Customer customer = (Customer)session.getAttribute("customer");
String date = (String)session.getAttribute("date");
String time = (String)session.getAttribute("time");
String ssname = (String)session.getAttribute("ssname");
%>
<div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
<div align="right">
<form action="ControllerServlet" method="POST">
<input type="hidden" name="action" value="logout">
<button type = "Submit" name ="b" class="btn btn-success btn-lg">Logout</button>
</form> 
</div>
<center>
	<h1><b>Booking Confirmed ! </b></h1>
	<h2><b>Your Details :</b></h2>
	<h3>Your Name : ${customer.customerName}</h3>
	<h3>Your Address :<br> ${customer.address}</h3>
	<h2><b>Service Details :</b></h2>
	<h3><b> ${ssname} </b></h3>
	<h3>Service Provider : ${proDetails.proName}</h3>
	<h3>Mobile number : ${proDetails.proPhone}</h3>		
	<h3>Date : ${date}</h3>
	<h3>Time : ${time}</h3>
</center>
		</body>
</html>