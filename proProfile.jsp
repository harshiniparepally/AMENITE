<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.ts.dao.ProfessionalDAO" %>
<%@ page import = "com.ts.dto.Professional" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
<title>Professional</title>
<style>

</style>
</head>
<body>
<%int sid = (int)(session.getAttribute("sid"));
%>
<div class="jumbotron">
	<div class="img">
  <div class="container text-center">
    <h1><b>AMENITE</b></h1>      
    <h3><b>Your search for Opportunities ends here.</b></h3>
  </div>
  </div>
</div>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/amenite"  
     user="root"  password="harrypotter"/>  
     
<sql:query dataSource="${db}" var="rs">  
SELECT sName from services where sId = <%=sid %>;  
</sql:query> 
<div class="top-content">
<div class="inner-bg">
<div class="container">
                	
<div align="right">
<form action="ControllerServlet" method="POST">
<input type="hidden" name="action" value="logout">
<button type = "Submit" name ="b" class="btn btn-success btn-lg">Logout</button>
</form> 
</div>
<div align="center">
<img src="images/pro1.jpg">
<h2><b>Your Details :</b></h2>
<h3>Name : ${pro.proName}</h3>

<h3>Service :<c:forEach var="services" items="${rs.rows}"> <c:out value="${services.sName}" />
</c:forEach></h3>

<h3>Phone : ${pro.proPhone}</h3>

<h3>Email : ${pro.proEmail}</h3>
</div>
</body>
</html>