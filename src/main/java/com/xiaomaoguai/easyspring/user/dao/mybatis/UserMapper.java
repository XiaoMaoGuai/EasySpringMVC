package com.xiaomaoguai.easyspring.user.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaomaoguai.easyspring.user.model.User;

public interface UserMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User findById(@Param("id") Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> findAll();

	int findUserByAccountAndPass(User user);
}