package com.catchyourbook.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.catchyourbook.DTO.MemberCart;
import com.catchyourbook.DTO.MemberInfo;
import com.catchyourbook.Repository.MemberMapper;


@Service("MemberService")
public class MemberService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class); 
	
	@Autowired
	MemberMapper memberMapper;
	
	public Map<String, Object> getTopUniClassGroupByUniId(String memberId, String memberPw) {
		//	getTopUniClassGroupByUniId
		MemberInfo result = memberMapper.checkMemberByMemberIdAndMemberPw(memberId, memberPw);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if(result!= null && result.getMemberId() != null) {
			resultMap.put("result", "success");
			result.setMemberPw(null);	//비밀번호는 세션에 저장하지 않음.
			resultMap.put("loginInfo", result);
		} else {
			resultMap.put("result", "failed");
			resultMap.put("reason", "invalid_info");
		}
		
		return resultMap;
	}
	
	public Map<String, Object> addMember(MemberInfo memberInfo) {
		
		logger.info("addMember!!!");
		Map<String, Object> result = new HashMap<String, Object>();
		
		MemberInfo checkMember = memberMapper.checkMemberByMemberId(memberInfo.getMemberId());
		result.put("success", "false");
		
		if (checkMember == null || checkMember.getMemberId() == null) {
			// success
			memberInfo.setMemberState("NORMAL");
			memberInfo.setJoinDt(LocalDateTime.now());
			
			memberMapper.addMemberInfo(memberInfo);
			
			result.put("success", "success");
			
		} 
		
		if (StringUtils.isEmpty(memberInfo.getName())) {
			result.put("name", "empty");
		}
		
		if (StringUtils.isEmpty(memberInfo.getUniversityId())) {
			result.put("universityId", "empty");
		}
		
		
		//TODO : gender radiobox error 해결
//		if (StringUtils.isEmpty(memberInfo.getGender())) {
//			result.put("gender", "empty");
//		}
		
		if (StringUtils.isEmpty(memberInfo.getPhone())) {
			result.put("phone", "empty");
		}
		
		if (StringUtils.isEmpty(memberInfo.getEmail())) {
			result.put("email", "empty");
		}
		
		return result;
	}
	
	public Map<String, Object> addCart(String bookId, Integer memberNo) {
		
		MemberCart check = memberMapper.checkCart(bookId, memberNo);
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put("success", "success");
		
		if (check == null || check.getBookId() == null) {
			MemberCart target = new MemberCart();
			target.setBookId(bookId);
			target.setMemberNo(memberNo);
			target.setCartState("NORMAL");
			target.setQty(1);
			target.setExpiredDate(LocalDateTime.now().plusDays(3));
			
			memberMapper.addCart(target);
		} else {
			check.setQty(check.getQty() + 1);
			memberMapper.updateCartQty(check);
		}
		
		
		return result;
	}
	
	public List<MemberCart> getMemberCartByMemberNo(Integer memberNo) {
		return memberMapper.getMemberCartByMemberNo(memberNo);
	}
}
