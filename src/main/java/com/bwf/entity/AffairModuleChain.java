package com.bwf.entity;

public class AffairModuleChain {
	private Integer moduleChainId;
	private Integer order;
	private Integer approverId;
	private User approver;
	private Integer moduleId;
	public Integer getModuleChainId() {
		return moduleChainId;
	}
	public void setModuleChainId(Integer moduleChainId) {
		this.moduleChainId = moduleChainId;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getApproverId() {
		return approverId;
	}
	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}
	public User getApprover() {
		return approver;
	}
	public void setApprover(User approver) {
		this.approver = approver;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	@Override
	public String toString() {
		return "AffairModuleChain [moduleChainId=" + moduleChainId + ", order=" + order + ", approverId=" + approverId
				+ ", approver=" + approver + ", moduleId=" + moduleId + "]";
	}
	
	
}
