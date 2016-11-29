package com.e6wifi.cmp.business.sys.menu.dao;

import java.util.List;

import com.e6wifi.cmp.business.sys.menu.model.SysResources;

/**
 * 资源Mapper
 * 
 * @author 
 */
public interface SysResourcesMapper {

	/**
	 * 获取目录资源
	 * 
	 * @param userId
	 * @return
	 */
    List<SysResources> getResources(Integer userId);

}