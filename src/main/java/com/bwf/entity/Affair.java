package com.bwf.entity;

import java.util.List;

public class Affair {
	private Integer affairId;
	private Integer affairModuleId;
	private String affairData;
	private Integer proposerId;
	private Integer affairStatus;
	private User proposer;
	private List<AffairChain> affairChains;
	private AffairModule affairModule;
	public Integer getAffairId() {
		return affairId;
	}
	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}
	public Integer getAffairModuleId() {
		return affairModuleId;
	}
	public void setAffairModuleId(Integer affairModuleId) {
		this.affairModuleId = affairModuleId;
	}
	public String getAffairData() {
		return affairData;
	}
	public void setAffairData(String affairData) {
		this.affairData = affairData;
	}
	public Integer getProposerId() {
		return proposerId;
	}
	public void setProposerId(Integer proposerId) {
		this.proposerId = proposerId;
	}
	public Integer getAffairStatus() {
		return affairStatus;
	}
	public void setAffairStatus(Integer affairStatus) {
		this.affairStatus = affairStatus;
	}
	public User getProposer() {
		return proposer;
	}
	public void setProposer(User proposer) {
		this.proposer = proposer;
	}
	public List<AffairChain> getAffairChains() {
		return affairChains;
	}
	public void setAffairChains(List<AffairChain> affairChains) {
		this.affairChains = affairChains;
	}
	public AffairModule getAffairModule() {
		return affairModule;
	}
	public void setAffairModule(AffairModule affairModule) {
		this.affairModule = affairModule;
	}
	@Override
	public String toString() {
		return "Affair [affairId=" + affairId + ", affairModuleId=" + affairModuleId + ", affairData=" + affairData
				+ ", proposerId=" + proposerId + ", affairStatus=" + affairStatus + ", proposer=" + proposer
				+ ", affairChains=" + affairChains + ", affairModule=" + affairModule + "]";
	}
	
	
	
}
