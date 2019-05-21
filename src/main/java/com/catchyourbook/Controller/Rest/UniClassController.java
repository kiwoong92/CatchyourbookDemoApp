package com.catchyourbook.Controller.Rest;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catchyourbook.DTO.UniClass;
import com.catchyourbook.DTO.UniClassGroup;
import com.catchyourbook.DTO.UniClasstime;
import com.catchyourbook.Service.UniClassGroupService;
import com.catchyourbook.Service.UniClassService;

@RestController
public class UniClassController {

	private static final Logger logger = LoggerFactory.getLogger(UniClassController.class); 

	@Resource(name="UniClassGroupService")
	UniClassGroupService uniClassGroupService;
	
	@Resource(name="UniClassService")
	UniClassService uniClassService;
	
	@GetMapping(value="/rest/uniclassgroup/{upperClassGroupId}")
	public List<UniClassGroup> getTopUniClassGroupByUpperClassGroupId(@PathVariable("upperClassGroupId") String upperClassGroupId) {
		logger.info( "####ENTERED  get UNI_CLASS_GROUP restAPI method !!!");
		return uniClassGroupService.getTopUniClassGroupByUpperClassGroupId(upperClassGroupId);
	}
	
	@GetMapping(value="/rest/uniclass/{classGroupId}")
	public List<UniClass> getUniClassByClassGroupId(@PathVariable("classGroupId") String classGroupId) {
		logger.info( "####ENTERED  get UNI_CLASS_GROUP restAPI method !!!");
		return uniClassService.getUniClassByClassGroupId(classGroupId);
	}
	
	@GetMapping(value="/rest/uniclasstime/{classId}")
	public List<UniClasstime> getUniClasstimeByClassId(@PathVariable("classId")String classId) {
		return uniClassService.getUniClasstimeByClassId(classId);
	}
 }
