package com.catchyourbook.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.catchyourbook.DTO.MemberCart;
import com.catchyourbook.DTO.MemberInfo;
import com.catchyourbook.Service.BookPrdService;
import com.catchyourbook.Service.MemberService;
import com.catchyourbook.Service.UniUniverysityService;

@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class); 

	@Resource(name="BookPrdService")
	BookPrdService bookPrdService;
	
	@Resource(name="MemberService")
	MemberService memberService;
	
	@RequestMapping(value="/mypage/cart")
	public ModelAndView goMyPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("/main/cart");
		MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginInfo");
		if (loginInfo == null ) {
			
		} else {
			List<MemberCart> cartList 
				= memberService.getMemberCartByMemberNo(loginInfo.getMemberNo());
			
			mv.addObject("cartList", cartList);
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="popup/address")
	public ModelAndView popupAddress() {
		ModelAndView mv = new ModelAndView("/main/popup/address.popup");
		
		return mv;
	}
 }
