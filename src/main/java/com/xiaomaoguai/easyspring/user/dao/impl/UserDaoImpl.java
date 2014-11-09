package com.xiaomaoguai.easyspring.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaomaoguai.easyspring.user.dao.UserDao;
import com.xiaomaoguai.easyspring.user.dao.UserMapper;
import com.xiaomaoguai.easyspring.user.model.User;

/*
 * @Description :
 * @FileName: UserDaoImpl.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午3:00:04
 * @Version:1.0.0
 */

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserMapper userMapper;
	
	public void create(User user) {
		userMapper.insert(user);
	}

	public void deleteById(int id) {
		userMapper.deleteByPrimaryKey(id);
	}

	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	public User findById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public List<User> findAll() {
		return userMapper.findAll();
	}

}
