package com.catchyourbook.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.DTO.BookRecommend;
import com.catchyourbook.Repository.BookRecommendMapper;

import ch.qos.logback.classic.Logger;

@Service("BookRecommendService")
public class BookRecommendService {
	@Autowired
	BookRecommendMapper bookRecommendMapper;
	public List<BookRecommend> getBookRecommendsByPaging(int page) {
		
		int offset = (page - 1) * 20; 
		
		return bookRecommendMapper.getBookRecommendsByPaging(offset,  20);
	}
	
	public void addBookRecommends(BookRecommend bookRecommend) {
		
		System.out.println("title    : " + bookRecommend.getTitle());
		System.out.println("memberNo : " + bookRecommend.getMemberNo());
		System.out.println("bookName : " + bookRecommend.getBookName());
		System.out.println("classId  : " + bookRecommend.getClassId());
		
		bookRecommend.setInsDt(LocalDateTime.now());
		bookRecommendMapper.addBookRecommends(bookRecommend);
	}
}
