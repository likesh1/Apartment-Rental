

function validateReply(form){
var reply = form.reply.value;
form.reply.style.borderColor="#ccc";
if(reply==""){
	form.reply.focus();
	form.reply.style.borderColor="red";
	form.reply.style.borderStyle="solid";
	return false;
	}

}