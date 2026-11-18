package com.office.member;

public interface IMemberDao {
	
	public boolean isMember(String memId);
	
	public int insertNerMember(MemberDto memberDto);
	
	public MemberDto selectmemberByMemId(String memId);

}
