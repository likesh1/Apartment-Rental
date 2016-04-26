
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Material Design Login Form</title>    
        
        <spring:url value="/resources/css/admin.css" var="adminStyle" />
        <spring:url value="/resources/javascripts/index.js" var="js"/>
        <link rel="stylesheet" href="${adminStyle}">
         
         <script src="${js}"></script>
        
	   
    
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
        <div class="field">
          <input type="text" id="fieldUser" class="input" required pattern=.*\S.* />
          <label for="fieldUser" class="label">Username</label>
        </div>
        <div class="field">
          <input type="password" id="fieldPassword" class="input" required pattern=.*\S.* />
          <label for="fieldPassword" class="label">Password</label>
        </div>
        <div class="profile__footer">
           <div class="button raised blue">
            <div class="center" fit>LOGIN</div>
            <paper-ripple fit></paper-ripple>
          </div>
        </div>
      </div>
     </div>
  </div>
</div>
    
       

    
    
    
  </body>
</html>
