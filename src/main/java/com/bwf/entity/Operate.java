package com.bwf.entity;

public class Operate {
	private Integer operateId;
	private String operateName;
	private String operateAction;
	private String operateUrl;
	private Integer pId;
	public Integer getOperateId() {
		return operateId;
	}
	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getOperateAction() {
		return operateAction;
	}
	public void setOperateAction(String operateAction) {
		this.operateAction = operateAction;
	}
	public String getOperateUrl() {
		return operateUrl;
	}
	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Operate [operateId=" + operateId + ", operateName=" + operateName + ", operateAction=" + operateAction
				+ ", operateUrl=" + operateUrl + ", pId=" + pId + "]";
	}
	
	
}
