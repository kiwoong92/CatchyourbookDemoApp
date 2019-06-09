package com.catchyourbook.Controller.Rest;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catchyourbook.DTO.MemberInfo;
import com.catchyourbook.Service.UniClassGroupService;

@RestController
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class); 

	@Resource(name="UniClassGroupService")
	UniClassGroupService uniClassGroupService;
	
	@PostMapping(value="/member/add") 
	Map<String,Object> addMember (@RequestBody Map<String, Object> memberInfo) {
		
		
		return null;
	}
	
 }
