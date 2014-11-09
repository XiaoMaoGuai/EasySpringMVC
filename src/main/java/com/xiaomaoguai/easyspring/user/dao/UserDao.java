package com.xiaomaoguai.easyspring.user.dao;

import java.util.List;

import com.xiaomaoguai.easyspring.user.model.User;

/*
 * @Description :
 * @FileName: UserDao.java
 * @Author :WeiHui.Zhang
 * @Data : 2014年11月9日 下午2:59:38
 * @Version:1.0.0
 */
public interface UserDao {

	void create(User user);

	void deleteById(int userId);

	void update(User user);

	User findById(int userId);

	List<User> findAll();

	boolean isUserCanLoginIn(User user);
}
