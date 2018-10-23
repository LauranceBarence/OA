package com.bwf.entity;


public class SenderAndReciver {
	
	private Integer id;
	private Integer messageId;
	private Integer senderId;
	private Integer reciverId;
	private Integer status;
	
	private Message message;
	private User user;
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	@Override
	public String toString() {
		return "SenderAndReciver [id=" + id + ", messageId=" + messageId + ", senderId=" + senderId + ", reciverId="
				+ reciverId + ", status=" + status + ", message=" + message + ", user=" + user + "]";
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
