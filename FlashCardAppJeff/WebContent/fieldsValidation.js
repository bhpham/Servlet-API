function checkForm(form) {
	if (form.username.value == "") {
		alert("Error: Username cannot be blank!");
		form.username.focus();
		return false;
	}
	
	if (form.password.value == "") {
		alert("Error: Password cannot be blank!");
		form.password.focus();
		return false;
	}
	
	re = /^\w+$/;
	if (!re.test(form.username.value)) {
		alert("Error: Username must contain only letters, numbers and underscores!");
		form.username.focus();
		return false;
	}
	
	if (form.password.value.length < 6) {
		alert("Error: Password must contain at least 6 characters!");
		form.password.focus();
		return false;
	}
	
	if (form.password.value == form.username.value) {
		alert("Error: Password must be different from Username!");
		form.password.focus();
		return false;
	}
	
	re = /[a-z]/;
    if(!re.test(form.password.value)) {
      alert("Error: password must contain at least one lowercase letter (a-z)!");
      form.password.focus();
      return false;
    } 
    
    re = /[A-Z]/;
    if(!re.test(form.password.value)) {
      alert("Error: password must contain at least one uppercase letter (A-Z)!");
      form.password.focus();
      return false;
    }

}

function checkMessage(message) {
	if (message.question.value == "") {
		alert("Error: Please enter a question!");
		message.question.focus();
		return false;
	}
	
	if (message.answer.value == "") {
		alert("Error: Please enter your answer!");
		message.answer.focus();
		return false;
	}
	
	if (message.question.value.length > 2000) {
		alert("Error: Exceed the maximum characters. You can only enter 2000 characters!");
		message.question.focus();
		return false;
	}
	
	if (message.answer.value.length > 2000) {
		alert("Error: Exceed the maximum characters. You can only enter 2000 characters!");
		message.answer.focus();
		return false;
	}
}
