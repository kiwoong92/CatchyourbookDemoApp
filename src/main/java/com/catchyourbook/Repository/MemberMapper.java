package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.catchyourbook.DTO.BookPrd;;

@Repository
@Mapper
public interface MemberMapper {
	
	Integer checkMemberByMemberIdAndMemberPw(@Param("memberId")String memberId, @Param("memberPw")String memberPw);
}
