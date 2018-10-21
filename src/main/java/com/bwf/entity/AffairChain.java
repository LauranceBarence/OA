package com.bwf.entity;

public class AffairChain {
	private Integer affairChainId;
	private Integer affairId;
	private Integer affairChainOrder;
	private Integer affairChainStatus;
	private String affairComment;
	private Integer approverId;
	private User approver;
	public Integer getAffairChainId() {
		return affairChainId;
	}
	public void setAffairChainId(Integer affairChainId) {
		this.affairChainId = affairChainId;
	}
	public Integer getAffairId() {
		return affairId;
	}
	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}
	public Integer getAffairChainOrder() {
		return affairChainOrder;
	}
	public void setAffairChainOrder(Integer affairChainOrder) {
		this.affairChainOrder = affairChainOrder;
	}
	public Integer getAffairChainStatus() {
		return affairChainStatus;
	}
	public void setAffairChainStatus(Integer affairChainStatus) {
		this.affairChainStatus = affairChainStatus;
	}
	public String getAffairComment() {
		return affairComment;
	}
	public void setAffairComment(String affairComment) {
		this.affairComment = affairComment;
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
	@Override
	public String toString() {
		return "AffairChain [affairChainId=" + affairChainId + ", affairId=" + affairId + ", affairChainOrder="
				+ affairChainOrder + ", affairChainStatus=" + affairChainStatus + ", affairComment=" + affairComment
				+ ", approverId=" + approverId + ", approver=" + approver + "]";
	}
	
	
}
