$(document).ready(function() {

	$("#error").hide();
	
	$("#loginForm").submit(function(event) {
		if ($('#loginForm').valid()) {
			var neu_email_id = document.getElementById("neu_emailid");
			var password = document.getElementById("password");
			if ((neu_email_id.value == "student@husky.neu.edu" || neu_email_id.value == "faculty@neu.edu") && password.value == "secret") {
				return;
			} else {
				event.preventDefault();
				document.getElementById("password").value ="";
				document.getElementById("neu_emailid").value ="";
				$("#error").show();
			}
		}
	}); 

	$("#loginForm").validate({
		onfocusout : function(element) {
			$("#error").hide();
			$(element).valid();
		},
		rules : {
			husky_emailid : {
				required : true,
				email : true
			},
			password : {
				required : true,
			},
		},
		messages : {
			password : "Please enter a password",
			neu_emailid : "Please enter a valid NEU email address"
		}
	});
});
