package com.catchyourbook.DTO;

import java.math.BigDecimal;

public class BookPrd {
	String bookId;
	String title;
	String author;
	String publisher;
	BigDecimal salePrice;
	BigDecimal dcPrice;
	String imgPath;
	String displayYn;
	String saleStateCd;
	String bookInfo;
	String volum;
	String edition;
	String printing;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public BigDecimal getDcPrice() {
		return dcPrice;
	}
	public void setDcPrice(BigDecimal dcPrice) {
		this.dcPrice = dcPrice;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getDisplayYn() {
		return displayYn;
	}
	public void setDisplayYn(String displayYn) {
		this.displayYn = displayYn;
	}
	public String getSaleStateCd() {
		return saleStateCd;
	}
	public void setSaleStateCd(String saleStateCd) {
		this.saleStateCd = saleStateCd;
	}
	public String getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
	public String getVolum() {
		return volum;
	}
	public void setVolum(String volum) {
		this.volum = volum;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getPrinting() {
		return printing;
	}
	public void setPrinting(String printing) {
		this.printing = printing;
	}

}

