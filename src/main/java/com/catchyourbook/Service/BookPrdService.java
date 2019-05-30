package com.catchyourbook.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.DTO.BookPrd;
import com.catchyourbook.Repository.BookPrdMapper;

@Service("BookPrdService")
public class BookPrdService {
	@Autowired
	BookPrdMapper bookPrdMapper;
	
	public List<BookPrd> getBookPrdList() {
		return bookPrdMapper.getBookPrdList();
	}
	
	public BookPrd getBookPrd(String bookId) {
		return bookPrdMapper.getBookPrd(bookId);
	}
	
	public List<BookPrd> getMatchingList(List<String> bookIds) {
		return bookPrdMapper.getMatchingList(bookIds);
	}
}
