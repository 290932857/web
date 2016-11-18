package com.e6wifi.cmp.business.sys.menu.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.e6wifi.cmp.business.sys.menu.dao.SysResourcesMapper;
import com.e6wifi.cmp.business.sys.menu.model.SysResources;

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
    public List<SysResources> getSysResourcesByUser(Integer uid) {
		List<SysResources> allResources = sysResourcesMapper.getResources(uid);// 数据库中获取的所有节点
		SysResources root = new SysResources();// 根节点
		if (allResources != null && allResources.size() > 0) {
			Iterator<SysResources> iterator = allResources.iterator();
			while (iterator.hasNext()) {
				SysResources sysResources = (SysResources) iterator.next();
				if (sysResources.getParentid() != null && sysResources.getParentid() == 0) {
					root.getChildren().add(sysResources);
					iterator.remove();
				}
			}
			addTreeNode(root, allResources);
		}
		return root.getChildren();
	}

    private void addTreeNode(SysResources parent, List<SysResources> dbResources) {
		if (dbResources == null || dbResources.size() == 0) {
			return;
		}
		if (parent == null || parent.getChildren() == null || parent.getChildren().size() == 0) {
			return;
		}
		List<SysResources> childs = parent.getChildren();
		for (SysResources child : childs) {
			// 添加子节点
			for (SysResources db : dbResources) {
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

}
