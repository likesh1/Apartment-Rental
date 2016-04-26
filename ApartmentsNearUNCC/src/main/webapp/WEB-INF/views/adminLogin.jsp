<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Material Design Login Form</title>    
        
        <spring:url value="/resources/css/admin.css" var="adminStyle" />
        <spring:url value="/resources/javascripts/index.js" var="js"/>
        <spring:url value="/resources/javascripts/validate.js" var="validateJS" />
        <link rel="stylesheet" href="${adminStyle}">
         <script src="${ validateJS }"></script>
         
	   
    
  </head>

  <body>

    <!--Google Font - Work Sans-->
<link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,700' rel='stylesheet' type='text/css'>
<link rel="import" href="https://www.polymer-project.org/0.5/components/paper-ripple/paper-ripple.html">

<div class="container">
  <div class="profile">
    <button class="profile__avatar" id="toggleProfile">
     <img src="http://gravatar.com/avatar/69f34259a9d0b7df04f0b50893c469ed?s=80" alt="Avatar" /> 
    </button>
    <div class="profile__form">
      <div class="profile__fields">
        <form:form name="LoginForm" method="post" onsubmit="return validate(this);" action="admin.do" modelAttribute="loginBean">
				 <div class="field">
				<form:label for="username" path="username">Username</form:label>
				<br/>
				<form:input type="text" id="username" name="username" path="username"/>				
				</div>
				<div class="field">
				<form:label for="password" path="password">Password</form:label>
				<br>
				<form:input type="password" id="password" name="password" path="password"/>
				</div>
				<label id="ErrorMessage">${loginErrorMessage }</label>
				 <div class="profile__footer">
           <div class="button raised blue">
            <div class="center" fit>
				<button type="submit" id="submit" >Sign In</button>
				</div>
				</div>
				</div>
				</form:form>
       <!-- <div class="profile__footer">
           <div class="button raised blue">
            <div class="center" fit>LOGIN</div>
            <paper-ripple fit></paper-ripple>-->
           
          </div>
        </div>
      </div>
     </div>
  </div>
</div>
    
       
<script src="${js}"></script>
        
    
    
    
  </body>
</html>
