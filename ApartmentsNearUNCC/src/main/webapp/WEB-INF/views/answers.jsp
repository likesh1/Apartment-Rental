<!--
Author: SSDI_08
Author URL: SSDI_08
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Apartments Near UNCC</title>
	<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
	<spring:url value="/resources/css/style1.css" var="style1CSS" />
	<spring:url value="/resources/javascripts/validate.js" var="validateJS" />
	<spring:url value="/resources/images/" var="images"/>
	<spring:url value="/resources/javascripts/" var="js"/>
	<spring:url value="/resources/javascripts/validate_reply.js" var="validateReplyJS" />
	
	<link href="${bootstrapCSS}" rel='stylesheet' />
	<link href="${style1CSS}" rel='stylesheet' />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script src="${js}jquery-1.9.1.min.js"></script>
	<script src="${js}bootstrap.min.js"></script>
	<script src="${js}hover_pack.js"></script>
	<script src="${validateReplyJS}"></script>
	<script type="text/javascript" src="${js}move-top.js"></script>
			<script type="text/javascript" src="${js}easing.js"></script>
			   <script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
						});
					});
				</script>
</head>

<body>
	<div class="header">	
      <div class="container"> 
      	<div class="header-shadow">
      	  <div class="header-top">
      		<div class="logo">
				<a ><img src="${images }logo.png" alt=""/><br><span class="m_1">For Rent Near UNCC</span></a>
			 </div>
			 <nav class="navbar navbar-default menu" role="navigation"><h3 class="nav_right"><a href="index.html"><img src="${ images}logo.png" class="img-responsive" alt=""/></a></h3>
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			    </div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav menu1">
			      	<li class="active"><a href="#home" class="scroll"> <span> </span><i class="menu-border"></i></a></li>
			        <li><a href="#about" class="scroll">Profile</a></li>
			        <li><a href="#team" class="scroll">Team</a></li>
			        <li><a href="#clients" class="scroll">Clients</a></li>
			        <li><a href="#contact" class="scroll">Contact</a></li>
			        <li><a href="logout.do">LogOut</a></li>
			        <li><a href="discussionforum.do">Forum</a></li>
			       </ul>
			       <h4 align="right" class="scroll">Welcome ${user.fName }!!!</h4>
			    
			  </div><!-- /.container-fluid -->
			</nav>
            <div class="clear"></div>
		 </div>  
		</div>
		
		<br>
		<br>
	    <div style="text-align: center; padding-left: 0%"  >
	    
	     <div class="container col-sm-8" style="width:100%">
	  	<div class="panel-group" id="accordion">
        <div class="panel panel-default">
        <div style="background-color:#1f161f;color:#ffffff;font-family:Californian FB;font-size:200%"><label>${description}</label></div>
        <c:forEach items="${answers}" var="answersList">
        	<c:set var="id" value="${answersList.answerno}"></c:set>
        	<c:set var="href">#${id}</c:set>
        	
        	
          <div class="panel-body" style="padding: 5px 15px 0px 15px">
                	<div class="table-responsive">    
  						<table class="table" style="text-align: left;">
                		<tr style="background-color:#f0e1f0"><td style="text-align: left;color:#731e2e">  ${answersList.reply}</td></tr>
                		<tr><td style="text-align: right;color:#621e73"> Answered By : ${answersList.fname} </td></tr>
               
                	</table>
        	</div>
        	</div>
        	  
        	   </c:forEach>
         	<br>
         	<form:form name="AddAnswer" method="post" onsubmit="return validateReply(this);" action="addanswer.do" modelAttribute="answerbean">
				   	
				   	<form:textarea  id="reply" name="reply" path="reply" rows="5" cols="120" />
				   	<br>
				   	<label id="ErrorMessage">${questionErrorMessage}</label><br/>
				   <button class="btn btn-primary" type="submit" id="Reply" style="background-color:#1f161f">Post your Reply</button>				 
				   </form:form>
				   </div>
				   </div>
				   </div>	
	    </div>
	    </div>
	      </div>
     
	  <div class="team" id="team">
	  	<div class="container">
	  	  <div class="m_3"><span class="left_line1"> </span><h3>Our Team</h3><span class="right_line1"> </span></div>
		    <div class="horizontalSlider">
			 <div class="jcarousel">
				<ul>
			    	<li><figure><img src="${images}Pritam.jpg" class="img-responsive" alt=""/></figure>
			    		<h4 class="m_5">Pritam Borate</a></h4>
			    		<p class="m_6">Developer</p>
			    		
					</li>
					<li><figure><img src="${images}Khyati.jpg" class="img-responsive" alt=""/></figure>
			        	<h4 class="m_5">Khyati Savakia</h4>
			    		<p class="m_6">Designer</p><br></br>
			        </li>
			    	<li><figure><img src="${images}Liku.jpg" class="img-responsive" alt=""/></figure>
			        	<h4 class="m_5">Likesh Pammina</h4>
			    		<p class="m_6">Developer</p>
			    		
			        </li>
					<li><figure><img src="${images}saran.jpg" class="img-responsive" alt=""/></figure>
			        	<h4 class="m_5">Saranya Prakash</h4>
			    		<p class="m_6">Designer</p>
			    		
			        </li>
			    
			    </ul>
         </div>
	</div>
	</div>
	 <div class="clients" id="clients">
	 <div class="container">
	 	<div class="m_3"><span class="left_line1"> </span><h3>Clients</h3><span class="right_line1"> </span></div>
	  	<ul id="flexiselDemo3">
			<li><img src="${images}c1.png" /></li>
			<li><img src="${images}cl2.png" /></li>
			<li><img src="${images}cl3.png" /></li>
			<li><img src="${images}cl4.png" /></li>
			<li><img src="${images}cl9.png" /></li>
			<li><img src="${images}cl6.png" /></li>
			<li><img src="${images}cl7.png" /></li>
			<li><img src="${images}cl11.png" /></li>
			<li><img src="${images}cl8.jpg" /></li>
			<li><img src="${images}cl10.png" /></li>
			<li><img src="${images}cl5.jpg" /></li>
		</ul>
	<script type="text/javascript">
$(window).load(function() {
	

	$("#flexiselDemo3").flexisel({
		visibleItems: 5,
		animationSpeed: 1000,
		autoPlay: true,
		autoPlaySpeed: 3000,    		
		pauseOnHover: true,
		enableResponsiveBreakpoints: true,
    	responsiveBreakpoints: { 
    		portrait: { 
    			changePoint:480,
    			visibleItems: 1
    		}, 
    		landscape: { 
    			changePoint:640,
    			visibleItems: 2
    		},
    		tablet: { 
    			changePoint:768,
    			visibleItems: 3
    		}
    	}
    });
    
});
</script>
<script type="text/javascript" src="${js}jquery.flexisel.js"></script>
</div>
</div>
</div>
<div class="footer_bottom" id="contact">
		  <div class="container">
			<div class="row">
				<div class="col-md-3 footer_grid">
					<div class="address">
					  <h4>Pritam Borate</h4>
				      <p class="m_13">10008C, UT North,Charlotte,North Carolina,USA,</p>
					  <p><span class="phno">Phone</span>&nbsp;&nbsp;&nbsp;+(00) 222 666 444</p
					  ><!-- <p><span class="phno">Fax</span>&nbsp;&nbsp;&nbsp;+(000) 000 00 00 0</p>-->
				 	  <p><span class="phno">Email</span>&nbsp;&nbsp;&nbsp;<span class="email">pborate@uncc.edu</span></p>
				   	</div>
				</div>
				<div class="col-md-3 footer_grid">
					<div class="address">
					  <h4>Khyati Savakia</h4>
				      <p class="m_13">9548B, UT Drive,Charlotte,North Carolina,USA,</p>
					  <p><span class="phno">Phone</span>&nbsp;&nbsp;&nbsp;+(00) 222 333 444</p
					  ><!-- <p><span class="phno">Fax</span>&nbsp;&nbsp;&nbsp;+(000) 000 00 00 0</p>-->
				 	  <p><span class="phno">Email</span>&nbsp;&nbsp;&nbsp;<span class="email">ksavakia@uncc.edu</span></p>
				   	</div>
				</div>
				<div class="col-md-3 footer_grid">
					<div class="address">
					  <h4>Likesh Pammina</h4>
				      <p class="m_13">9523A, UT Drive,Charlotte,North Carolina,USA,</p>
					  <p><span class="phno">Phone</span>&nbsp;&nbsp;&nbsp;+(00) 555 666 444</p
					  ><!--<p><span class="phno">Fax</span>&nbsp;&nbsp;&nbsp;+(000) 000 00 00 0</p>-->
				 	  <p><span class="phno">Email</span>&nbsp;&nbsp;&nbsp;<span class="email">lpammina@uncc.edu</span></p>
				   	</div>
				</div>
				<div class="col-md-3">
					<div class="address">
					  <h4>Saranya Prakash</h4>
				      <p class="m_13">9527C, UT Drive,Charlotte,North Carolina,USA,</p>
					  <p><span class="phno">Phone</span>&nbsp;&nbsp;&nbsp;+(00) 222 777 444</p>
				 	  <p><span class="phno">Email</span>&nbsp;&nbsp;&nbsp;<span class="email">sprakas2@uncc.edu</span></p>
				   	</div>
				</div>
			</div>
			<div class="copy">
			    <p>© 2016 SSDI_08</p>
		    </div>
     </div>
	<script type="text/javascript">
			$(document).ready(function() {
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
			
		</script>
        <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
   </div>
</body>
</html>