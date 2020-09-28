package org.zerock.service;


import org.zerock.domain.MemberVO;


public interface MemberService {
	
	public void createMember(MemberVO vo) throws Exception; 
	
	public MemberVO login(MemberVO member) throws Exception;
	
	public String idCheck(MemberVO vo) throws Exception;
}
