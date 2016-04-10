<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<spring:url value="/resources/css/animate.css" var="animateCSS" />
	<spring:url value="/resources/css/style.css" var="styleCSS" />
	<spring:url value="/resources/javascripts/validate.js" var="validateJS" />
	<spring:url value="/resources/javascripts/validate_registration.js" var="validateRegistrationJS" />
	<meta charset="utf-8">
	<title>ApartmentNearUNCC - Sign In</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="${animateCSS}">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="${styleCSS }">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="${ validateJS }"></script>
	<script src="${validateRegistrationJS}"></script>
</head>

<body>
	<div class="container">
		<div class="top">
			<h1 id="title" class="hidden"><span id="logo">Apartments Near<span> UNCC</span></span></h1>
		</div>
		<div id="Login" class="login-box animated fadeInUp">
			<form:form name="LoginForm" method="post" onsubmit="return validate(this);" action="login.do" modelAttribute="loginBean">
				<div class="box-header">
					<h2>Sign In</h2>
				</div>
				<select>
				  <option value="student">Student</option>
				  <option value="owner">Owner</option>
				</select><br/>
				<form:label for="username" path="username">Username</form:label>
				<br/>
				<form:input type="text" id="username" name="username" path="username"/>
				<br/>
				<form:label for="password" path="password">Password</form:label>
				<br/>
				<form:input type="password" id="password" name="password" path="password"/>
				<br/>
				<label id="ErrorMessage">${loginErrorMessage }</label><br/>
				<button type="submit" id="submit">Sign In</button>
				<input type="button" value="Sign Up" id="signup" onclick=""/>
				
				<a href="passwordRecovery.do"><p class="small">Forgot your password?</p></a>
				<a href="welcomeGuest"><p class="small">I'll do it later</p></a>
			</form:form>
		</div>
		<div id="Registration" class="registration-box animated fadeInUp">
			<form:form name="RegistrationForm" method="post" onsubmit="return validateRegistration(this);" action="register.do" modelAttribute="registrationBean">
				<div class="box-header">
					<h2>Sign Up</h2>
				</div>
				<table align="center"><tr><td>
				<form:label for="FName" path="fname">firstName</form:label></td><td>
				<form:input type="text" id="fname" name="fname" path="fname"/></td><td>
				
				<form:label for="LName" path="lname">lastname</form:label></td><td>
				<form:input type="text" id="lname" name="lname" path="lname"/></td>
				</tr><tr><td>
				<form:label for="Email" path="email">email id</form:label></td><td>
				<form:input type="text" id="email" name="email" path="email"/></td><td>

				<form:label for="type" path="userRole">Registrer As</form:label></td><td>
				<form:select  path="userRole">
				  <form:option value="student" path="userRole">Student</form:option>
				  <form:option value="owner" path="userRole">Owner</form:option>
				</form:select></td>
				</tr><tr><td>
				<form:label for="Password" path="password">Password</form:label></td><td>
				<form:input type="password" id="password" name="password" path="password"/></td><td>
				<label for="Password" >Repeat Password</label></td><td>
				<input type="password" id="repeat_password" name="repeat_password" /></td>
				</tr>
				</table>
				
				<label id="registrationErrorMessage">${registrationErrorMessage }</label><br/>
				<button type="submit" id="submit">Sign Up</button>
				<input type="button" value="Sign In" id="signin" onclick=""/>
				<a href="passwordRecovery.do"><p class="small">Forgot your password?</p></a>
				<a href="welcomeGuest"><p class="small">I'll do it later</p></a>
				
			</form:form>
		</div>
	</div>
</body>

<script>
	$(document).ready(function () {
		var isSignupError=${isSignupError};
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
    	
    	if(isSignupError){
    		$('#Login').hide();
    	}
    	else{
    		$('#Registration').hide();
    	}
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
	$('#signup').click(function(){
		$('#Login').hide();
		$('#Registration').show();
	});
	$('#signin').click(function(){
		$('#Registration').hide();
		$('#Login').show();
	});
</script>

</html>