package com.xiaomaoguai.easyspring.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @Description :
 * @FileName: IndexAction.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午1:27:57
 * @Version:1.0.0
 */

@Controller
@RequestMapping("/")
public class IndexAction {

	@RequestMapping(value = "index.xhtml", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "index";
	}
}
