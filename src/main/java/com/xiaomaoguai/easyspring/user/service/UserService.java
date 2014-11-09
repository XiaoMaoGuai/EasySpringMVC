package com.xiaomaoguai.easyspring.user.service;

import java.util.List;

import com.xiaomaoguai.easyspring.user.model.User;

/*
 * @Description :
 * @FileName: UserService.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午2:56:44
 * @Version:1.0.0
 */
public interface UserService {

	void create(User user);

	void deleteById(int userId);

	void update(User user);

	User findById(int userId);

	List<User> findAll();

	boolean isUserCanLoginIn(User user);
}
