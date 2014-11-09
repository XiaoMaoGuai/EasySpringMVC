/**
 * @author = weihui.zhang
 */
/**
 * HTML 标签转义
 * 
 */
function htmlTagToEntity(str){
    if(!str)return "";
    str = str.replace(/</g, "&lt;");
    str = str.replace(/>/g, "&gt;");
    str = str.replace(/"/g, "&quot;");
    return str;
}
/**
 * @author 孙宇
 * 将form表单元素的值序列化成对象
 * 
 */
$.serializeObject = function(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};
/**
 * 提交表单的封装
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
 * @author 孙宇
 * 
 * @requires jQuery
 * 
 * 改变jQuery的AJAX默认属性和方法
 */
$.ajaxSetup({
	type : 'POST',
	error : function(XMLHttpRequest, textStatus, errorThrown) {
		try {
			parent.$.messager.progress('close');
			parent.$.messager.alert('错误', XMLHttpRequest.responseText);
		} catch (e) {
			alert(XMLHttpRequest.responseText);
		}
	}
});

/**
 * @author 孙宇
 * 
 * 去字符串空格
 * 
 * @returns
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, '');
};
String.prototype.ltrim = function() {
	return this.replace(/(^\s*)/g, '');
};
String.prototype.rtrim = function() {
	return this.replace(/(\s*$)/g, '');
};