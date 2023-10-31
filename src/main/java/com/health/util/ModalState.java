package com.health.util;

public class ModalState {
	private String state;
	private String title;
	private String content;
	private String button1;
	private String button2=null;
	
	
	public ModalState() {
		
	}
	
	public ModalState(String state, String content) {  //info 용 
		this.state = state;
		this.content = content;
		this.button1 = "확인";
	}
	public ModalState(String state, String title, String content, String button1) {  
		this.state = state;
		this.title = title;
		this.content = content;
		this.button1 = button1;
	}
	public ModalState(String state, String title, String content, String button1, String button2) { //선택용
		this.state = state;
		this.title = title;
		this.content = content;
		this.button1 = button1;
		this.button2 = button2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getButton1() {
		return button1;
	}
	public void setButton1(String button1) {
		this.button1 = button1;
	}
	public String getButton2() {
		return button2;
	}
	public void setButton2(String button2) {
		this.button2 = button2;
	}
	
	
}
	
