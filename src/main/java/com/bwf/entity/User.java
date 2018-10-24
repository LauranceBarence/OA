package com.bwf.entity;

import java.util.List;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private String nickname;
	private String avater;
	private Integer leaderId;
	private User leader;
	private Integer status;
	private Role role;
	private List<Menu> menus;
	private List<Operate> operates;
	
	
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
		return "User [userId=" + userId + ", username=" + username + ", nickname=" + nickname + ", avater=" + avater
				+ ", leader=" + leader + "]";
	}
	
}
