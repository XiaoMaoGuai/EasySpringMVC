/**
 * @author = xiaomaoguai
 */
var user = {
		
		getRootPath : function(){
			return '${ctx}' + "user/";
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
				postReturnJson(data,user.getRootPath() + "login.xhtml",function(data){
					if(data.code == 0){
						console.info("登陆成功");
					}else{
						console.info("登陆失败");
					}
				});
			});
		},
};