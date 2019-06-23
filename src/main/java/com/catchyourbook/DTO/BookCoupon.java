package com.catchyourbook.DTO;

import java.time.LocalDateTime;

public class BookCoupon {
	
	private String couponId;
	private int dcRate;
	private String name;
	private String detail;
	private LocalDateTime couponStartDt;
	private LocalDateTime couponEndDt;
	private String serial;
	private String overlapYn;
	
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public int getDcRate() {
		return dcRate;
	}
	public void setDcRate(int dcRate) {
		this.dcRate = dcRate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public LocalDateTime getCouponStartDt() {
		return couponStartDt;
	}
	public void setCouponStartDt(LocalDateTime couponStartDt) {
		this.couponStartDt = couponStartDt;
	}
	public LocalDateTime getCouponEndDt() {
		return couponEndDt;
	}
	public void setCouponEndDt(LocalDateTime couponEndDt) {
		this.couponEndDt = couponEndDt;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getOverlapYn() {
		return overlapYn;
	}
	public void setOverlapYn(String overlapYn) {
		this.overlapYn = overlapYn;
	}
}
