package com.bwf.entity;

public class Attendence {
	private Integer attendenceId;
	private Integer userId;
	private String signTime;
	
	@Override
	public String toString() {
		return "Attendence [attendenceId=" + attendenceId + ", userId=" + userId + ", signTime=" + signTime
				+  "]";
	}
	public Integer getAttendenceId() {
		return attendenceId;
	}
	public void setAttendenceId(Integer attendenceId) {
		this.attendenceId = attendenceId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getSignTime() {
		return signTime;
	}
	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}
	
}
