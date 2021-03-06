package com.e6wifi.cmp.business.sys.menu.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源列表实体类：t_sys_resources
 * 
 * @author luo
 */
public class SysResourceEntity {

    private Integer reid;
    private String name;
    private String breadcrub;
    private String path;
    private Integer parentid;
    private Integer type;
    private Long dateline;
    private Integer sort;
    
	// 冗余字段，做关联时使用
    private SysResourceEntity parent;
    private List<SysResourceEntity> children = new ArrayList<SysResourceEntity>(); // 子菜单

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getBreadcrub() {
		return breadcrub;
	}

	public void setBreadcrub(String breadcrub) {
		this.breadcrub = breadcrub == null ? null : breadcrub.trim();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path == null ? null : path.trim();
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getDateline() {
		return dateline;
	}

	public void setDateline(Long dateline) {
		this.dateline = dateline;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public SysResourceEntity getParent() {
		return parent;
	}

	public void setParent(SysResourceEntity parent) {
		this.parent = parent;
	}

	public List<SysResourceEntity> getChildren() {
		return children;
	}

	public void setChildren(List<SysResourceEntity> children) {
		this.children = children;
	}

}