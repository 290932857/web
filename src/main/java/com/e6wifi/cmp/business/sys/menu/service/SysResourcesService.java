package com.e6wifi.cmp.business.sys.menu.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.sys.menu.dao.SysResourcesMapper;
import com.e6wifi.cmp.business.sys.menu.entity.SysResourceEntity;

@Component("sysResourcesService")
public class SysResourcesService {

    @Resource(name = "sysResourcesMapper")
    private SysResourcesMapper sysResourcesMapper;

	/**
	 * 根据用户id获取资源列表
	 * 
	 * @param id
	 * @return
	 */
    public List<SysResourceEntity> getSysResourcesByUser(Integer uid) {
		List<SysResourceEntity> allResources = sysResourcesMapper.getResources(uid);// 数据库中获取的所有节点
		SysResourceEntity root = new SysResourceEntity();// 根节点
		if (allResources != null && allResources.size() > 0) {
			Iterator<SysResourceEntity> iterator = allResources.iterator();
			while (iterator.hasNext()) {
				SysResourceEntity sysResources = (SysResourceEntity) iterator.next();
				if (sysResources.getParentid() != null && sysResources.getParentid() == 0) {
					root.getChildren().add(sysResources);
					iterator.remove();
				}
			}
			addTreeNode(root, allResources);
		}
		return root.getChildren();
	}

    private void addTreeNode(SysResourceEntity parent, List<SysResourceEntity> dbResources) {
		if (dbResources == null || dbResources.size() == 0) {
			return;
		}
		if (parent == null || parent.getChildren() == null || parent.getChildren().size() == 0) {
			return;
		}
		List<SysResourceEntity> childs = parent.getChildren();
		for (SysResourceEntity child : childs) {
			// 添加子节点
			for (SysResourceEntity db : dbResources) {
				if (child.getReid() == db.getParentid()) {
					// 如果不存在就做关联
					if (!child.getChildren().contains(db)) {
						child.getChildren().add(db);
					}
				}
			}
			// 设置父节点
			child.setParent(parent);
			addTreeNode(child, dbResources);
		}
	}

    public List<SysResourceEntity> getResources(Integer rid, Integer roleCode) {
    	
    	return null;
    }
    
    /**
     * 根据父ID获取所有子资源
     * @param parentId
     * @return
     */
    public List<SysResourceEntity> getChildResources(Integer parentId) {
    	return sysResourcesMapper.getChildResources(parentId);
    }
    
    /**
     * 保存或更新节点
     * @param resourceEntity
     * @return
     */
    public long saveOrUpdateResources(SysResourceEntity resourceEntity) {
    	if(resourceEntity != null && resourceEntity.getReid() != null) {
    		return sysResourcesMapper.updateResources(resourceEntity);
    	}
    	return sysResourcesMapper.saveResources(resourceEntity);
    }
    
    /**
     * 删除节点
     * @param reid
     * @return
     */
    public long deleteResources(Long reid) {
    	//不能删除根节点
    	if(reid != null && reid != 0) {
    		return sysResourcesMapper.deleteResources(reid);
    	}
    	return 0l;
    }
}
