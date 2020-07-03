package com.study.member.service;

import java.util.List;

import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

public interface IMemberService {
	
	public void registMember(MemberVO member); 
	public void modifyMember(MemberVO member); 
	public void removeMember(MemberVO member); 

	public MemberVO getMember(String memId);
	
	public List<MemberVO> getMemberList(MemberSearchVO searchVO);

	
}
