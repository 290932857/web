package com.e6wifi.cmp.business.sys.user.dao;

import java.util.Map;

import com.e6wifi.cmp.business.sys.user.entity.SysUserEntity;

/**
 * 用户Mapper
 * 
 * @author Lijiacheng
 */
public interface SysUserMapper {

	/**
	 * 获取用户，对应登录方法
	 * 
	 * @param paramMap
	 * @return
	 */
	SysUserEntity getSysUser(Map<String, String> paramMap);

}