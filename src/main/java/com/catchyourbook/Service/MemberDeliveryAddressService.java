package com.catchyourbook.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catchyourbook.DTO.MemberDeliveryAddress;
import com.catchyourbook.Repository.MemberDeliveryAddressMapper;


@Service("MemberDeliveryAddressService")
public class MemberDeliveryAddressService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDeliveryAddressService.class); 
	
	@Autowired
	MemberDeliveryAddressMapper memberDeliveryAddressMapper;
	
	public void addMemberDeliveryAddress(MemberDeliveryAddress memberDeliveryAddress) {
		Integer maxVal = memberDeliveryAddressMapper.getMaxAddressNo(memberDeliveryAddress.getMemberNo());
		
		if (maxVal == null) {
			maxVal = new Integer(0);
		}
		
		memberDeliveryAddress.setAddressNo(maxVal + 1);
		
		//save
		memberDeliveryAddressMapper.addMemberDeliveryAddress(memberDeliveryAddress);
	}
	
	public List<MemberDeliveryAddress> getMemberDeliveryAddressesByMemberNo(int memberNo) {
		
		return null;
	}
	
	public MemberDeliveryAddress getMemberDeliveryAddress(int memberNo, int addressNo) {
		return memberDeliveryAddressMapper.getMemberDeliveryAddress(memberNo, addressNo);
	}
	
	public List<MemberDeliveryAddress> getAllMemberDeliveryAddress (int memberNo) {
		return memberDeliveryAddressMapper.getAllMemberDeliveryAddress(memberNo);
	}
	
	public void deleteAllMemberDeliveryAddress (int memberNo) {
		memberDeliveryAddressMapper.deleteAllMemberDeliveryAddress(memberNo);
	}
}
