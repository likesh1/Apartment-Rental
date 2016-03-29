<!-- Author: SSDI_08 Author URL: SSDI_08 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false"%>

<!DOCTYPE HTML>

<html>

<head>

<title>Apartments Near UNCC (Location)</title>

<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS" />

<spring:url value="/resources/css/style1.css" var="style1CSS" />

<spring:url value="/resources/javascripts/validate.js" var="validateJS" />

<spring:url value="/resources/images/" var="images" />

<spring:url value="/resources/javascripts/" var="js" />

<link href="${bootstrapCSS}" rel='stylesheet' />

<link href="${style1CSS}" rel='stylesheet' />

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<script type="application/x-javascript">
	

addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>

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

		$(".scroll").click(function(event) {

			event.preventDefault();

			$('html,body').animate({

				scrollTop : $(this.hash).offset().top

			}, 1200);

		});

	});
</script>

<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<li><a href="welcome">About Us</a></li>

<li><a href="#service" class='scroll'>Location</a></li>

<li><a href="#projects" class="scroll">Registration</a></li>

<li><a href="#team" class="scroll">Log In</a></li>

<li><a href="#news" class="scroll">Contact Us</a></li>

</ul>

</div>

<!-- /.navbar-collapse -->

</div>

<!-- /.container-fluid -->

</nav>

<div class="clear"></div>

</div>

</div>

<div>

	<table>

		<tr>

			<td>

				<p>Room Rent</p>

				<div class="checkbox">

					<label><input type="checkbox" value="">$200 - $300</label>

				</div>

				<div class="checkbox">

					<label><input type="checkbox" value="">$300 - $400</label>

				</div>

				<div class="checkbox">

					<label><input type="checkbox" value="">$400 - $500</label>

				</div>

				<div class="checkbox">

					<label><input type="checkbox" value="">above $500</label>

				</div>

				<div>

					<p>Rooms</p>

					<div class="checkbox">

						<label><input type="checkbox" value="">1</label>

					</div>

					<div class="checkbox">

						<label><input type="checkbox" value="">2</label>

					</div>

					<div class="checkbox">

						<label><input type="checkbox" value="">3</label>

					</div>

					<div class="checkbox">

						<label><input type="checkbox" value="">4</label>

					</div>

				</div>

				<div>

					<p>Bathrooms</p>

					<div class="checkbox">

						<label><input type="checkbox" value="">Attached</label>

					</div>

					<div class="checkbox">

						<label><input type="checkbox" value="">Common</label>

					</div>

				</div>

				<div>

					<p>Flooring</p>

					<div class="checkbox">

						<label><input type="checkbox" value="">Wooden</label>

					</div>

					<div class="checkbox">

						<label><input type="checkbox" value="">Carpet</label>

					</div>

				</div>

			</td>

			<td>

				<button type="button" class="btn btn-info" data-toggle="collapse"
					data-target="#demo">Simple collapsible</button>

			</td>

		</tr>

	</table>

</div>

<div class="main">

	<div class="container">

		<div class="services" id="services">

			<div id="accordion">

				<h3>Apartment ${XapartmentId}</h3>

				<div>

					<p>

						Deposit Amount: XdepositAmt</br> Rent: Xrent Availability From:
						XavailablityFrom Utilities: Xutilities Area: Xarea Street: Xstreet

						Door Number: XdoorNo City: Xcity Number Of Rooms: XnoOfRoom Number
						Of Bathrooms: Xno_of_bathroom Flooring: Xflooring

					</p>

				</div>

				</body>

				<script>
					$(function() {

						$("#accordion").accordion();

					});
				</script>
</html>