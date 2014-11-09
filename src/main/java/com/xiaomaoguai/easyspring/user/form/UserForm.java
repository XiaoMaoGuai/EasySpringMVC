package com.xiaomaoguai.easyspring.user.form;

import java.io.Serializable;
import java.util.Date;

import com.xiaomaoguai.easyspring.user.model.User;

public class UserForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String account;

	private String password;

	private String email;

	private Integer emailValidated;

	private String userType;

	private String name;

	private String icon;

	private String telephone;

	private Date registeTime;

	private String sessionId;

	private Date lastLoginTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmailValidated() {
		return emailValidated;
	}

	public void setEmailValidated(Integer emailValidated) {
		this.emailValidated = emailValidated;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getRegisteTime() {
		return registeTime;
	}

	public void setRegisteTime(Date registeTime) {
		this.registeTime = registeTime;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public static void validateForLogin(User user) {
		
	}

}
