package com.bwf.entity;

import java.util.List;

public class Department {
	private Integer departmentId;
	private String departmentName;
	private Integer pId;
	private Integer chiefId;
	private User chief;
	private List<User> staff;
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getChiefId() {
		return chiefId;
	}
	public void setChiefId(Integer chiefId) {
		this.chiefId = chiefId;
	}
	public User getChief() {
		return chief;
	}
	public void setChief(User chief) {
		this.chief = chief;
	}
	
	public List<User> getStaff() {
		return staff;
	}
	public void setStaff(List<User> staff) {
		this.staff = staff;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", pId=" + pId
				+ ", chiefId=" + chiefId + ", chief=" + chief + "]";
	}
	
	
}
