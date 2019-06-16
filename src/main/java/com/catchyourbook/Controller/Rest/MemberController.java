package com.catchyourbook.Controller.Rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catchyourbook.DTO.MemberCart;
import com.catchyourbook.DTO.MemberInfo;
import com.catchyourbook.Service.MemberService;

@RestController
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class); 

	@Resource(name="MemberService")
	MemberService memberService;
	
	@PostMapping(value="/member/add") 
	Map<String,Object> addMember (@RequestBody MemberInfo memberInfo) {
		
		
		return memberService.addMember(memberInfo);
	}
	
	@GetMapping(value="/cart/add/{bookId}") 
	Map<String,Object> addCart (@PathVariable("bookId") String bookId, HttpSession session) {
		
		MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginInfo");
		if (loginInfo == null || loginInfo.getMemberNo() <= 0) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("success", "false");
			
			return result;
		}
		return memberService.addCart(bookId, loginInfo.getMemberNo());
	}
	
	@PostMapping(value="/cart/save")
	Map<String, Object> saveCart (@RequestBody List<MemberCart> memberCarts, HttpSession session) {
		MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginInfo");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", "false");
		if (loginInfo != null && loginInfo.getMemberNo() > 0) {
			memberService.deleteAllMemberCartByMemberNo(loginInfo.getMemberNo());
			try {
				for (MemberCart memberCart : memberCarts) {
					memberService.saveCart(memberCart);
				}
				
				result.put("result", "success");
			} catch (Exception e) {
			}
		}
		return result;
	}
 }
