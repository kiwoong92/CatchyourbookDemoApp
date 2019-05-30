package com.catchyourbook.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.Repository.MemberMapper;

@Service("MemberService")
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	public Map<String, String> getTopUniClassGroupByUniId(String memberId, String memberPw) {
		//	getTopUniClassGroupByUniId
		Integer result = memberMapper.checkMemberByMemberIdAndMemberPw(memberId, memberPw);
		
		Map<String, String> resultMap = new HashMap<String, String>();
		
		if(result == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "failed");
			resultMap.put("reason", "invalid_info");
		}
		
		return resultMap;
	}
}
