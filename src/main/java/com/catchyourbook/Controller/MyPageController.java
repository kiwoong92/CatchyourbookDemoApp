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
import com.catchyourbook.DTO.MemberCoupon;
import com.catchyourbook.DTO.MemberDeliveryAddress;
import com.catchyourbook.DTO.MemberInfo;
import com.catchyourbook.Service.BookPrdService;
import com.catchyourbook.Service.CouponService;
import com.catchyourbook.Service.MemberDeliveryAddressService;
import com.catchyourbook.Service.MemberService;

@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class); 

	@Resource(name="BookPrdService")
	BookPrdService bookPrdService;
	
	@Resource(name="MemberService")
	MemberService memberService;
	
	@Resource(name="MemberDeliveryAddressService")
	MemberDeliveryAddressService memberDeliveryAddressService;

	@Resource(name="CouponService")
	CouponService couponService;
	
	@RequestMapping(value="/mypage/cart")
	public ModelAndView goMyPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("/main/cart");
		MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginInfo");
		if (loginInfo == null ) {
			mv.setViewName("redirect:/login");
		} else {
			List<MemberCart> cartList 
				= memberService.getMemberCartByMemberNo(loginInfo.getMemberNo());
			
			if (loginInfo.getLogisticsAddressNo() > 0) {
				List<MemberDeliveryAddress> logisticsAddress =  memberDeliveryAddressService.getAllMemberDeliveryAddress(loginInfo.getMemberNo());
				List<MemberCoupon> memberCoupons = couponService.getMemberCouponsByMemberNo(loginInfo.getMemberNo());

				mv.addObject("memberDeliveryAddresses", logisticsAddress);
				mv.addObject("memberCoupons", memberCoupons);
				mv.addObject("cartList", cartList);
			}
		}
		
		return mv;
	}
 }
