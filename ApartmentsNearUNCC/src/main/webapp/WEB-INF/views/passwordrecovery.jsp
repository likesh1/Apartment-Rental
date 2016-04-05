<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Verify your email id</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Verify your Email Id!!</h2>
  <div class="alert alert-success" id="email_div">
    <strong>Step 1</strong>Please enter your email id
    <br><form action="passwordRecovery.do" method="POST"><input type="text" id="email" name="email"><br><button id="verify">Verify</button></form>
  </div>
  <div class="alert alert-info" id="otp_div">
    <strong>Step 2</strong> You are one step away from activating your account. Please enter OTP sent to ${user.username}
  	<br><form action="passwordRecovery.do" method="POST"><input type="text" id="otp" name="otp"><br><button id="verify_otp">Verify OTP</button></form>
  </div>
  <div class="alert alert-warning" id="warning_div">
    <strong>Step 3</strong> Enter New Password
    <br/>
    <form action="passwordRecovery.do" method="POST">
    <input type="text" id="email" name="email"><br>
    <button id="update_password">Update Password</button></form>
  </div>
  <div class="alert alert-danger" id="error_div">
    <strong>Error!</strong> Email/Otp not valid!!!
  </div>
</div>

</body>
<script>
	$(document).ready(function () {
		var isValidData=${isValidEmail};
		var isCorrectOtp=${isCorrectOtp};
		if(isCorrectOtp){
			$('#verify').hide();
			$('#verify_otp').hide();
			$('#warning_div').show();
			$('#error_div').hide();
		}
		else if(isValidData){
			$('#verify').hide();
			$('#otp_div').show();
			$('#warning_div').hide();
			$('#error_div').hide();
		}
		else{
		$('#email_div').show();
		$('#otp_div').hide();
		$('#warning_div').hide();
		$('#error_div').hide();
		}
	});
</script>
</html>
