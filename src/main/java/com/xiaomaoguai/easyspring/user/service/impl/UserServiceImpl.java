package com.xiaomaoguai.easyspring.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaomaoguai.easyspring.user.dao.UserDao;
import com.xiaomaoguai.easyspring.user.model.User;
import com.xiaomaoguai.easyspring.user.service.UserService;

/*
 * @Description :
 * @FileName: UserService.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午5:57:58
 * @Version:1.0.0
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public void create(User user) {
		userDao.create(user);
	}

	public void deleteById(int userId) {
		userDao.deleteById(userId);
	}

	public void update(User user) {
		
	}

	public User findById(int userId) {
		return userDao.findById(userId);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public boolean isUserCanLoginIn(User user) {
		return userDao.isUserCanLoginIn(user);
	}

}
