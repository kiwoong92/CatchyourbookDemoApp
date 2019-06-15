package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.catchyourbook.DTO.MemberCart;
import com.catchyourbook.DTO.MemberInfo;;

@Repository
@Mapper
public interface MemberMapper {
	
	MemberInfo checkMemberByMemberIdAndMemberPw(@Param("memberId")String memberId, @Param("memberPw")String memberPw);
	MemberInfo checkMemberByMemberId(@Param("memberId") String memberId);
	void addMemberInfo(@Param("memberInfo")MemberInfo memberInfo);
	void addCart(@Param("m")MemberCart m);
	void updateCartQty(@Param("m")MemberCart m);
	MemberCart checkCart(@Param("bookId") String bookId, @Param("memberNo") Integer memberNo);
	List<MemberCart> getMemberCartByMemberNo(@Param("memberNo")Integer memberNo);
	void deleteAllMemberCartByMemberNo(@Param("memberNo") Integer memberNo);
}	
