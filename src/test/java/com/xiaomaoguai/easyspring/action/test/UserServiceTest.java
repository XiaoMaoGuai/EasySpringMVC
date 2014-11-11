package com.xiaomaoguai.easyspring.action.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.xiaomaoguai.easyspring.user.model.User;
import com.xiaomaoguai.easyspring.user.service.UserService;

/*
 * @Description :
 * @FileName: ServiceTest.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月11日 上午2:45:23
 * @Version:1.0.0
 */

public class UserServiceTest extends AbstractServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testfindById() {
		User user = userService.findById(1);
		logger.info(JSON.toJSONString(user));
	}
}
