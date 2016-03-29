<!-- Author: SSDI_08 Author URL: SSDI_08 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false"%>

<!DOCTYPE HTML>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<title>Apartments Near UNCC (Location)</title>

<body>
<header>
        <div class="row">
            <div class="pull-right social-icons">
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-google-plus"></i></a>
                <a href="#"><i class="fa fa-youtube"></i></a>
            </div>
        </div>
        <nav class="navbar nav-tabs" style="background: transparent;border: none" >
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#/home">HOME</a></li>
                        <li><a href="#/location">LOCATION</a></li>
                        <li><a href="#/reserve">REGISTRATION</a></li>
                        <li><a href="#/login">LOGIN</a></li>
                        <li><a href="#/about">ABOUT US</a></li>
                        <li ><a href="#/contact">CONTACT</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </header>

	<section id="leftNav" class="col-xs-12">
	<div class="col-xs-3">
    	<div class="container">
     	   <div class="row">
        	    <p>Room Rent</p>
        	    <div >
        	    	<div class="checkbox">
    					<label>
      						<input type="checkbox"> $200 - $300
    					</label>
  					</div>
  					<div class="checkbox">
    					<label>
      						<input type="checkbox"> $300 - $400
    					</label>
  					</div>
  					<div class="checkbox">
    					<label>
      						<input type="checkbox"> $400 - $500
    					</label>
  					</div>
  					<div class="checkbox">
    					<label>
      						<input type="checkbox"> above $500
    					</label>
  					</div>
        	    </div>
        	</div>
        </div>
        <div class="container">
     	   <div class="row">
        	    <p>Rooms</p>
        	    <div >
        	    	<div class="checkbox">
    					<label>
      						<input type="checkbox"> 1
    					</label>
  					</div>
  					<div class="checkbox">
    					<label>
      						<input type="checkbox"> 2
    					</label>
  					</div>
  					<div class="checkbox">
    					<label>
      						<input type="checkbox"> 3
    					</label>
  					</div>
  					<div class="checkbox">
    					<label>
      						<input type="checkbox"> 4
    					</label>
  					</div>
        	    </div>
        	</div>
        </div>
        <div class="container">
     	   <div class="row">
        	    <p>Bathrooms</p>
        	    <div >
        	    	<div class="checkbox">
    					<label>
      						<input type="checkbox"> Attached
    					</label>
  					</div>
  					<div class="checkbox">
    					<label>
      						<input type="checkbox"> Common
    					</label>
  					</div>
        	    </div>
        	</div>
        </div>
        <div class="container">
     	   <div class="row">
        	    <p>Flooring</p>
        	    <div >
        	    	<div class="checkbox">
    					<label>
      						<input type="checkbox"> Wooden
    					</label>
  					</div>
  					<div class="checkbox">
    					<label>
      						<input type="checkbox"> Carpet
    					</label>
  					</div>
        	    </div>
        	</div>
        </div>
       </div>
       
		<div class="container col-sm-4">
	  	<div class="panel-group" id="accordion">
        <div class="panel panel-default">
        <c:forEach items="${apartmentList}" var="apartments">
        	<c:set var="id" value="${apartments.doorNo}"></c:set>
        	<c:set var="href">#${id }</c:set>
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="${href}">APARTMENT ${apartments.doorNo}</a>
                </h4>
            </div>
            <div id="${id}" class="panel-collapse collapse">
                <div class="panel-body">
                	<div class="table-responsive">          
  						<table class="table">
						      <tr>
						        <td>DEPOSITE AMOUNT:</td>
						        <td>${apartments.depositAmt}</td>
						      </tr>
						      <tr>
						        <td>RENT:</td>
						        <td>${apartments.rent}</td>
						      </tr>
						      <tr>
						        <td>AVAILABLE FROM:</td>
						        <td>${apartments.availablityFrom}</td>
						      </tr>
						      <tr>
						        <td>UTILITIES</td>
						        <td><c:out value="${apartments.utilities}" /></td>
						      </tr>
						      <tr>
						        <td>AREA</td>
						        <td><c:out value="${apartments.area}" /></td>
						      </tr>
						      <tr>
						        <td>STREET</td>
						        <td><c:out value="${apartments.street}" /></td>
						      </tr>
						      <tr>
						        <td>DOOR NUMBER</td>
						        <td><c:out value="${apartments.doorNo}" /></td>
						      </tr>
						      <tr>
						        <td>CITY</td>
						        <td><c:out value="${apartments.city}" /></td>
						      </tr>
						      <tr>
						        <td>NUMBER OF ROOMS</td>
						        <td>${apartments.no_of_rooms}</td>
						      </tr>
						      <tr>
						        <td>NUMBER OF BATHROOMS</td>
						        <td>${apartments.no_of_bathroom}</td>
						      </tr>
						      <tr>
						        <td>FLOORING</td>
						        <td><c:out value="${apartments.flooring}" /></td>
						      </tr>
						  </table>
						  </div>
						</div>
	            </div>
	          </c:forEach>
            </div>
        </div>
    </div>
  
    </section>

<!-- Latest compiled and minified JavaScript -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>