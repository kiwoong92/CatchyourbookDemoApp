package com.catchyourbook.DTO;

import java.time.LocalDateTime;

public class MemberCoupon {
	
	private String couponId;
	private int memberNo;
	private LocalDateTime registDt;
	private String couponState;
	
	public String getCouponStateName() {
		return couponStateName;
	}
	public void setCouponStateName(String couponStateName) {
		this.couponStateName = couponStateName;
	}
	/*추가 확장 필드*/
	private BookCoupon bookCoupon;
	private String couponStateName;
	
	public BookCoupon getBookCoupon() {
		return bookCoupon;
	}
	public void setBookCoupon(BookCoupon bookCoupon) {
		this.bookCoupon = bookCoupon;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public LocalDateTime getRegistDt() {
		return registDt;
	}
	public void setRegistDt(LocalDateTime registDt) {
		this.registDt = registDt;
	}
	public String getCouponState() {
		return couponState;
	}
	public void setCouponState(String couponState) {
		this.couponState = couponState;
	}
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
}
