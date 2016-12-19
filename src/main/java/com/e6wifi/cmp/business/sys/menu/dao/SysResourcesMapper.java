package com.e6wifi.cmp.business.sys.menu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e6wifi.cmp.business.sys.menu.entity.SysResourceEntity;

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
	public List<SysResourceEntity> getResources(Integer userId);

    /**
     * 根据父ID获取资源
     * @param parentId
     * @return
     */
    public List<SysResourceEntity> getChildResources(@Param("parentId") Integer parentId);
    
    /**
     * 保存节点
     * @param resourceEntity
     * @return
     */
    public long saveResources(SysResourceEntity resourceEntity);
    
    /**
     * 更新节点
     * @param resourceEntity
     * @return
     */
    public long updateResources(SysResourceEntity resourceEntity);
    
    /**
     * 删除节点
     * @param parentId
     * @return
     */
    public long deleteResources(@Param("reid") Long reid);
}