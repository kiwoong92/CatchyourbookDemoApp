package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.catchyourbook.DTO.BookRecommend;;

@Repository
@Mapper
public interface BookRecommendMapper {
	public List<BookRecommend> getBookRecommendsByPaging(@Param("offset")int offset, @Param("limit")int limit);
}
