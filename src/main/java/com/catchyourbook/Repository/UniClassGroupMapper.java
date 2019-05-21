package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.catchyourbook.DTO.UniClassGroup;;

@Mapper
public interface UniClassGroupMapper {
	@Select("SELECT * FROM UNI_CLASS")
	List<UniClassGroup> getUniClassGroupByUniId(@Param("uniId") String uniId);
	
	@Select("SELECT * FROM UNI_CLASS_GROUP WHERE UNI_ID= #{uniId} AND UPPER_CLASS_GROUP_ID is NULL")
	List<UniClassGroup> getTopUniClassGroupByUniId(@Param("uniId") String uniId);
	
	@Select("SELECT * FROM UNI_CLASS_GROUP WHERE UPPER_CLASS_GROUP_ID = #{upperClassGroupId}")
	List<UniClassGroup> getTopUniClassGroupByUpperClassGroupId(@Param("upperClassGroupId") String upperClassGroupId);
}
