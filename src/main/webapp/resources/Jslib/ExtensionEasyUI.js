/**
 * @author weihui.zhang
 */
//显示进度条
function progress(){
	$.fn.loadingtips();
}

//关闭进度条
function closeProgress(){
	$.fn.loadingtips('close');
}

/**
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 * 防止panel/window/dialog组件超出浏览器边界
 * @param left
 * @param top
 */
var easyuiPanelOnMove = function(left, top) {
	var l = left;
	var t = top;
	if (l < 1) {
		l = 1;
	}
	if (t < 1) {
		t = 1;
	}
	var width = parseInt($(this).parent().css('width')) + 14;
	var height = parseInt($(this).parent().css('height')) + 14;
	var right = l + width;
	var buttom = t + height;
	var browserWidth = $(window).width();
	var browserHeight = $(window).height();
	if (right > browserWidth) {
		l = browserWidth - width;
	}
	if (buttom > browserHeight) {
		t = browserHeight - height;
	}
	$(this).parent().css({/* 修正面板位置 */
		left : l,
		top : t
	});
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;

$.fn.extend({
	pagearea : function(){//获取页面尺寸
		if (document.compatMode == 'BackCompat') {
			return {
				width: Math.max(document.body.scrollWidth, document.body.clientWidth),
				height: Math.max(document.body.scrollHeight, document.body.clientHeight)
			};
		} else {
			return {
				width: Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth),
				height: Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight)
			};
		}
	},
	
	center : function(w, h){//获取元素要处于页面中间所需的left-top值
		var pos = {};
		pos.l = ($(window).outerWidth() - w) / 2 + $(document).scrollLeft();
		pos.t = ($(window).outerHeight() - h) / 2 + $(document).scrollTop();
		return pos;
	},
	
	winmask : function(opts){//可以创建一个遮罩层，传入'close'关闭
		if(opts && opts === 'close'){
			$('body>div.window-mask-tips').hide();
			return;
		}
		if($('body>div.window-mask-tips').length==0){
			$('<div class="window-mask window-mask-tips"></div>').appendTo('body');
		}
		$('body>div.window-mask-tips').css({
			width: $.fn.pagearea().width,
			height: $.fn.pagearea().height,
			display: 'block',
			zIndex: ++$.fn.window.defaults.zIndex
		});
	},
	
	loadingtips : function(opts){//页面加载提示，opts如果是'close'就关闭，参数opts--{modal: true or false 默认true, text: 要显示的东西}
		if(opts && opts === 'close'){
			$('#loadingTips').hide();
			$.fn.winmask('close');
			return;
		}
		var opt = opts || {modal: true, text: '数据处理中，请稍后...'};
		if(opt.modal){
			$.fn.winmask();
		}
		var z = ++$.fn.window.defaults.zIndex;
		if($('#loadingTips').length==0){
			$('<div />',{"id":"loadingTips", "class":"datagrid-mask-msg"}).appendTo('body');
		}
		$('#loadingTips').css({'display':'block', 'z-index':z, 'left':'50%', 'margin-left':'-80px'}).html(opt.text);
	},
	
	msearch : function(opts){//高级查询，opts{btns:[]}最后显示的按钮，handler return false将阻止面板关闭
		var $t = $(this), sbox = $t.attr('href'),
		norInp = $t.prev().children('.searchbox-text'),
		opts = $.extend({
			btns : [
				{text:'确定',handler:function(){ return true;}},
				{text:'取消',handler:function(){ return true;}}
			]
		}, opts || {});
		if(typeof sbox == 'string' && sbox!=''){
			sbox = $(sbox);
			$t.unbind('click.msearch').bind('click.msearch', function(){
				if(sbox.children('.dialog-button').length==0){
					var btns = $('<div class="dialog-button tac"></div>');
					$.each(opts.btns, function(i,o){
						var btn = $('<a href="#">'+o.text+'</a>').appendTo(btns);
						btn.linkbutton().bind('click', function(){
							var callf = o.handler();
							if(typeof callf == 'undefined' || !!callf){
								sbox.slideUp();
							}
						});
					});
					btns.appendTo(sbox);
				}
				sbox.slideDown();
				return false;
			}).bind('mousedown.msearch', function(e){
				e.stopPropagation();
			});
			$(document).bind('mousedown.msearch', function(e){
				sbox.slideUp();
			});
			sbox.bind('mousedown.msearch', function(e){
				e.stopPropagation();
			});
		}
	}
});

function showWarningBox(title,fn){
	$.messager.alert(GLOBAL_I18N.global_progress_title, title, 'warning',fn); 
}
function showErrorBox(title,fn){
	$.messager.alert(GLOBAL_I18N.global_progress_title, title, 'error',fn); 
}
function showInfoBox(title,fn){
	$.messager.alert(GLOBAL_I18N.global_progress_title, title, 'info',fn); 
}
function showConfirmBox(title,fn){
	$.messager.confirm(GLOBAL_I18N.global_progress_title, title, fn);
}
/**
 * 动态创建dataGrid onHeaderContextMenu功能+加上了排序功能
 * @param  e  事件
 * @param field 表头field值
 */
var createGridHeaderContextMenu  = function(e, field){
	 e.preventDefault();//阻止浏览器捕获右键事件
	 var grid = $(this);/* grid本身 */
     var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
     if (!headerContextMenu) {
             var tmenu = $('<div style="width:100px;"></div>').appendTo('body');
             var asc = $('<div iconCls="icon-asc" field="asc">升序</div>').appendTo(tmenu);
             var desc = $('<div iconCls="icon-desc" field="desc">降序</div>').appendTo(tmenu);
             var filedHTML = $('<div iconCls="icon-columns"></div>');
             var span = $('<span>显示列/隐藏列</span>');
             var spdiv = $('<div></div>');
             var fields = grid.datagrid('getColumnFields');
             for ( var i = 0; i < fields.length; i++) {
                     var fildOption = grid.datagrid('getColumnOption', fields[i]);
                     if (!fildOption.hidden) {
                             $('<div iconCls="icon-checked" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(spdiv);
                     } else {
                             $('<div iconCls="icon-unchecked" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(spdiv);
                     }
             }
             span.appendTo(filedHTML);
             spdiv.appendTo(filedHTML);
             filedHTML.appendTo(tmenu);
             headerContextMenu = this.headerContextMenu = tmenu.menu({
                     onClick : function(item) {
                             var f = $(this).attr('field')
                             var fieldProperty = $(item.target).attr('field');
                             if (item.iconCls == 'icon-checked') {
                                     grid.datagrid('hideColumn', fieldProperty);
                                     $(this).menu('setIcon', {
                                             target : item.target,
                                             iconCls : 'icon-unchecked'
                                     });
                             }
                             if (item.iconCls == 'icon-unchecked') {
                                     grid.datagrid('showColumn', fieldProperty);
                                     $(this).menu('setIcon', {
                                             target : item.target,
                                             iconCls : 'icon-checked'
                                     });
                             }
                             if (item.iconCls == 'icon-asc') {
                                     var options = grid.datagrid('options');
                                     options.sortName = f;
                                     options.sortOrder =fieldProperty;
                                     grid.datagrid('reload');
                             }
                             if (item.iconCls == 'icon-desc') {
                                     var options = grid.datagrid('options');
                                     options.sortName = f;
                                     options.sortOrder =fieldProperty;
                                     grid.datagrid('reload');
                             }
                     }
             });
     }
     headerContextMenu.attr('field',field);
     headerContextMenu.menu('show', {
             left : e.pageX,
             top : e.pageY
     });
};
$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
$.fn.treegrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;

/**
 * 扩展Easyui Datagrid 的方法
 */
$.extend($.fn.datagrid.methods, {
    /**
     * 更新 非编辑列值
     * @param rowIndex    : 行索引
     * @param cellName    : 列索引或列名
     * @param cellValue    : 列值
     * @author WUYFaaa
     */
    updateRowCell : function(jq, param) {
        var oGrid = $(jq);
        var jqId = $(jq).attr("id");

        var curRow = (oGrid.datagrid('getRows')[param.rowIndex]);
        oGrid.datagrid('updateRow', {
            index : param.rowIndex,
            row : param.row
        });

    }
});


/**
 * layout 全屏、取消全屏扩展
 */
$.extend($.fn.layout.methods,{
	full : function(jq){
		return jq.each(function(){
			var layout = $(this);
			var center = layout.layout('panel','center');
			center.panel('maximize');
			center.parent().css('z-index', 10);
			$(window).on('resize.full', function () {
				layout.layout('unFull').layout('resize');
			});
		});
	},
	unFull : function (jq) {
		return jq.each(function () {
			var center = $(this).layout('panel', 'center');
			center.parent().css('z-index', 'inherit');
			center.panel('restore');
			$(window).off('resize.full');
		});
	}
});

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 创建一个模式化的dialog
 * 
 * @returns $.modalDialog.handler 这个handler代表弹出的dialog句柄
 * 
 * @returns $.modalDialog.xxx 这个xxx是可以自己定义名称，主要用在弹窗关闭时，刷新某些对象的操作，可以将xxx这个对象预定义好
 */
$.modalDialog = function(options) {
	if ($.modalDialog.handler == undefined) {// 避免重复弹出
		var opts = $.extend({
			title : '',
			width : 840,
			height : 680,
			modal : true,
			onClose : function() {
				$.modalDialog.handler = undefined;
				$(this).dialog('destroy');
			},
			onOpen : function() {
				progress();
			}
		}, options);
		opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
		console.info($('<div/>').dialog(opts));
		return $.modalDialog.handler = $('<div/>').dialog(opts);
	}
};
$.extend($.fn.datagrid.defaults.view,{
	onAfterRender : function(tag){//隐藏单行选择时头部的checkbox
		if($(tag).datagrid('options').singleSelect){
			$(tag).parent().find('.datagrid-header-check').children(':checkbox').hide();
		}
	}
});

$.extend($.fn.draggable.defaults,{
	onBeforeDrag : function(){
		if($(this).find('iframe').length>0){
			var pbody = $(this).find('.dialog-content:first');
			if(pbody.children('.ifrmask').length==0){
				$('<div class="ifrmask" style="position:absolute;top:0;right:0;width:100%;height:100%;z-index:99999999;background:#fff;"></div>').css('opacity', '0').appendTo(pbody);
			}
		}
	}
});

$.extend($.fn.dialog.defaults,{
	onMove : function(){
		var ifrm = $(this).find('.ifrmask');
		if(ifrm.length>0){
			ifrm.remove();
		}
	}
});

/**
 * 以iframe的方式弹出窗口
 * 
 * @param opts
 * 
 */
$.ifrdialog =  function(opts){
	if($.ifrdialog.handler) return;
	var opts = $.extend({
		title: '',
		width: 600,
		height: 480,
		modal: true,
		onClose : function() {
			$.ifrdialog.ifr.attr('src', 'about:blank');
			$.ifrdialog.handler = undefined;
			$.ifrdialog.ifr = null;
			$(this).dialog('destroy');
		},
		onOpen : function() {
			progress();
		}
	}, opts||{});
	var ifr = opts.href;
	opts.href = null;
	$.ifrdialog.ifr = $('<iframe frameborder="no" style="border:none; position:absolute; width:100%; height:100%" src=""/>');
	$.ifrdialog.handler = $('<div/>').css('position','relative').append($.ifrdialog.ifr).dialog(opts);
	$.ifrdialog.ifr.attr('src', ifr);
	$.ifrdialog.ifr.bind('load', function(){
		closeProgress();
	});
	return $.ifrdialog.handler;
};