package com.catchyourbook.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.DTO.MemberCoupon;
import com.catchyourbook.Repository.CouponMapper;
import com.catchyourbook.Repository.MemberMapper;


@Service("CouponService")
public class CouponService {
	
	private static final Logger logger = LoggerFactory.getLogger(CouponService.class); 
	
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CouponMapper couponMapper;
	/*
	 * CRUD 
	 * */
	public List<MemberCoupon> getMemberCouponsByMemberNo(int memberNo) {
		
		return couponMapper.getMemberCouponsByMemberNo(memberNo);
	}
	
}
