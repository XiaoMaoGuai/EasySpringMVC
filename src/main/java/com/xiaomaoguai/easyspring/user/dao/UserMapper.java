package com.xiaomaoguai.easyspring.user.dao;

import java.util.List;

import com.xiaomaoguai.easyspring.user.model.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> findAll();

	int findUserByAccountAndPass(User user);
}