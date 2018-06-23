<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name = "viewport" content = "width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<title>Date and Time</title>
<style>
body{
height:100%;
margin:0;
background-image:url("images/bg2.jpg");
height:100%;
background-position:center;
background-repeat:no-repeat;
background-size:cover;
}
.form{
margin: 0 auto;
width: 250px;
}
</style>
</head>
<body>

<%
int ssId = Integer.parseInt(request.getParameter("s"));
//System.out.println(ssId);
%>
    
    <form method = "POST" action="LoginRegister.jsp?s=<%=ssId %>" >
    <div align="center">
    <div class="container"><br><br><br><br>
     	<input type=hidden name = "s" value=<%=ssId %>>	
  		<h2><b>Best Day to meet?</b></h2><br>

		<input type=Date name="date">
		<br>	
  		<h2><b>What about the time?</b></h2><br>
  		<h3><input type="radio" name="time" value="Early Morning (6am - 8am)" style ="color:blue"> Early Morning (6am - 8am)</h3><br>
  		<h3><input type="radio" name="time" value="Morning (8am - 12pm)"> Morning (8am - 12pm)</h3><br>
  		<h3><input type="radio" name="time" value="Afternoon (1pm - 5am)"> Afternoon (1pm - 5am)</h3><br>
  		<h3><input type="radio" name="time" value="Evening (5pm - 9pm)"> Evening (5pm - 9pm)</h3><br>
  				<button type="submit" class="btn btn-info btn-lg" >Book Now!</button></a><br><br>
  	
   </div>
  </div>
  </form>
        
      </div>
    </div>
  </div>

</body>
</html>