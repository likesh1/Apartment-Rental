

function validateQuestion(form){
var question = form.question.value;
form.question.style.borderColor="#ccc";
if(question==""){
	form.question.focus();
	form.question.style.borderColor="red";
	form.question.style.borderStyle="solid";
	return false;
	}
}