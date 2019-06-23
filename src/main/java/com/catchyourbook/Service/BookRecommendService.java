package com.catchyourbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.DTO.BookRecommend;
import com.catchyourbook.Repository.BookRecommendMapper;

@Service("BookRecommendService")
public class BookRecommendService {
	@Autowired
	BookRecommendMapper bookRecommendMapper;
	public List<BookRecommend> getBookRecommendsByPaging(int page) {
		
		int offset = (page - 1) * 20; 
		
		return bookRecommendMapper.getBookRecommendsByPaging(offset,  20);
	}
}
