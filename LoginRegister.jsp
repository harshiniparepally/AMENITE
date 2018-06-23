<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AMENITE</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        	<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        	<link rel="stylesheet" href="assets/css/style.css">
		<link rel="shortcut icon" href="assets/ico/favicon.png">
        	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        	<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
<%int ssId = Integer.parseInt(request.getParameter("s"));
System.out.println(ssId);
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		System.out.println(date);
		System.out.println(time);
		%>
	<!-- Login-->
<div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="col-sm-5">
                        	<section id="Login">
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Login as User</h3>
	                            		<p>Enter username and password to log on:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-key"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="ControllerServlet?s=<%=ssId %>&date=<%=date %>&time=<%=time %>" method="post" class="login-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username">Username</label>
				                        	<input type="text" name="uname" placeholder="Username..." class="form-username form-control" id="form-username" required>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password">Password</label>
				                        	<input type="password" name="upwd" placeholder="Password..." class="form-password form-control" id="form-password" required="">
				                        </div>
				                        <input type = "hidden" name="action" value="uLogin">
				                        <button type="submit" class="btn">Login!</button>
				                    </form>
			                    </div>
		                    </div>
		                
		                	<div class="social-login">
	                        	<h3>Login and get started!</h3><br>
	                        	
	                        </div>
	                        
                        </div>
                        
                        <div class="col-sm-1 middle-border"></div>
                        <div class="col-sm-1"></div>
                        	
                        <div class="col-sm-5">
                        	
                        	<div class="form-box">
                        		<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Sign up as User</h3>
	                            		<p>Fill in the form below to get instant access:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-pencil"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="ControllerServlet?s=<%=ssId %>&date=<%=date %>&time=<%=time %>" method="post" class="registration-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-name">Name</label>
				                        	<input type="text" name="custName" placeholder="Name..." class="form-name form-control" id="form-name" required>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-phone">Phone</label>
				                        	<input type="text" name="cPhone" placeholder="Phone No..." class="form-phone form-control" id="form-phone" required>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">Email</label>
				                        	<input type="email" name="cEmail" placeholder="Email..." class="form-email form-control" id="form-email" required>
				                        </div>
							<div class="form-group">
				                        	<label class="sr-only" for="form-uName">User Name</label>
				                        	<input type="text" name="cUserName" placeholder="User Name..." class="form-uName form-control" id="form-uName" required>
				                        </div>
							<div class="form-group">
				                        	<label class="sr-only" for="form-pass">Password</label>
				                        	<input type="password" name="cPassword" placeholder="Passowrd..." class="form-pass form-control" id="form-pass" required="">
				                        </div>
							<div class="form-group">
				                        	<label class="sr-only" for="form-add">Email</label>
				                        	<input type="text" name="cAddress" placeholder="Address..." class="form-add form-control" id="form-add" required>
				                        </div>
				                         <input type = "hidden" name="action" value="uRegister">
				                        <button type="submit" class="btn">Sign me up!</button>
				                    </form>
							<div class="social-login">
	                        	<h3>Get started!</h3><br>
	                        	
	                        </div>
			                    </div>
                        	</div>
                        	
                        </div>
                    </div>
                    </section>
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>
               
</body>
</html>