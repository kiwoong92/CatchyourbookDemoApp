package com.catchyourbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.DTO.UniUniversity;
import com.catchyourbook.Repository.UniUniversityMapper;

@Service("UniUniversityService")
public class UniUniverysityService {
	@Autowired
	UniUniversityMapper uniUniversityMapper;
	
	public List<UniUniversity> getAllUniversityList() {
		return uniUniversityMapper.getAllUniversityList();
	}
	
}
