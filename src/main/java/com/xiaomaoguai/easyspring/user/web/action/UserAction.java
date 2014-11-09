package com.xiaomaoguai.easyspring.user.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaomaoguai.easyspring.user.model.User;
import com.xiaomaoguai.easyspring.user.service.UserService;

/*
 * @Description :
 * @FileName: UserAction.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午5:52:22
 * @Version:1.0.0
 */

@Controller
@RequestMapping("user")
public class UserAction {

	@Autowired
	private UserService userService;
	
	@RequestMapping("listAll.xhtml")
	public String listAll(ModelMap map) {
		List<User> users = userService.findAll();
		map.addAttribute("userList", users);
		return "user/listUser";
	}
}
