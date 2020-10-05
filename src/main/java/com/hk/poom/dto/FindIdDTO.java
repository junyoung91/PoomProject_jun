package com.hk.poom.dto;

public class FindIdDTO {

	//이름
	String name;
	//연락처
	int tel;
	//아이디
	String id;
	
	
	// Getter & Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// toString
	@Override
	public String toString() {
		return "FindIdDTO [name=" + name + ", tel=" + tel + ", id=" + id + "]";
	}
	
}
