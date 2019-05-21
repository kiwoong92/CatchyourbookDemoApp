package com.catchyourbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.DTO.UniClass;
import com.catchyourbook.DTO.UniClasstime;
import com.catchyourbook.Repository.UniClassMapper;

@Service("UniClassService")
public class UniClassService {
	@Autowired
	UniClassMapper uniClassMapper;
	
//	public List<UniClassGroup> getUniClassGroupByUniId() {
//		return UniClassGroupMapper.getBookPrdList();
//	}
	
	public List<UniClass> getUniClassByClassGroupId(String classGroupId) {
		//	getTopUniClassGroupByUniId
		return uniClassMapper.getUniClassByClassGroupId(classGroupId);
	}
	
	public List<UniClasstime> getUniClasstimeByClassId(String classId) {
		return uniClassMapper.getUniClasstimeByClassId(classId);
	}
}
