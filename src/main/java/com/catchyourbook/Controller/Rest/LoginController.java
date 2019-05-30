package com.catchyourbook.Controller.Rest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catchyourbook.Service.MemberService;

@RestController
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class); 

	@Resource(name="MemberService")
	MemberService memberService;
	
	@PostMapping(value="/login/check")
	public Map<String, String> checkLoginIdAndLoginPw(@RequestBody Map<String, Object> map) {
		logger.info( "####ENTERED  loginCheck !!!");
		logger.info("###### map ? : {}", map);
		Map<String, String> resultMap = new HashMap<String, String>();
		
		if (map.get("loginId") == null || "".equals(map.get("loginId"))) {
			resultMap.put("result", "failed");
			resultMap.put("reason", "empty_id");
			
		} else if (map.get("loginPw") == null || "".equals(map.get("loginPw"))){
			resultMap.put("result", "failed");
			resultMap.put("reason", "empty_pw");
			
		} else {
			resultMap = memberService.getTopUniClassGroupByUniId(map.get("loginId").toString(), map.get("loginPw").toString()); 
		}
		
		return resultMap;
	}
	
 }
