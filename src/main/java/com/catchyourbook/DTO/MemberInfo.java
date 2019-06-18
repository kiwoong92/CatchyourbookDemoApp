package com.catchyourbook.DTO;

import java.time.LocalDateTime;

public class MemberInfo {
	int memberNo;
	String memberId;
	String memberPw;
	String name;
	String universityId;
	String email;
	String gender;
	String majorId;
	LocalDateTime joinDt;
	String memberState;
	String phone;
	int logisticsAddressNo;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public LocalDateTime getJoinDt() {
		return joinDt;
	}
	public void setJoinDt(LocalDateTime joinDt) {
		this.joinDt = joinDt;
	}
	public String getMemberState() {
		return memberState;
	}
	public void setMemberState(String memberState) {
		this.memberState = memberState;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getLogisticsAddressNo() {
		return logisticsAddressNo;
	}
	public void setLogisticsAddressNo(int logisticsAddressNo) {
		this.logisticsAddressNo = logisticsAddressNo;
	}
}
