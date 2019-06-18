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
import com.catchyourbook.DTO.MemberDeliveryAddress;
import com.catchyourbook.DTO.MemberInfo;
import com.catchyourbook.Service.MemberDeliveryAddressService;
import com.catchyourbook.Service.MemberService;

@RestController
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class); 

	@Resource(name="MemberService")
	MemberService memberService;
	
	@Resource(name="MemberDeliveryAddressService")
	MemberDeliveryAddressService memberDeliveryAddressService;
	
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
	
	@PostMapping(value="/address/update")
	Map<String, Object> updateMemberDeliveryAddress(@RequestBody MemberDeliveryAddress memberDeliveryAddress, HttpSession session) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		if (memberDeliveryAddress.getAddressNo() <= 0) {
			//새로 등록하는 경우는 addressNo가 세팅되지 않은 채로 넘어오기 때문에 새로 등록하는 로직을 추가.
			MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginInfo");
			//세션에서 현재 로그인한 멤버의 번호를 가져와 세팅
			memberDeliveryAddress.setMemberNo(loginInfo.getMemberNo());

			
			try {
				//등록
				memberDeliveryAddressService.addMemberDeliveryAddress(memberDeliveryAddress);
				
				result.put("success", "success");
			} catch(Exception e) {
				e.printStackTrace();
				result.put("success", "false");
			}
			
			
		} else {
			// 기존의 주소록을 가져오는 경우기 때문에 멤버의 배송지를 변경하는 로직만 추가.
		}
		
		return result;
	}
 }
