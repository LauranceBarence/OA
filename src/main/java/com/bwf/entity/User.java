package com.bwf.entity;

public class User {
  @Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", avater=" + avater + "]";
	}
private Integer userId;
  private String username;
  private String password;
  private String nickname;
  private String avater;
  
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

}
