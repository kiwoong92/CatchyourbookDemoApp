package com.catchyourbook.Controller.Rest;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catchyourbook.DTO.BookRecommend;
import com.catchyourbook.Service.BookRecommendService;

@RestController
public class BookRecommendController {

	private static final Logger logger = LoggerFactory.getLogger(BookRecommendController.class); 

	@Resource(name="BookRecommendService")
	BookRecommendService bookRecommendService;
	
	@PostMapping(value="book/recommend/add")
	public void addBookRecommend (@RequestBody BookRecommend bookRecommend) {
		
		
	}
	
 }
