package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.catchyourbook.DTO.UniClass;
import com.catchyourbook.DTO.UniClasstime;;

@Repository
@Mapper
public interface UniClassMapper {
	
	@Select("SELECT * FROM UNI_CLASS")
	List<UniClass> getAllUniClass();
	
//	@Select("SELECT * FROM UNI_CLASS c"
//			+ " LEFT JOIN UNI_CLASSTIME ct ON c.CLASS_ID = ct.CLASS_ID"
//			+ " WHERE CLASS_GROUP_ID= #{classGroupId}")
	public List<UniClass> getUniClassByClassGroupId(@Param("classGroupId") String classGroupId);
	
	@Select("SELECT * FROM UNI_CLASSTIME WHERE CLASS_ID=#{classId}")
	List<UniClasstime> getUniClasstimeByClassId(@Param("classId")String classId);
}
