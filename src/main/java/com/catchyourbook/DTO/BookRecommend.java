package com.catchyourbook.DTO;

import java.time.LocalDateTime;

public class BookRecommend {

	int recommendNo;
	String title;
	String bookName;
	int memberNo;
	LocalDateTime insDt;
	String classId;
	
	String memberName;
	String className;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getRecommendNo() {
		return recommendNo;
	}
	public void setRecommendNo(int recommendNo) {
		this.recommendNo = recommendNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public LocalDateTime getInsDt() {
		return insDt;
	}
	public void setInsDt(LocalDateTime insDt) {
		this.insDt = insDt;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
}
