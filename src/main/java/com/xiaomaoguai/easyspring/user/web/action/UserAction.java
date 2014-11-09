package com.xiaomaoguai.easyspring.user.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaomaoguai.easyspring.user.form.UserForm;
import com.xiaomaoguai.easyspring.user.model.User;
import com.xiaomaoguai.easyspring.user.service.UserService;
import com.xiaomaoguai.easyspring.web.model.MessageModel;

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
	
	@RequestMapping("login.xhtml")
	public @ResponseBody MessageModel listAll(ModelMap map,User user) {
		MessageModel messageModel = new MessageModel();
		UserForm.validateForLogin(user);
		boolean b = userService.isUserCanLoginIn(user);
		
		if (b) {
			messageModel.setCode(0);
			messageModel.setMsg("login success");
		} else {
			messageModel.setCode(1);
			messageModel.setMsg("login error");
		}
		return messageModel;
	}
}
