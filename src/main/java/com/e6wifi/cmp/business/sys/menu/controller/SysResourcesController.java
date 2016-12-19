package com.e6wifi.cmp.business.sys.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e6wifi.cmp.business.sys.menu.entity.SysResourceEntity;
import com.e6wifi.cmp.business.sys.menu.service.SysResourcesService;
import com.e6wifi.cmp.common.model.ResponseJson;


@Controller
@Scope("prototype")
public class SysResourcesController {
	
	@Autowired
	private SysResourcesService resourcesService;

	
	/**
	 * 权限菜单逐级查询
	 * @date 2016年3月1日 下午3:47:11
	 * @param rid
	 * @return
	 */
	@RequestMapping(value="/sys/menu/getResources")
	@ResponseBody
	public ResponseJson getResources(@RequestParam Integer rid, @RequestParam Integer roleCode) {
		ResponseJson json = new ResponseJson();
		List<SysResourceEntity> list = resourcesService.getResources(rid, roleCode);
		json.setSuccess(true);
		json.setData(list);
		return json;
	}
	
	/**
	 * 菜单配置
	 * @date 2016年3月1日 下午3:47:11
	 * @param rid
	 * @return
	 */
	@RequestMapping(value="/sys/menu/getChildResources")
	@ResponseBody
	public ResponseJson getChildResources(@RequestParam Integer parentId) {
		ResponseJson json = new ResponseJson();
		List<SysResourceEntity> list = resourcesService.getChildResources(parentId);
		json.setSuccess(true);
		json.setData(list);
		return json;
	}
	
	/**
	 * 添加菜单
	 * @date 2016年3月23日 下午1:49:44
	 * @param resources
	 * @return
	 */
	@RequestMapping(value="/sys/saveOrUpdateResources")
	@ResponseBody
	public ResponseJson saveOrUpdateResources(@ModelAttribute SysResourceEntity resources) {
		ResponseJson json = new ResponseJson();
		try {
			resources.setType(0);
			resourcesService.saveOrUpdateResources(resources);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMessage("服务器错误");
		}
		return json;
	}
	
	/**
	 * 菜单删除
	 * @date 2016年3月23日 下午1:53:28
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/sys/delResources")
	@ResponseBody
	public ResponseJson delResources(@RequestParam Long reid) {
		ResponseJson json = new ResponseJson();
		try {
			resourcesService.deleteResources(reid);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
			json.setMessage("服务器错误");
		}
		return json;
	}
	
	/**
	 * 用户角色列表
	 *//*
	@RequestMapping(value="/sys/getPageRoleInfo")
	@ResponseBody
	public Page getPageRoleInfo(@RequestParam Integer page,@RequestParam Integer limit) {
		
		//获取所有角色
		Page p = resourcesService.getPageRoleInfo(limit,page);
		
		return p;
	}
	
	*//**
	 * 用户角色列表
	 *//*
	@RequestMapping(value="/sys/getRoleInfo")
	@ResponseBody
	public ResponseJson getRoleInfo() {
		ResponseJson json = new ResponseJson();
		
		//获取所有角色
		List<RoleEntity> cuisines = resourcesService.getRoleInfo();
		
		json.setSuccess(true);
		json.setObjs(transform(cuisines));
		return json;
	}
	
	*//**
	 * app功能名称
	 *//*
	@RequestMapping(value="/sys/getAppRoleInfo")
	@ResponseBody
	public ResponseJson getAppRoleInfo() {
		ResponseJson json = new ResponseJson();
		
		//获取所有功能名称
		List<Map<String, Object>> cuisines = resourcesService.getAppRoleInfo();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("code", "");
//		map.put("name", "无");
//		cuisines.add(0,map);
		json.setSuccess(true);
		json.setObjs(transform(cuisines));
		return json;
	}
	
	*//**
	 * 保存角色信息
	 * @author yajie
	 * @date 2016年3月22日 下午4:24:09
	 * @param role
	 * @return
	 *//*
	@RequestMapping(value="/sys/saveRoleInfo")
	@ResponseBody
	public ResponseJson saveRoleInfo(@ModelAttribute RoleEntity role,@RequestParam String[] appCode) {
		ResponseJson json = new ResponseJson();
		String res;
		try {
			res = resourcesService.saveRoleInfo(role,appCode);
			if (!StringUtils.isEmpty(res)) {
				json.setSuccess(false);
				json.setMessage(res);
			} else {
				json.setSuccess(true);
				json.setMessage("保存成功");
			}
		} catch (Exception e) {
			logger.error(e);
			json.setSuccess(false);
			json.setMessage("系统错误");
		}
		
		return json;
	}
	
	*//**
	 * 删除角色信息
	 * @author yajie
	 * @date 2016年3月22日 下午5:08:45
	 * @param id
	 * @return
	 *//*
	@RequestMapping(value="/sys/delRoleInfo")
	@ResponseBody
	public ResponseJson delRoleInfo(@RequestParam int id) {
		ResponseJson json = new ResponseJson();
		try {
			resourcesService.delRoleInfo(id);
			json.setSuccess(true);
		} catch (Exception e) {
			logger.error(e);
			json.setSuccess(false);
			json.setMessage("服务器错误");
		}
		return json;
	}
	
	
	*//**
	 * 更新角色权限表
	 * @author yajie
	 * @date 2016年3月1日 下午6:37:17
	 * @param reid
	 * @param roleCode
	 * @param checked
	 * @return
	 *//*
	@RequestMapping(value="/sys/")
	@ResponseBody
	public ResponseJson updateRecord (@RequestParam Integer reid,@RequestParam String type,
			@RequestParam Integer roleCode,@RequestParam Integer checked,@RequestParam Integer btnId,
			@RequestParam Integer permissionsId) {
		ResponseJson json = new ResponseJson();
		try {
			resourcesService.updateRecord(reid,roleCode,checked,type,permissionsId,btnId);
		} catch (Exception e) {
			logger.error(e);
			json.setSuccess(false);
			json.setMessage("服务器错误");
		}
		
		return json;
	}
	
	*//**
	 * 用户信息
	 * @author yajie
	 * @date 2016年3月2日 下午2:12:10
	 * @param page
	 * @param limit
	 * @return
	 *//*
	@RequestMapping(value="/sys/getUserRole")
	@ResponseBody
	public Page getUserRole(@RequestParam Integer page,@RequestParam Integer limit,@ModelAttribute ParamsEntity params) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("params", params);
		Page pageData = null;
		try {
			pageData = resourcesService.getUserRole(limit, page, paramsMap);
		} catch (Exception e) {
			logger.error(e);
		}
		
		return pageData;
	}
    *//**
     * 用户信息省份
     * @author LiuShuChen  
     * @date 2016年11月15日 下午3:37:51 
     * @return ResponseJson
     *//*
        @ResponseBody
        @RequestMapping(value="/sys/getProvince")
    	public ResponseJson getProvinceForCar() {
    		ResponseJson json = new ResponseJson();
    		List<Map<String, Object>> cuisines = resourcesService.getProvinceForCar();
    		json.setSuccess(true);
    		json.setObjs(transform(cuisines));
    		return json;
    	}
    *//**
     * 用户信息城市
     * @author LiuShuChen  
     * @date 2016年11月15日 下午3:38:35 
     * @return ResponseJson
     *//*
        @ResponseBody
        @RequestMapping(value="/sys/getCity")
    	public ResponseJson getCityForCar(@RequestParam Integer cityParentXh) {
    		ResponseJson json = new ResponseJson();
    		List<Map<String, Object>> cuisines = resourcesService.getCityForCar(cityParentXh);
    		json.setSuccess(true);
    		json.setObjs(transform(cuisines));
    		return json;
    	}
	*//**
	 * 保存用户角色信息
	 * @author yajie
	 * @date 2016年3月2日 下午4:39:45
	 * @param user
	 * @param roleCode
	 * @return
	 *//*
	@RequestMapping(value="/sys/saveUserInfo")
	@ResponseBody
	public ResponseJson saveUserInfo(@ModelAttribute SysUser user,
			@RequestParam Integer roleCode,String[] province,String[] city) {
		ResponseJson json = new ResponseJson();
		try {
			String rs = resourcesService.saveUserInfo(user,roleCode,province,city);
			if (!StringUtils.isEmpty(rs)) {
				json.setSuccess(false);
				json.setMessage(rs);
			} else {
				json.setSuccess(true);
				json.setMessage("操作成功");
			}
			
		} catch (Exception e) {
			logger.error(e);
			json.setSuccess(false);
			json.setMessage("服务器异常");
		}
		return json;
	}
	
	*//**
	 * 删除用户及相关信息
	 * @author yajie
	 * @date 2016年3月3日 上午10:10:50
	 * @param ids
	 * @return
	 *//*
	@RequestMapping(value="/sys/deleteUser")
	@ResponseBody
	public ResponseJson deleteUser(@RequestParam String[] ids) {
		ResponseJson json = new ResponseJson();
		try {
			resourcesService.deleteUser (ids);
			json.setMessage("删除成功");
			json.setSuccess(true);
		} catch (Exception e) {
			logger.error(e);
			json.setMessage("服务器异常");
			json.setSuccess(false);
		}
		return json;
	}
	
	*/
	
	/**
	 * 保存按钮
	 * @author yajie
	 * @date 2016年3月23日 下午1:49:44
	 * @param resources
	 * @return
	 *//*
	@RequestMapping(value="/sys/saveButton")
	@ResponseBody
	public ResponseJson saveButton(@ModelAttribute SysResourceEntity resources,@ModelAttribute Button button,@RequestParam Integer role) {
		ResponseJson json = new ResponseJson();
		try {
			button.setRoleCode(role);
			resourcesService.saveButton(resources,button);
			json.setSuccess(true);
		} catch (Exception e) {
			logger.error(e);
			json.setSuccess(false);
			json.setMessage("服务器错误");
		}
		return json;
	}
	
	*/
	
	/**
	 * 下载导入模板
	 * 
	 * @param request
	 * @param response
	 * @param fileUrl
	 * @param fileName
	 * @return
	 * @throws UnsupportedEncodingException
	 *//*
	@RequestMapping(value = "/sys/downloadFile")
	@ResponseBody
	public String downloadFile(HttpServletRequest request, HttpServletResponse response,@RequestParam String params) throws UnsupportedEncodingException{
		String path = request.getServletContext().getRealPath("/");
		path += "page/model/"+new String(params.getBytes("ISO-8859-1"),"UTF-8");
		ExportUtil.download(request, response, path, params);
		return null;
	}
	

	*//**
	 * 获取按钮权限
	 * @author yajie
	 * @date 2016年6月2日 下午3:56:32
	 * @param request
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/sys/findPermissionsByUser")
	@ResponseBody
	public ResponseJson findPermissionsByUserId(HttpServletRequest request,@RequestParam String model) {
		ResponseJson json = new ResponseJson();
		HttpSession session = request.getSession();
		SysUser user = (SysUser) session.getAttribute(Constants.USER_SESSION);
		PermissionsModel pModel = resourcesService.findPermissionsByUserId(user.getUserId(),model);
		json.setObj(pModel);
		return json;
	}
	
	@RequestMapping(value = "/sys/findBtnInfo")
	@ResponseBody
	public ResponseJson findBtnInfo(@RequestParam String url,HttpServletRequest request) {
		url = "page"+url.split("page")[1];
		ResponseJson json = new ResponseJson();
		HttpSession session = request.getSession();
		SysUser user = (SysUser) session.getAttribute(Constants.USER_SESSION);
		Integer roleCode = resourcesService.findRoleByUserId(user.getUserId());
		List<BtnJson> list = Constants.btnMap.get(url+roleCode);
		json.setObjs(transform(list));
		return json;
	}
	
	*//**
	 * 获得合同服务商
	 * @author jinleiguang
	 * @date 2016年8月12日 下午3:13:01
	 * @param contractId
	 * @return
	 *//*
	@ResponseBody
    @RequestMapping(value="/sys/contract/getFacilitator")
    public ResponseJson getFacilitator(@RequestParam Integer contractId) {
        ResponseJson json = new ResponseJson();
        String facilitator = resourcesService.getFacilitator(contractId);
        json.setSuccess(true);
        json.setObj(facilitator);;
        return json;
    }*/
}
