/**
 * 
 */
var attempt = 3; // Variable to count number of attempts.
// Below function Executes on click of login button.
function validateRegistration(form){
var fname = form.fname.value;
var lname = form.lname.value;
var email = form.email.value;
var password =	form.password.value;
var repeat_password = form.repeat_password.value;

form.fname.style.borderColor="#ccc";
form.lname.style.borderColor="#ccc";
form.email.style.borderColor="#ccc";
form.password.style.borderColor="#ccc";
form.repeat_password.style.borderColor="#ccc";
if(fname==""){
	//alert("Error!!");
	form.fname.focus();
	form.fname.style.borderColor="red";
	form.fname.style.borderStyle="solid";
	document.getElementById('registrationErrorMessage').innerHTML="First Name Blank!!";
	return false;
	
}
else if(lname==""){
	//alert("Error!!");
	form.lname.focus();
	form.lname.style.borderColor="red";
	form.lname.style.borderStyle="solid";
	document.getElementById('registrationErrorMessage').innerHTML="Last Name Blank!!";
	return false;
	
}
else if(email==""){
	//alert("Error!!");
	form.email.focus();
	form.email.style.borderColor="red";
	form.email.style.borderStyle="solid";
	document.getElementById('registrationErrorMessage').innerHTML="Email Blank!!";
	return false;
	
}
else if(!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/).test(email)){
	//alert("Error!!");
	form.email.focus();
	form.email.style.borderColor="red";
	form.email.style.borderStyle="solid";
	document.getElementById('registrationErrorMessage').innerHTML="Not a valid email id!!";
	return false;
	
}
else if(password==""){
	form.password.focus();
	form.password.style.borderColor="red";
	form.password.style.borderStyle="solid";
	document.getElementById('registrationErrorMessage').innerHTML="Password Blank!!";
	return false;
}

else if(!(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/).test(password)){
	form.password.focus();
	form.password.style.borderColor="red";
	form.password.style.borderStyle="solid";
	document.getElementById('registrationErrorMessage').innerHTML="Enter at least one number, one lowercase and one uppercase letter and " +
			"at least six characters that are letters, numbers or the underscorenote";
	return false;
}

else if(password!=repeat_password){
	form.repeat_password.focus();
	form.repeat_password.style.borderColor="red";
	form.repeat_password.style.borderStyle="solid";
	document.getElementById('registrationErrorMessage').innerHTML="Password Not Matching!!";
	return false;
}


/*else
{
	window.location.href="";
	//window.location = "success.html"; // Redirecting to other page.
	return false;
}*/
}