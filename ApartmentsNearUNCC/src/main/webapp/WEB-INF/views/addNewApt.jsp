<!--
Author: SSDI_08
Author URL: SSDI_08
-->

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>Apartments Near UNCC (Location)</title>
	<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapMinCSS" />
	<spring:url value="/resources/css/datepicker.css" var="datepickerCSS" />
	<spring:url value="/resources/css/style1.css" var="style1CSS" />
	<spring:url value="/resources/css/Rating.css" var="RatingCSS" />
	<spring:url value="/resources/javascripts/validate.js" var="validateJS" />
	<spring:url value="/resources/javascripts/bootstrap-datepicker.js" var="datepickerJS" />
	<spring:url value="/resources/javascripts/bootstrap.min.js" var="bootstrapJS" />
	<spring:url value="/resources/images/" var="images"/>
	<spring:url value="/resources/javascripts/" var="js"/>
	<link href="${bootstrapCSS}" rel='stylesheet' />
	<link href="${style1CSS}" rel='stylesheet' />
	<link href="${RatingCSS}" rel='stylesheet' />
	<link href="${datepickerCSS}" rel='stylesheet' />
	<link href="${bootstrapMinCSS }" rel='stylesheet'/>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script src="${js}jquery-1.9.1.min.js"></script>
	<script src="${js}bootstrap-datepicker.js"></script>
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
			 <nav class="navbar navbar-default menu" role="navigation"><h3 class="nav_right"><a href=""><img src="${ images}logo.png" class="img-responsive" alt=""/></a></h3>
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
			      </form>-->
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
            <div class="clear"></div>
		 </div>  
		</div>
		</div>

		<section>
			<div>

						<div>
							<div class="container col-sm-4" style="width: 100%">
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">

										
										<div class="panel-heading">
											<h4 class="panel-title">APARTMENT
												Details</h4>
										</div>
										<!-- <div id="${id}" class="panel-collapse collapse">  -->
										<form:form action="addNewApartment" modelAttribute="newApartment">
										<div class="panel-body">
											<div class="table-responsive">
												<table title="New Apartment" class="table" style="width: 90%">
													<tr class="info">
														<td><label for="deposit">DEPOSIT AMOUNT: </label></td>
														<td><form:input class="form-control" placeholder="deposit of room in $" path="depositAmt" type="text" id="deposit" name="deposit"/></td>
														<td><label for="rent">RENT:</label></td>
														<td><form:input class="form-control" placeholder="rent of room in $" type="text" id="rent" name="rent" path="rent"/></td>
													</tr>
													<tr class="info">
														<td><label for="rooms">NUMBER OF ROOMS</label></td>
														<td><form:input class="form-control" placeholder="number of rooms$" type="number" min="1" max="5" id="rooms" name="rooms" path="no_of_rooms"/></td>
		
														<td><label for="utilities">UTILITIES</label></td>
														<td><form:input class="form-control" placeholder="i.e. Internet" type="text" id="utilites" name="utilities" path="utilities"/></td>
													</tr>
													<tr class="info">
														<td><label for="area">AREA</label></td>
														<td><form:input class="form-control" placeholder="UT DRIVE" type="text" id="area" name="area" path="area"/></td>
														<td><label for="street">STREET</label></td>
														<td><form:input class="form-control" placeholder="Graduate Lane" type="text" id="street" name="street" path="street"/></td>
													</tr>
													<tr class="info">
														<td><label for="doorNo">DOOR NUMBER</label></td>
														<td><form:input class="form-control" placeholder="10008 G" type="text" id="doorNo" name="doorNo" path="doorNo"/></td>
														<td><label for="city">CITY</label></td>
														<td><form:input class="form-control" placeholder="Charlotte" type="text" id="city" name="city" path="city"/></td>
													</tr>
													<tr class="info">
														<td><label for="flooring">FLOORING</label></td>
														<td><form:select id="flooring" name="flooring" class="form-control" path="flooring">
																<option value="Select type of flooring" disabled="disabled">Select type of flooring</option>
																<option value="Wooden">Wooden</option>
																<option value="Carpet">Carpet</option>
															</form:select></td>
														<td><label for="bathrooms">BATHROOM TYPE</label></td>
														<td><form:select class="form-control" id="bathrooms" name="bathrooms" path="type_bathroom">
																<option value="Select type of bathroom" disabled="disabled">Select type of bathroom</option>
																<option value="Attached">Attached</option>
																<option value="Common">Common</option>
															</form:select>
														</td>
													</tr>
													<tr class="info">
														
														<td><label for="date">AVAILABLE FROM:</label></td>
														<td><div id="datepicker" class="input-group date" data-date-format="mm/dd/yyyy">
															    <form:input class="form-control" type="text" id="date" path="date"/>
															    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
															</div></td>
														<td></td>
														<td></td>
													</tr>
													<tr class="info">
														<td></td>
														<td></td>
														<td></td>
														<td><button class="btn btn-primary" type="reset">Reset</button>
																<button class="btn btn-success" type="submit">Add Details</button>
															</td>
													</tr>
												</table>
												
											</div>
										</div>
										</form:form>
										<c:if test="${successInAddApt != null}">
													<div class="alert alert-success">
													    <strong>Success!</strong> ${successInAddApt }
													  </div>
												</c:if> 
										<c:if test="${errorInAddApt != null}">
													<div class="alert alert-danger">
													    <strong>Error!</strong> ${errorInAddApt }
													  </div>
												</c:if> 
									</div>

								</div>
							</div>
						</div>
					</div>
					
			<c:if test="${aptId != null}">		
			<div class="container col-sm-4" style="width: 100%">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">

						
						<div class="panel-heading">
							<h4 class="panel-title">Upload Images</h4>
						</div>
						
		
			<form method="post" enctype="multipart/form-data" action="saveImages">
			<div class="panel-body">
											<div class="table-responsive">
												<table title="New Apartment" class="table" style="width: 90%">
													<tr class="info">
										
				<td><label for="file">Upload Image for Hall: </label><input type="hidden" name="name" value="hall.jpg"/></td><td><input type="file" name="file" class="form-control"/> </td>
				<td><label for="file">Upload Image for Bedroom: </label><input type="hidden" name="name" value="bedroom.jpg"/></td><td><input type="file" name="file" class="form-control"/> </td></tr>
				<tr class="info"><td><label for="file">Upload Image for Kitchen: </label><input type="hidden" name="name" value="kitchen.jpg"/></td><td><input type="file" name="file" class="form-control"/> </td>
				<td><label for="file">Upload Image for bathroom: </label><input type="hidden" name="name" value="bathroom.jpg"/></td><td><input type="file" name="file" class="form-control"/> </td></tr>
				<tr class="info"><td></td><td></td><td></td><td><input class="btn btn-success" type="submit" value="Upload"/></td></tr>
				 </table>
				 </div>
				 </div>
			</form>
			</div>
			</div>
			</div>
			</c:if>
			
					
	</section>
	
	<script type="text/javascript">
	$(function () {
		  $("#datepicker").datepicker({ 
		        autoclose: true, 
		        todayHighlight: true
		  }).datepicker('update', new Date());;
		});
	</script>
	
	
	
	
	
		



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
		<!-- script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script-->
		<script type="text/javascript">
			// Get the modal
			var modal = document.getElementById('myModal');
			
			// Get the button that opens the modal
			var lnkOwner = document.getElementById("mailOwner");
			var lnkTenant = document.getElementById("mailTenant");
			
			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];
			
			
			
			// When the user clicks the button, open the modal 
			lnkOwner.onclick = function() {
			    modal.style.display = "block";
			};
			if(lnkTenant!=null){
				lnkTenant.onclick = function() {
				    modal.style.display = "block";
				}
			};
			
			
			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			    modal.style.display = "none";
			}
			
			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			    if (event.target == modal) {
			        modal.style.display = "none";
			    }
			}
			
			$(".modal-content").animate({top: "300px"});
			$(".modal-content").animate({opacity:"30"});
			$(".modal-content").css({position: "relative",margin: "auto",padding: "0",border: "1px solid #888",width: "80%"});
			
			$(".modal").css({position: "fixed",display: "none"});
			$(".modal").css({
				backgroundColor: "rgb(0,0,0)",
				backgroundColor: "rgba(0,0,0,0.4)"});
			$(function(){
				$(".info_link").click(function(){
					
					$("#to").val($(this).text());
				});
			});

</script>
        <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
   </div>

</body>

</html>