package com.dzkj.entity;

public class UserSingle {
	private String id;
    private String ip;
    private long lastTime;
    
	public UserSingle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSingle(String ip, long lastTime) {
		super();
		this.ip = ip;
		this.lastTime = lastTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getLastTime() {
		return lastTime;
	}
	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}
}
