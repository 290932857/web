package com.e6wifi.cmp.business.sys.user.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.sys.user.dao.SysUserMapper;
import com.e6wifi.cmp.business.sys.user.model.SysUser;

@Component("sysUserService")
public class SysUserService {

	@Resource(name = "sysUserMapper")
	private SysUserMapper sysUserMapper;

	/**
	 * 登录方法,根据loginId匹配login_id字段或者phone字段
	 * 
	 * @param loginId
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public SysUser login(String logId, String password) throws Exception {
		if (StringUtils.isBlank(logId)) {
			throw new Exception("用户为空");
		}
		Map<String, String> param = new HashMap<>();
		param.put("loginId", logId);
		param.put("phone", logId);
		param.put("password", password);
		return sysUserMapper.getSysUser(param);
	}

}
