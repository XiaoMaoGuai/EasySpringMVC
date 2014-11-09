package com.xiaomaoguai.easyspring.user.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

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

	public User() {
		super();
	}

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
		this.account = account == null ? null : account.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
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
		this.userType = userType == null ? null : userType.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
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
		this.sessionId = sessionId == null ? null : sessionId.trim();
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password="
				+ password + ", email=" + email + ", emailValidated="
				+ emailValidated + ", userType=" + userType + ", name=" + name
				+ ", icon=" + icon + ", telephone=" + telephone
				+ ", registeTime=" + registeTime + ", sessionId=" + sessionId
				+ ", lastLoginTime=" + lastLoginTime + "]";
	}
}