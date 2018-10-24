package com.bwf.entity;

import java.util.List;

public class Message {
	
	private Integer messageId;

	private String reciver;
	private String messageTitle;
	private String messageContent;
	private String messageTime;
	private String accessory;
	
	private User user;
	
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", reciver=" + reciver + ", messageTitle=" + messageTitle
				+ ", messageContent=" + messageContent + ", messageTime=" + messageTime + ", accessory=" + accessory
				+ ", users=" + users + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}

	public String getAccessory() {
		return accessory;
	}
	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}
	

}
