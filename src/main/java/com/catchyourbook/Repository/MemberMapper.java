package com.catchyourbook.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.catchyourbook.DTO.MemberInfo;;

@Repository
@Mapper
public interface MemberMapper {
	
	MemberInfo checkMemberByMemberIdAndMemberPw(@Param("memberId")String memberId, @Param("memberPw")String memberPw);
}
