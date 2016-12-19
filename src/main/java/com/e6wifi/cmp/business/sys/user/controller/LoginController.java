package com.e6wifi.cmp.business.sys.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.sys.user.entity.SysUserEntity;
import com.e6wifi.cmp.business.sys.user.service.SysUserService;
import com.e6wifi.cmp.common.datasource.DataSourceChange;
import com.e6wifi.cmp.common.datasource.DataSourceContextHolder;
import com.e6wifi.cmp.common.model.ResponseJson;
import com.e6wifi.cmp.common.utils.Constants;

@Controller
public class LoginController {

	static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "sysUserService")
	private SysUserService sysUserService;

	/**
	 * 登录方法
	 * 
	 * @param loginId
	 * @param password
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/user/login")
	@ResponseBody
	public ResponseJson login(@RequestParam("loginId") String loginId, @RequestParam("password") String password,
			HttpServletRequest request) throws Exception {
		logger.info("login--changeB--dataSource: " + DataSourceContextHolder.getDataSourceType());
		DataSourceChange.dataToPlatform();
		logger.info("login--changeA--dataSource: " + DataSourceContextHolder.getDataSourceType());
		ResponseJson responseJson = new ResponseJson();
		SysUserEntity user = sysUserService.login(loginId, password);
		// 用户不为空，设置session
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute(Constants.USER_SESSION, user);
			responseJson.setSuccess(true);
			responseJson.setMessage("成功");
		} else {
			responseJson.setSuccess(false);
			responseJson.setMessage("用户名或密码错误");
		}
		return responseJson;
	}

	/**
	 * 退出
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/user/logout")
	@ResponseBody
	public ResponseJson logout(HttpServletRequest request) {
		ResponseJson json = new ResponseJson();
		try {
			// 删除session
			HttpSession session = request.getSession();
			session.removeAttribute(Constants.USER_SESSION);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMessage("服务器异常");
		}
		return json;
	}

}
