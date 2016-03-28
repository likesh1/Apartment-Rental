<!--
Author: SSDI_08
Author URL: SSDI_08
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>Apartments Near UNCC</title>
	<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
	<spring:url value="/resources/css/style1.css" var="style1CSS" />
	<spring:url value="/resources/javascripts/validate.js" var="validateJS" />
	<spring:url value="/resources/images/" var="images"/>
	<spring:url value="/resources/javascripts/" var="js"/>
	<link href="${bootstrapCSS}" rel='stylesheet' />
	<link href="${style1CSS}" rel='stylesheet' />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script src="${js}jquery-1.9.1.min.js"></script>
	<!----requred-js-files---->
	<!-- script src="${js}jquery.min.js"></script-->
	<script src="${js}bootstrap.min.js"></script>
	<!----//requred-js-files---->
	<script src="${js}hover_pack.js"></script>
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
				<a href="/uncc/welcome"><img src="${images }logo.png" alt=""/><br><span class="m_1">Apartments Near UNCC</span></a>
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
			        <li><a href="#team" class="scroll">About Us</a></li>
			        <li><a href="#services" class='scroll'>Location</a></li>
			        <li><a href="#projects" class="scroll">Registration</a></li>
			        <li><a href="#team" class="scroll">Log In</a></li>
			        <li><a href="#news" class="scroll">Contact Us</a></li>
			        </ul>	     
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
            <div class="clear"></div>
		 </div>  
		</div>
		</div>
	     <div class="index-banner" id="home">
       	   <div class="wmuSlider example1">
			   
            </div>
            <script src="${js}jquery.wmuSlider.js"></script> 
			  <script>
       			$('.example1').wmuSlider();         
   		     </script> 	           	      
      </div>
	</div>
    <div class="main">	
	  <div class="container">
		<div class="services" id="services">
			<div class="m_3"><span class="left_line1"> </span><h3>Locations</h3><span class="right_line1"> </span></div>
			<div class="row service_grids">
			  <div class="col-md-3 text-center service_grid1">
				 <i class="web"> </i>
				 <h3 class="m_4">UT Drive</h3>
				 <p class="m_5">Nearest to University....</p>
				 <div class="service-btn"><a href="apartmentList">ApartmentList</a></div>
			  </div>
			  <div class="col-md-3 text-center service_grid1">
				 <i class="app"> </i>
				 <h3 class="m_4">UT North</h3>
				 <p class="m_5">Walkable distance to University....</p>
				 <div class="service-btn"><a href="apartmentList">Read More</a></div>
			  </div>
			  <div class="col-md-3 text-center service_grid1">
				 <i class="php"> </i>
				 <h3 class="m_4">Ashford</h3>
				 <p class="m_5">Newly built colony....</p>
				 <div class="service-btn"><a href="#">Read More</a></div>
			  </div>
			  <div class="col-md-3 text-center">
				 <i class="wordpress"> </i>
				 <h3 class="m_4">Colonial Grand</h3>
				 <p class="m_5">Next to Ashford...</p>
				 <div class="service-btn"><a href="#">Read More</a></div>
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
			    	<li><figure><img src="${images}t1.jpg" class="img-responsive" alt=""/></figure>
			    		<h4 class="m_5"><a href="#">Pritam Borate</a></h4>
			    		<p class="m_6">Ceo Founder</p>
			    		<div class="project-btn"><a href="#">Look at me</a></div>
			    		<div class="social_networks">
						  <i class="facebook"> </i>
						  <i class="twitter"> </i>
						  <i class="linked_in"> </i>
						  <i class="skype"> </i>
						  <i class="google"> </i>
						  <i class="be"> </i>
						  <div class="clear"> </div>
						</div>
					</li>
					<li><figure><img src="${images}t2.jpg" class="img-responsive" alt=""/></figure>
			        	<h4 class="m_5"><a href="#">Likesh</a></h4>
			    		<p class="m_6">Ceo Founder</p>
			    		<div class="project-btn"><a href="#">Look at me</a></div>
			    		<div class="social_networks">
						  <i class="facebook"> </i>
						  <i class="twitter"> </i>
						  <i class="linked_in"> </i>
						  <i class="skype"> </i>
						  <i class="google"> </i>
						  <i class="be"> </i>
						  <div class="clear"> </div>
						</div>
			        </li>
			    	<li><figure><img src="${images}t3.jpg" class="img-responsive" alt=""/></figure>
			        	<h4 class="m_5"><a href="#">Saranya</a></h4>
			    		<p class="m_6">Ceo Founder</p>
			    		<div class="project-btn"><a href="#">Look at me</a></div>
			    		<div class="social_networks">
						  <i class="facebook"> </i>
						  <i class="twitter"> </i>
						  <i class="linked_in"> </i>
						  <i class="skype"> </i>
						  <i class="google"> </i>
						  <i class="be"> </i>
						  <div class="clear"> </div>
						</div>
			        </li>
					<li><figure><img src="${images}t4.jpg" class="img-responsive" alt=""/></figure>
			        	<h4 class="m_5"><a href="#">Khyati</a></h4>
			    		<p class="m_6">Ceo Founder</p>
			    		<div class="project-btn"><a href="#">Look at me</a></div>
			    		<div class="social_networks">
						  <i class="facebook"> </i>
						  <i class="twitter"> </i>
						  <i class="linked_in"> </i>
						  <i class="skype"> </i>
						  <i class="google"> </i>
						  <i class="be"> </i>
						  <div class="clear"> </div>
						</div>
			        </li>		    	
			    </ul>
         </div>		
	</div>	 	
	<div class="footer">
		<div class="container">
			 <div class="footer-logo">
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