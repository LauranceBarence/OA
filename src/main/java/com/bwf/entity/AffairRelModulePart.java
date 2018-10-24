package com.bwf.entity;

public class AffairRelModulePart {
	private Integer modulePartId;
	
	private Integer moduleId;
	
	private Integer partId;
	
	private Integer order;
	
	private String partName;
	
	private String partData;
	public Integer getModulePartId() {
		return modulePartId;
	}

	public void setModulePartId(Integer modulePartId) {
		this.modulePartId = modulePartId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartData() {
		return partData;
	}

	public void setPartData(String partData) {
		this.partData = partData;
	}

	@Override
	public String toString() {
		return "AffairRelModulePart [modulePartId=" + modulePartId + ", moduleId=" + moduleId + ", partId=" + partId
				+ ", order=" + order + ", partName=" + partName + ", partData=" + partData + "]";
	}

	
	
	
}
