package com.e6wifi.cmp.business.sys.right.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.sys.menu.entity.SysResourceEntity;
import com.e6wifi.cmp.business.sys.menu.service.SysResourcesService;
import com.e6wifi.cmp.business.sys.user.entity.SysUserEntity;
import com.e6wifi.cmp.common.datasource.DataSourceChange;
import com.e6wifi.cmp.common.datasource.DataSourceContextHolder;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@Controller
public class IndexController {

	static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Resource(name = "sysResourcesService")
	private SysResourcesService sysResourcesService;

	/**
	 * 首页菜单拼接
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/index", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String initMenu(HttpServletRequest request) {
		logger.info("index--changeB--dataSource: " + DataSourceContextHolder.getDataSourceType());
		DataSourceChange.dataToPlatform();
		logger.info("index--changeA--dataSource: " + DataSourceContextHolder.getDataSourceType());
		/*SysUser user = (SysUser) request.getSession().getAttribute("user_session");
		if (user == null) {
			return "[]";
		}*/
		// 登录状态下，获取菜单
		List<SysResourceEntity> resources = sysResourcesService.getSysResourcesByUser(1);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(new String[] { "parent" });
		JSONArray json = JSONArray.fromObject(resources, jsonConfig);
		return json.toString();
	}

}
