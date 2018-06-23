<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    wrapper2 {
  max-width: 800px;
  float: none;
  margin: 0 auto;
  height: 150px;
}
    
    
  </style>
</head>
<body>
 <%int id = Integer.parseInt(request.getParameter("s"));
 %>
<div class="jumbotron">
	<div class="img">
  <div class="container text-center">
    <h1>AMENITE</h1>      
    <p>Your search for Home services ends here.</p>
  </div>
  </div>
</div>



<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://localhost/amenite"  
     user="root"  password="harrypotter"/>  
 
<sql:query dataSource="${db}" var="rs">  
SELECT photo, ssId, ssName,description, price from subservices where sId = <%=id %>;  
</sql:query>  
<div style="background: color url('/home/harshini/Desktop/Project/Amenite/WebContent/images/pic09.jpg')">

<form name="form" action = "DateandTime.jsp"method="POST">
<br>
<c:forEach var="subservices" items="${rs.rows}">    
<div class="container" style="float:left; height:500px; width:420px;">    
  <div class="row">
    <div class="col-md-12">
      <div class="panel panel-danger">
        
        <div class="panel-body"><img src="./images/${subservices.photo}" class="img-responsive" style="width:100%;" alt="Image"></div>
        <div class="panel-footer" style="font-size:20px"><pre style="font-size:22px"><c:out value="${subservices.ssName}" /></pre><p><c:out value="${subservices.description}" /></p> <br> Price:  <c:out value="${subservices.price}"/></div>     
		<a href="DateAndTime.jsp?s=${subservices.ssId}">
         <button type="button" class="btn btn-info btn-block" onclick="javascript:window.location=DateAndTime.jsp">Add</button></a><br>
      </div>
    </div>
   
  </div>
</div>
</c:forEach>

<!--  
<a href="SubServicesServlet?s=${subservices.ssId}&ssName=${subservices.ssName}&price=${subservices.price}"></a><br>
-->  
</form>
</div>
</body>
</html>