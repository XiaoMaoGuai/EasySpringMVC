/**
 * @author xiaomaoguai
 */
var CONTEXT_PATH = parent.CONTEXT_PATH;

function showWarningBox(title,fn){
	$.messager.alert('系统提示', title, 'warning',fn); 
}
function showErrorBox(title,fn){
	$.messager.alert('系统提示', title, 'error',fn); 
}
function showInfoBox(title,fn){
	$.messager.alert('系统提示', title, 'info',fn); 
}
function showConfirmBox(title,fn){
	$.messager.confirm('系统提示', title, fn);
}

/**
 * 把表单用AJAX提交，返回JSON格式数据
 */
function submitForm(jqForm,callback){
	$.ajax({
		  type: 'POST',
		  data: $.serializeObject(jqForm),//序列化表单里的input对象为json对象
		  cache: false,//不从缓存中读取数据
		  url: jqForm.attr('action'),    //服务端的URL
		  dataType: 'json',  //预期服务器返回的数据类型，可以是XML,HTML,JSON等
		  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		  timeout : 30000,   //超时设置 30秒
		  success : function(result){callback(result);}		
	});
}

/**
 * post请求，返回json格式数据没有提示
 * @param url
 * @param data
 * @param fn
 */
function postReturnJsonnoalert(url,data,callback){
	$.ajax({
		  type: 'POST',
		  data: data,//请求字符窜
		  cache: false,//不从缓存中读取数据
		  async:false,
		  url: CONTEXT_PATH+url,    //服务端的URL
		  dataType: 'json',  //预期服务器返回的数据类型，可以是XML,HTML,JSON等
		  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		  timeout : 30000,   //超时设置 30秒
		  success : function(result){ 
			  callback(result);
		  }
	});
}