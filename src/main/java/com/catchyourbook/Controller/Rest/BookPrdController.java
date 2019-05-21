package com.catchyourbook.Controller.Rest;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catchyourbook.DTO.BookPrd;
import com.catchyourbook.Service.BookPrdService;

@RestController
public class BookPrdController {

	private static final Logger logger = LoggerFactory.getLogger(BookPrdController.class); 

	@Resource(name="BookPrdService")
	BookPrdService bookPrdService;
	
	@GetMapping(value="/rest/book/{bookId}")
	public BookPrd getBookPrd(@PathVariable("bookId") String bookId) {
		logger.info( "####ENTERED  get restAPI method !!!");
		return bookPrdService.getBookPrd(bookId);
	}
	
 }
