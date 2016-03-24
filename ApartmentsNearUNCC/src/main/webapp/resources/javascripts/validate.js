/**
 * 
 */
var attempt = 3; // Variable to count number of attempts.
// Below function Executes on click of login button.
function validate(form){
var username = form.username.value;
var password = form.password.value;
form.username.style.borderColor="#ccc";
form.password.style.borderColor="#ccc";
if(username==""){
	//alert("Error!!");
	form.username.focus();
	form.username.style.borderColor="red";
	form.username.style.borderStyle="solid";
	return false;
	
}
else if(password==""){
	form.password.focus();
	form.password.style.borderColor="red";
	form.password.style.borderStyle="solid";
	return false;
}


/*else
{
	window.location.href="";
	//window.location = "success.html"; // Redirecting to other page.
	return false;
}*/
}