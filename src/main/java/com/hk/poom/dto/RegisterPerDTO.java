package com.hk.poom.dto;

import java.util.Date;

public class RegisterPerDTO {
	
	//타입유형
	int type_m;
	//회원번호
	int mno;
	//아이디	
	String id;
	//비밀번호
	String pwd;
	//이메일
	String email;
	//이름
	String name;
	//주소
	String address;
	//연락처
	int tel;
	//멘트
	String ment;
	//프로필 사진
	String prof;
	//가입일
	Date cre_date_m;
	//수정일
	Date mod_date_m;
	//회원상태
	boolean stmt_m;
	
	//관심 분야
	int fav;
	//애완동물 유무
	boolean pet;
	
	
	// Getter & Setter
	public int getType_m() {
		return type_m;
	}
	public void setType_m(int type_m) {
		this.type_m = type_m;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getMent() {
		return ment;
	}
	public void setMent(String ment) {
		this.ment = ment;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public Date getCre_date_m() {
		return cre_date_m;
	}
	public void setCre_date_m(Date cre_date_m) {
		this.cre_date_m = cre_date_m;
	}
	public Date getMod_date_m() {
		return mod_date_m;
	}
	public void setMod_date_m(Date mod_date_m) {
		this.mod_date_m = mod_date_m;
	}
	public boolean isStmt_m() {
		return stmt_m;
	}
	public void setStmt_m(boolean stmt_m) {
		this.stmt_m = stmt_m;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	public boolean isPet() {
		return pet;
	}
	public void setPet(boolean pet) {
		this.pet = pet;
	}
	
	// toString()
	@Override
	public String toString() {
		return "RegisterPerDTO [type_m=" + type_m + ", mno=" + mno + ", id=" + id + ", pwd=" + pwd + ", email=" + email
				+ ", name=" + name + ", address=" + address + ", tel=" + tel + ", ment=" + ment + ", prof=" + prof
				+ ", cre_date_m=" + cre_date_m + ", mod_date_m=" + mod_date_m + ", stmt_m=" + stmt_m + ", fav=" + fav
				+ ", pet=" + pet + "]";
	}
	
}
