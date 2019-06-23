package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.catchyourbook.DTO.MemberCoupon;;

@Repository
@Mapper
public interface CouponMapper {
	List<MemberCoupon> getMemberCouponsByMemberNo(@Param("memberNo") int memberNo);
}	
