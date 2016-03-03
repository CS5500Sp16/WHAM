$(document).ready(function() {
	$("#loginForm").validate({
		onfocusout : function(element) {
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
			husky_emailid : "Please enter a valid husky email"
		}
	});
}); 