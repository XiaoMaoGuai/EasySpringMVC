package com.xiaomaoguai.easyspring.web.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*
 * @Description :
 * @FileName: IndexAction.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午1:27:57
 * @Version:1.0.0
 */

@Controller
@RequestMapping("/")
@SessionAttributes({ "ctx", "language" })
public class IndexAction {

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model) {
		// 工程根目录
		model.put("ctx", request.getContextPath());
		// 语言
		Locale defaultLocale = Locale.getDefault();
		String country = defaultLocale.getCountry();// 返回国家地区代码
		String language = defaultLocale.getLanguage();// 返回国家的语言
		model.put("language", language + "_" + country);
		return "user/login";
	}
}
