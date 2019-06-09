package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.catchyourbook.DTO.UniUniversity;;

@Mapper
public interface UniUniversityMapper {
	@Select("SELECT * FROM UNI_UNIVERSITY")
	List<UniUniversity> getAllUniversityList();
}
