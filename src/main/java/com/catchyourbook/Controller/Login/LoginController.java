package com.catchyourbook.Controller.Login;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	public Map<String, Object> checkLoginIdAndLoginPw(@RequestBody Map<String, Object> map, HttpSession session) {
		logger.info( "####ENTERED  loginCheck !!!");
		logger.info("###### map ? : {}", map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if (map.get("loginId") == null || "".equals(map.get("loginId"))) {
			resultMap.put("result", "failed");
			resultMap.put("reason", "empty_id");
			
		} else if (map.get("loginPw") == null || "".equals(map.get("loginPw"))){
			resultMap.put("result", "failed");
			resultMap.put("reason", "empty_pw");
			
		} else {
			resultMap = memberService.getTopUniClassGroupByUniId(map.get("loginId").toString(), map.get("loginPw").toString()); 
			if ("success".equals(resultMap.get("result"))) {
				// 로그인 성공 시, session에 저장.
				session.setAttribute("loginInfo", resultMap.get("loginInfo"));
				logger.info("session ? : {}", session);
			}
		}
		 
		return resultMap;
	}
	
 }
