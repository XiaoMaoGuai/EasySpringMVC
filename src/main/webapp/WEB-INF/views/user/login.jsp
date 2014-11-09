<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Login Page | Amaze UI Example</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="${ctx}/resources/AmazeUI-1.0.0/assets/i/favicon.png">
<link rel="stylesheet" href="${ctx}/resources/AmazeUI-1.0.0/assets/css/amazeui.min.css" />
<script type="text/javascript" src="${ctx}/resources/Jslib/jquery-1.11.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/resources/Jslib/extJquery.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/resources/js/user/user.js"></script>
<script type="text/javascript">
	$(function(){
		user.initLoginForm();
	});
</script>
<style>
.header {
	text-align: center;
}
.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>
</head>
<body>
	<div id="loginSuccess" class="login_ok"
		style="top: -20px; left: 250px; display: none; z-index: 10000"></div>
	<div class="header">
		<div class="am-g">
			<h1>Web ide</h1>
			<p>
				Integrated Development Environment<br />代码编辑，代码生成，界面设计，调试，编译
			</p>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="col-lg-6 col-md-8 col-sm-centered">
			<h3>登录</h3>
			<hr>
			<div class="am-btn-group">
				<a href="#" class="am-btn am-btn-secondary am-btn-sm"><i
					class="am-icon-github am-icon-sm"></i> Github</a> <a href="#"
					class="am-btn am-btn-success am-btn-sm"><i
					class="am-icon-google-plus-square am-icon-sm"></i> Google+</a> <a
					href="#" class="am-btn am-btn-primary am-btn-sm"><i
					class="am-icon-stack-overflow am-icon-sm"></i> stackOverflow</a>
			</div>
			<br> <br>

			<form method="post" class="am-form" id="loginForm">
				<label for="email">邮箱:</label>
				<input type="email" name="" id="email" value=""> <br>
				<label for="password">密码:</label>
				<input type="password" name="" id="password" value=""> <br>
				<label for="remember-me">
				<input id="remember-me" type="checkbox"> 记住密码
				</label> <br />
				<div class="am-cf">
					<input type="submit" name="" value="登 录" id="loginBtn" class="am-btn am-btn-primary am-btn-sm am-fl">
					<input type="submit" name="" value="忘记密码 ^_^? " id="forgetBtn" class="am-btn am-btn-default am-btn-sm am-fr">
				</div>
			</form>
			<hr>
			<p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
		</div>
	</div>
</body>
</html>