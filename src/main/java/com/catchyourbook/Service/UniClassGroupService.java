package com.catchyourbook.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.DTO.BookPrd;
import com.catchyourbook.DTO.UniClassGroup;
import com.catchyourbook.Repository.BookPrdMapper;
import com.catchyourbook.Repository.UniClassGroupMapper;

@Service("UniClassGroupService")
public class UniClassGroupService {
	@Autowired
	UniClassGroupMapper uniClassGroupMapper;
	
//	public List<UniClassGroup> getUniClassGroupByUniId() {
//		return UniClassGroupMapper.getBookPrdList();
//	}
	
	public List<UniClassGroup> getTopUniClassGroupByUniId(String uniId) {
		//	getTopUniClassGroupByUniId
		return uniClassGroupMapper.getTopUniClassGroupByUniId(uniId);
	}
	
	public List<UniClassGroup> getTopUniClassGroupByUpperClassGroupId(String upperClassGroupId) {
		//	getTopUniClassGroupByUniId
		return uniClassGroupMapper.getTopUniClassGroupByUpperClassGroupId(upperClassGroupId);
	}
}
