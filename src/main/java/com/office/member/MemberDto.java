package com.office.member;

public class MemberDto {
	
private int	memNo;
private String	memId;
private String	memPw;		
private String	memMail;
private String	memPhone;	
private String	memRegData;
private String 	memModDate;


public MemberDto() {

}


public MemberDto(int memNo, String memId, String memPw, String memMail, String memPhone,
		String memRegData,
		String memModDate) {

	this.memNo = memNo;
	this.memId = memId;
	this.memPw = memPw;
	this.memMail = memMail;
	this.memPhone = memPhone;
	this.memRegData = memRegData;
	this.memModDate = memModDate;
}

public MemberDto( String memId, String memPw, String memMail, String memPhone) {
	
	this.memId = memId;
	this.memPw = memPw;
	this.memMail = memMail;
	this.memPhone = memPhone;
	
}


public int getMemNo() {
	return memNo;
}


public void setMemNo(int memNo) {
	this.memNo = memNo;
}


public String getMemId() {
	return memId;
}


public void setMemId(String memId) {
	this.memId = memId;
}


public String getMemPw() {
	return memPw;
}


public void setMemPw(String memPw) {
	this.memPw = memPw;
}


public String getMemMail() {
	return memMail;
}


public void setMemMail(String memMail) {
	this.memMail = memMail;
}


public String getMemPhone() {
	return memPhone;
}


public void setMemPhone(String memPhone) {
	this.memPhone = memPhone;
}


public String getMemRegData() {
	return memRegData;
}


public void setMemRegData(String memRegData) {
	this.memRegData = memRegData;
}


public String getMemModDate() {
	return memModDate;
}


public void setMemModDate(String memModDate) {
	this.memModDate = memModDate;
}

}
