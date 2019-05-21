package com.catchyourbook.DTO;

import java.util.List;

public class UniClass {
	String classId;
	String uniId;
	String uniMajorId;
	String name;
	String professorName;
	int gradePoint;
	String semester;
	String classGroupId;
	List<UniClasstime> uniClasstimes;
	
	
	public List<UniClasstime> getUniClasstimes() {
		return uniClasstimes;
	}
	public void setUniClasstimes(List<UniClasstime> uniClasstimes) {
		this.uniClasstimes = uniClasstimes;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getUniId() {
		return uniId;
	}
	public void setUniId(String uniId) {
		this.uniId = uniId;
	}
	public String getUniMajorId() {
		return uniMajorId;
	}
	public void setUniMajorId(String uniMajorId) {
		this.uniMajorId = uniMajorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public int getGradePoint() {
		return gradePoint;
	}
	public void setGradePoint(int gradePoint) {
		this.gradePoint = gradePoint;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getClassGroupId() {
		return classGroupId;
	}
	public void setClassGroupId(String classGroupId) {
		this.classGroupId = classGroupId;
	}
}


/*
 * 
BOOK_ID
TITLE
AUTHOR
PUBLISHER
SALE_PRICE
DC_PRICE
IMG_PATH
INFO
DISPLAY_YN
SALE_STATE_CD
BOOK_INFO
VOLUM
EDITION
PRINTING
 * 
 * 
 * */
