/**
 * @author = xiaomaoguai
 */
var user = {
		
		getRootPath : function(){
			return CONTEXT_PATH + "/user/";
		},
		
		initLoginForm : function(){
			$("#loginBtn").click(function(){
				var remenber = $("#remember-me").is(":checked")?1:0;
				var data={
						"email":$("#email").val(),
						"password":$("#password").val(),
						"remenber":remenber,
				};
				console.info(data);
			});
		},
};