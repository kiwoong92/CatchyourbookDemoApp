package com.catchyourbook.DTO;

import java.time.LocalDateTime;

public class MemberCart {
	int memberNo;
	String bookId;
	String cartState;
	LocalDateTime expiredDate;
	Integer qty;
	BookPrd bookPrd;
	public BookPrd getBookPrd() {
		return bookPrd;
	}
	public void setBookPrd(BookPrd bookPrd) {
		this.bookPrd = bookPrd;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getCartState() {
		return cartState;
	}
	public void setCartState(String cartState) {
		this.cartState = cartState;
	}
	public LocalDateTime getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(LocalDateTime expiredDate) {
		this.expiredDate = expiredDate;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
