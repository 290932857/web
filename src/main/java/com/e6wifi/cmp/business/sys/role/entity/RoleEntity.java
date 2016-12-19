package com.e6wifi.cmp.business.sys.role.entity;

/**
 * 用户角色表
 * @author yajie
 * @date 2016年3月1日 下午5:36:12
 * @parameter 
 * @return
 */
public class RoleEntity {

	private Integer id;
	
	/**
	 * 角色名称
	 */
	private String name;
	
	/**
	 * 角色代码
	 */
	private Integer code;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
