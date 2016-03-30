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
	<title>Apartments Near UNCC (Location)</title>
	<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
	<spring:url value="/resources/css/style1.css" var="style1CSS" />
	<spring:url value="/resources/css/Rating.css" var="RatingCSS" />
	<spring:url value="/resources/javascripts/validate.js" var="validateJS" />
	<spring:url value="/resources/images/" var="images"/>
	<spring:url value="/resources/javascripts/" var="js"/>
	<link href="${bootstrapCSS}" rel='stylesheet' />
	<link href="${style1CSS}" rel='stylesheet' />
	<link href="${RatingCSS}" rel='stylesheet' />
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
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
				<a href="welcome"><img src="${images }logo.png" alt=""/><br><span class="m_1">For Rent Near UNCC</span></a>
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
			        <li><a href="#about" class="scroll">Details</a></li>
			   <!-- <li><a href="#services" class='scroll'>Services</a></li>-->
			        <li><a href="#projects" class="scroll">Locations</a></li>
			        <!-- <li><a href="#team" class="scroll">Team</a></li>-->
			  <!--  <li><a href="#news" class="scroll">Reviews</a></li>-->
			        <li><a href="#clients" class="scroll">Clients</a></li>
			        <li><a href="#contact" class="scroll">Contact</a></li>
			        <li><a href="#">My Profile</a></li>
			       </ul>
			        <!-- <div class="social">	
					   <ul>	
						  <li class="fb"><a href="#"><span> </span></a></li>
						  <li class="tw"><a href="#"><span> </span></a></li>
						  <li class="linkedin"><a href="#"><span> </span></a></li>		
						</ul>
				    </div>
			      <form class="navbar-form navbar-left search1" role="search">
			        <div class="search2">
					  <form>
						 <input type="text" value="">
						 <input type="submit" value="">
					  </form>
					</div>
			      </form>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
            <div class="clear"></div>
		 </div>  
		</div>
		</div>

	<div class="index-banner" id="home">
       	   <div class="wmuSlider example1">
			   <div class="wmuSliderWrapper">
				   <article style="position: absolute; width: 100%; opacity: 0;"> 
				   	<div class="banner-wrap">
				   		 <div class="slider-left">
						    <img src="${images}utr1.jpg" alt=""/>
						 </div>
					     <div class="clear"></div>
					 </div>
					</article>
				   <article style="position: relative; width: 100%; opacity: 1;"> 
				   	 <div class="banner-wrap">
				   	 	<div class="slider-left">
						    <img src="${images}utr2.jpg" alt=""/>
						 </div>
					     <div class="clear"></div>
					  </div>
				   </article>
				   <article style="position: absolute; width: 100%; opacity: 0;">
				   	<div class="banner-wrap">
				   		 <div class="slider-left">
						    <img src="${images}utr3.jpg" alt=""/>
						 </div>
					     <div class="clear"></div>
					 </div>
				   </article>
				 </div>
				<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
                <ul class="wmuSliderPagination">
                	<li><a href="#" class="">0</a></li>
                	<li><a href="#" class="">1</a></li>
                	<li><a href="#" class="wmuActive">2</a></li>
                </ul>
            </div>
            <script src="${js}jquery.wmuSlider.js"></script> 
			  <script>
       			$('.example1').wmuSlider();         
   		     </script> 	           	      
      </div>
	</div>
	<section>
	<div>
	<div class="main">	
	  <div class="container">
	   <div class="about" id="about">
			
<div>
		<div class="container col-sm-4" style="width:100%">
	  	<div class="panel-group" id="accordion">
        <div class="panel panel-default">
        
        	<c:set var="id" value="${apartmentDetails.doorNo}"></c:set>
        	<c:set var="href">#${id }</c:set>
            <div class="panel-heading">
                <h4 class="panel-title">
                    APARTMENT ${apartmentDetails.doorNo}
                </h4>
            </div>
           <!-- <div id="${id}" class="panel-collapse collapse">  -->
                <div class="panel-body">
                	<div class="table-responsive">    
  						<table class="table" style="width:90%">
						      <tr>
						        <td>DEPOSIT AMOUNT:</td>
						        <td>${apartmentDetails.depositAmt}</td>
						        <td>RENT:</td>
						        <td>${apartmentDetails.rent}</td>
						      </tr>
						      <tr>
						        <td>AVAILABLE FROM:</td>
						        <td>${apartmentDetails.availablityFrom}</td>
						        <td>UTILITIES</td>
						        <td><c:out value="${apartmentDetails.utilities}" /></td>
						      </tr>
						      <tr>
						        <td>AREA</td>
						        <td><c:out value="${apartmentDetails.area}" /></td>
						        <td>STREET</td>
						        <td><c:out value="${apartmentDetails.street}" /></td>
						      </tr>
						      <tr>
						        <td>DOOR NUMBER</td>
						        <td><c:out value="${apartmentDetails.doorNo}" /></td>
						        <td>CITY</td>
						        <td><c:out value="${apartmentDetails.city}" /></td>
						      </tr>
						      <tr>
						        <td>NUMBER OF ROOMS</td>
						        <td>${apartmentDetails.no_of_rooms}</td>
						        <td>NUMBER OF BATHROOMS</td>
						        <td>${apartmentDetails.no_of_bathroom}</td>
						      </tr>
						      <tr>
						        <td>FLOORING</td>
						        <td><c:out value="${apartmentDetails.flooring}" /></td>
						        <td></td><td></td>
						      </tr>
						      <tr>
						      <td></td><td></td><td></td>
						        <td><div class="about-btn"><a href="#contactDetails">Contact Details</a></div></td>
						        </tr>
						  </table>
						  </div>
						</div>
	            </div>  
	         
            </div>
        </div>
    </div>
  </div>
    </section>
			
		</div> 		
	  	     

		
	   
	    <div class="team" id="contactDetails">
	  	<div class="container">
	  	  <div class="m_3"><span class="left_line1"> </span><h3>Contact</h3><span class="right_line1"> </span></div>
		    <div class="horizontalSlider">
			 <div class="jcarousel">
				<ul>
			    	<li>
			    		<h4 class="m_5"><a href="#">${ownerDetails.oFirstName} ${ownerDetails.oLastName}</a></h4>
			    		<p class="m_6">Owner</p><br></br>
			    		<p >Email: ${ownerDetails.oEmail}</p><br></br>
			    		<p>Call me @ ${ownerDetails.oPhoneNo}</p>
			    	</li>
			    	<c:forEach items="${tenantDetails}" var="tenants">
			    	<li>
			    		<h4 class="m_5"><a href="#">${tenants.tfirstName} ${tenants.tlastName}</a></h4>
			    		<p class="m_6">Tenant</p><br></br>
			    		<p >Email: ${tenants.tEmail }</p><br></br>
			    		<p>Call me @ ${tenants.tPhoneNo }</p>
			    	</li>
			    	
			    	</c:forEach>
			    </ul>
			  </div>
			  <div class="sliderControl">
		<div class="control">
		 <a href="#" class="jcarousel-control-prev"></a>
		 <a href="#" class="jcarousel-control-next"></a>
		</div>
		<div class="jcarousel-pagination"></div>
		</div>
		</div>
			<script src="${js}jquery.touchSwipe.min.js"></script>
		<script src="${js}app.js"></script>
		<script src="${js}jcarousel.js"></script>
			</div>
	
						
         
         
            
	    <div class="projects" id="projects">
	    	<div class="m_3"><span class="left_line1"> </span><h3>Locations</h3><span class="right_line1"> </span></div>
	    </div>
	  </div> 
	  <div class="project_top">
	  	<div class="container">
	  		<div class="row">
	  			<div class="col-md-3 project_grid">
	  			  <a href="#" class="b-link-stripe b-animate-go  thickbox">
					<img src="${images}UT1.jpg" class="img-responsive" alt=""/><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="${images}heart.png" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${images}link.png" alt=""/></h2>
				  </div></a>
				  <div class="project_desc">
				  	<h3>UT Drive</h3>
				  	<!-- <p>Project Status</p>
				  	<i class="dating"> </i>-->
				  	 <div class="project-btn"><a href="apartmentList?Location=UT Drive">Apartment List</a></div>
				  </div>
				</div>
	  			<div class="col-md-3 project_grid">
	  			  <a href="#" class="b-link-stripe b-animate-go  thickbox">
					<img src="${images}UTNorth.jpg" class="img-responsive" alt=""/><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="${images}heart.png" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${images}link.png" alt=""/></h2>
				  </div></a>
				  <div class="project_desc">
				  	<h3>UT North</h3>
				  <!-- 	<p class="blue">Project Status</p>
				  	<i class="wedding"> </i>-->
				  	 <div class="project-btn"><a href="apartmentList?Location=UT North">Apartment List</a></div>
				  </div>
				</div>
	  			<div class="col-md-3 project_grid">
	  			  <a href="#" class="b-link-stripe b-animate-go  thickbox">
					<img src="${images}ashford.jpg" class="img-responsive" alt=""/><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="${images}heart.png" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${images}link.png" alt=""/></h2>
				  </div></a>
				  <div class="project_desc">
				  	<h3>Ashford Greens</h3>
				  <!-- 	<p class="green">Project Status</p>
				  	<i class="travel"> </i>-->
				  	 <div class="project-btn"><a href="apartmentList?Location=Ashford">Apartment List</a></div>
				  </div>
				</div>
	  			<div class="col-md-3">
	  			  <a href="#" class="b-link-stripe b-animate-go  thickbox">
					<img src="${images}CG1.jpg" class="img-responsive" alt=""/><div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img src="${images}heart.png" alt=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="${images}link.png" alt=""/></h2>
				  </div></a>
				  <div class="project_desc">
				  	<h3>Colonial Grand</h3>
				  <!-- 	<p class="dark">Project Status</p>
				  	<i class="ecommerce"> </i>-->                                       
				  	 <div class="project-btn"><a href="apartmentList?Location=Colonial">Apartment List</a></div>
				  </div>
				</div>
	  		</div>
	  	</div>
	  </div>
	  
	  
	<!-- <div class="sliderControl">
		<div class="control">
		 <a href="#" class="jcarousel-control-prev"></a>
		 <a href="#" class="jcarousel-control-next"></a>
		</div>
		<div class="jcarousel-pagination"></div>
		</div>
		</div>
		<script src="${js}jquery.touchSwipe.min.js"></script>
		<script src="${js}app.js"></script>
		<script src="${js}jcarousel.js"></script>-->
        <div class="m_3" id="news"><span class="left_line1"> </span><h3>Feedback</h3><span class="right_line1"> </span></div>
	 </div>
	</div>
	  <div class="project_top">
	  	<div class="container">
	  	  <table><tr><td><div>
	  	  <tr>
	  	  <td>
	  	  Average Rating:
	  	  </td>
	  	  <td>
	  	  Comments:
	  	  </td>
	  	  </tr>
	  	  <tr>
	  	  <td>
	  	  <div class="stars">
  					<form action="">
					    <input class="star star-5" id="star-5" type="radio" name="star"/>
					    <label class="star star-5" for="star-5"></label>
					    <input class="star star-4" id="star-4" type="radio" name="star"/>
					    <label class="star star-4" for="star-4"></label>
					    <input class="star star-3" id="star-3" type="radio" name="star"/>
					    <label class="star star-3" for="star-3"></label>
					    <input class="star star-2" id="star-2" type="radio" name="star"/>
					    <label class="star star-2" for="star-2"></label>
					    <input class="star star-1" id="star-1" type="radio" name="star"/>
					    <label class="star star-1" for="star-1"></label>
					 </form>
				</div>
	  	  </td>
	  	  <td>
	  	  <p> Its a clean Home...!!!</br>Its a good ventilated Home!!Best place to live!!</br>Home away from home!!</br>Like a palace at low cost</p>
	  	  </td>
	  	  </tr></div></td></tr><tr><td>&nbsp</td></tr></tr><td>&nbsp</br></td></tr>
	  	  <tr><td><div>
	  	  <tr>
	  	  <td>Add your Rating</td>
	  	  <td>Add your Comments</td>
	  	  </tr>
	  	  <tr>
	  	  <td>
	  	  		<div class="stars">
  					<form action="">
					    <input class="star star-5" id="star-5" type="radio" name="star"/>
					    <label class="star star-5" for="star-5"></label>
					    <input class="star star-4" id="star-4" type="radio" name="star"/>
					    <label class="star star-4" for="star-4"></label>
					    <input class="star star-3" id="star-3" type="radio" name="star"/>
					    <label class="star star-3" for="star-3"></label>
					    <input class="star star-2" id="star-2" type="radio" name="star"/>
					    <label class="star star-2" for="star-2"></label>
					    <input class="star star-1" id="star-1" type="radio" name="star"/>
					    <label class="star star-1" for="star-1"></label>
					 </form>
				</div>
	  	  </td>
	  	  <td style="width:100%">
	  	  <form action="/html/tags/html_form_tag_action.cfm" method="post">
<div>
<textarea name="comments" id="comments" style="font-family:sans-serif;font-size:1.2em; width:100%">

</textarea>
</div>
<input type="submit" value="Submit">
</form>
	  	  </td>
	  	  </tr></div></td></tr>
	  	  </table>
	  		 	
					</div>
</div>

	  			  <!-- <div><ul class="news_list">
	  			     <li class="date">
						May<br><span class="highlight">20</span><br><span class="light_color">2014</span>
					 </li>
					 <li class="date_desc">
	  			   	 	<ul class="list_img">
	  			   	 		<li class="list_img_left">
	  			   	 			<img src="${images}n1.jpg" class="img-responsive" alt=""/>
	  			   	 		</li>
	  			   	 		<li class="list_desc">
	  			   	 		 <div class="extra">
							   <time pubdate="" datetime="2014-03-30T14:47:59">
								 Writter				</time> 
								<span class="username">aliquam</span> / 
								<a href="#" class="comment_count">Finance</a>
							 </div>
							 <div class="extra_bottom"><i class="audio"> </i>
							 	<i class="video"> </i>
							 </div>
	  			   	 		</li>
	  			   	 		<li class="hours">8 Hours Ago</li>
	  			   	 		<div class="clear"> </div>
	  			   	 	</ul>
	  			   	 </li>
	  			   	 <div class="clear"> </div>
	  			  </ul>
	  			  <ul class="news_bottom"> 	
	  			    <li class="comment_section">
					  <i class="comment1"> </i>
					  <i class="comment2"> </i>
					  <i class="comment3"> </i>
					</li>
					<li class="right_desc">
	  			   	  <h4 class="m_7">New Project is very coming soon...</h4>
	  			   	  <p class="m_8">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
	  			   	  <div class="news-btn"><a href="#">Read More</a></div>
	  			   	</li>
	  			   	<div class="clear"> </div>
	  			  </ul>
	  			</div>
	  		   </div>
	  		   <div class="col-md-6">
	  			<div class="news_left">
	  			  <ul class="news_list">
	  			     <li class="date">
						May<br><span class="highlight">23</span><br><span class="light_color">2014</span>
					 </li>
					 <li class="date_desc">
	  			   	 	<ul class="list_img">
	  			   	 		<li class="list_img_left">
	  			   	 			<img src="${images}n2.jpg"  class="img-responsive" alt=""/>
	  			   	 		</li>
	  			   	 		<li class="list_desc">
	  			   	 		 <div class="extra">
							   <time pubdate="" datetime="2014-03-30T14:47:59">
								 Writter				</time> 
								<span class="username">aliquam</span> / 
								<a href="#" class="comment_count">Finance</a>
							 </div>
							 <div class="extra_bottom"><i class="audio"> </i>
							 
							 </div>
	  			   	 		</li>
	  			   	 		<li class="hours">6 Days Ago</li>
	  			   	 		<div class="clear"> </div>
	  			   	 	</ul>
	  			   	 </li>
	  			   	 <div class="clear"> </div>
	  			  </ul>
	  			  <ul class="news_bottom"> 	
	  			    <li class="comment_section">
					  <i class="comment1"> </i>
					  <i class="comment2"> </i>
					  <i class="comment3"> </i>
					</li>
					<li class="right_desc">
	  			   	  <h4 class="m_7">New Project is very coming soon...</h4>
	  			   	  <p class="m_8">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
	  			   	  <div class="news-btn"><a href="#">Read More</a></div>
	  			   	</li>
	  			   	<div class="clear"> </div>
	  			  </ul>
	  			</div>
	  		</div>
	  	</div>
	  </div>
	 </div>-->
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
	<div class="footer">
		<div class="container">
			 <!-- <div class="footer-logo">
				<a href="index.html"><img src="${images}logo.png" alt=""/><br><span class="m_1">Software Development</span></a>
			 </div>
			<div class="social_footer">
			  <ul>
				<li><a href=""> <i class="f-fb"> </i> </a></li>
				<li><a href=""><i class="f-tw"> </i> </a></li>
				<li><a href=""><i class="f-in"> </i> </a></li>
				<li><a href=""><i class="f-skype"> </i> </a></li>
				<li><a href=""><i class="f-google"> </i> </a></li>
				<li><a href=""><i class="f-be"> </i> </a></li>
				<div class="clear"> </div>
			 </ul>
			</div>
			<ul class="newsletter">
				<h3>Newsletter</h3>
				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod.</p>
			  <li class="footer-search">
				<input type="text" value="">
				<input type="submit" value="">
		      </li>
			</ul>
			<div class="clear"> </div>
			<div class="m_12"><span class="left_line2"> </span><h4>Froyo Software Development Inc.</h4><span class="right_line2"> </span></div>
		  </div>
		</div>-->
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
					  <p><span class="phno">Phone</span>&nbsp;&nbsp;&nbsp;+(00) 222 777 444</p
					  ><!--<p><span class="phno">Fax</span>&nbsp;&nbsp;&nbsp;+(000) 000 00 00 0</p>-->
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