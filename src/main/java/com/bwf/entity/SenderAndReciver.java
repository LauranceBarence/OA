package com.bwf.entity;

import java.util.List;

public class SenderAndReciver {
	
	private Integer id;
	private Integer messageId;
	private Integer senderId;
	private Integer reciverId;
	
	private List<Message> messages;
	private List<User> users;
	
	@Override
	public String toString() {
		return "SenderAndReciver [id=" + id + ", messageId=" + messageId + ", senderId=" + senderId + ", reciverId="
				+ reciverId + ", messages=" + messages + ", users=" + users + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public Integer getReciverId() {
		return reciverId;
	}
	public void setReciverId(Integer reciverId) {
		this.reciverId = reciverId;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
		
}
