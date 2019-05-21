package com.catchyourbook.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.catchyourbook.DTO.BookPrd;;

@Mapper
public interface BookPrdMapper {
	@Select("SELECT * FROM BOOK_PRD WHERE DISPLAY_YN='Y' AND SALE_STATE_CD='SALE'")
	List<BookPrd> getBookPrdList();
	
	@Select("SELECT * FROM BOOK_PRD WHERE BOOK_ID = #{bookId}")
	BookPrd getBookPrd(@Param("bookId") String bookId);
	
}
