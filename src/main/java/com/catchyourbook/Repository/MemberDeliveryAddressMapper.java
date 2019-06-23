package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.catchyourbook.DTO.MemberDeliveryAddress;;

@Repository
@Mapper
public interface MemberDeliveryAddressMapper {
	
	public void addMemberDeliveryAddress(@Param("a") MemberDeliveryAddress memberDeliveryAddress);
	
	@Select("SELECT * FROM MEMBER_DELIVERY_ADDRESS WHERE MEMBER_NO= #{memberNo}")
	public List<MemberDeliveryAddress> getMemberDeliveryAddressesByMemberNo(@Param("memberNo")int memberNo);
	@Select("SELECT * FROM MEMBER_DELIVERY_ADDRESS WHERE MEMBER_NO = #{memberNo} AND ADDRESS_NO = #{addressNo}")
	public MemberDeliveryAddress getMemberDeliveryAddress(@Param("memberNo") int memberNo, @Param("addressNo")  int addressNo);
	@Select("SELECT * FROM MEMBER_DELIVERY_ADDRESS WHERE MEMBER_NO = #{memberNo}")
	public List<MemberDeliveryAddress> getAllMemberDeliveryAddress (@Param("memberNo") int memberNo);
	
	@Select("SELECT max(ADDRESS_NO) FROM MEMBER_DELIVERY_ADDRESS WHERE MEMBER_NO = #{memberNo}")
	public Integer getMaxAddressNo(@Param("memberNo") int memberNo);
	
	@Delete("DELETE FROM MEMBER_DELIVERY_ADDRESS WHERE MEMBER_NO = #{memberNo}")
	public void deleteAllMemberDeliveryAddress(@Param("memberNo") int memberNo);	
}	
