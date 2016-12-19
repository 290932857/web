package com.e6wifi.cmp.business.sys.user.entity;

import java.util.Date;

/**
 * 用户表实体类：t_user
 * 
 * @author Lijiacheng
 */
public class SysUserEntity {

	private Integer userId;
	private String userName;
	private String loginId;
	private String password;
	private Integer age;
	private Date brithday;
	private Date createtime;
	private String email;
	private Integer sex;
	private String userMamger;
	private String phone;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId == null ? null : loginId.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getUserMamger() {
		return userMamger;
	}

	public void setUserMamger(String userMamger) {
		this.userMamger = userMamger == null ? null : userMamger.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName + ", loginId=" + loginId + ", password="
				+ password + ", age=" + age + ", brithday=" + brithday + ", createtime=" + createtime + ", email="
				+ email + ", sex=" + sex + ", userMamger=" + userMamger + ", phone=" + phone + "]";
	}

}