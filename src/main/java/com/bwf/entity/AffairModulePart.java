package com.bwf.entity;

public class AffairModulePart {
	
	private Integer partId;
	private String partName;
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	@Override
	public String toString() {
		return "AffairModulePart [partId=" + partId + ", partName=" + partName + "]";
	}
	
	
}
