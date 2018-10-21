package com.bwf.entity;

import java.util.List;

public class Permission {
	private Integer permissionId;
	private String permissionName;
	private String permissionType;
	private Integer pId;
	private Permission parentPermission;
	private List<Menu> menus;
	private List<Operate> operates;
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionType() {
		return permissionType;
	}
	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	
	public Permission getParentPermission() {
		return parentPermission;
	}
	public void setParentPermission(Permission parentPermission) {
		this.parentPermission = parentPermission;
	}

	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public List<Operate> getOperates() {
		return operates;
	}
	public void setOperates(List<Operate> operates) {
		this.operates = operates;
	}
	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName + ", permissionType="
				+ permissionType + ", pId=" + pId + "]";
	}
	
	
}
