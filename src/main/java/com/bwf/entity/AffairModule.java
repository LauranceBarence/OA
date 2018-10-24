package com.bwf.entity;

public class AffairModule {

	
	public Integer moduleId;
	public String moduleName;
	public Integer designerId;
	public User designer;
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public Integer getDesignerId() {
		return designerId;
	}
	public void setDesignerId(Integer designerId) {
		this.designerId = designerId;
	}
	public User getDesigner() {
		return designer;
	}
	public void setDesigner(User designer) {
		this.designer = designer;
	}
	@Override
	public String toString() {
		return "AffairModule [moduleId=" + moduleId + ", moduleName=" + moduleName + ", designerId=" + designerId
				+ ", designer=" + designer + "]";
	}
	
	
}
