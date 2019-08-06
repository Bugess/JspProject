package com.dzkj.entity;

public class VoteSingle {
	private String id;
    private String title;
    private String num;
    
	public VoteSingle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VoteSingle(String title, String num) {
		super();
		this.title = title;
		this.num = num;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
