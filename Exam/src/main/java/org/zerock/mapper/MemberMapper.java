package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.MemberVO;

public interface MemberMapper {

	public String readTime() throws Exception;
	// ȸ������

	public void createMember(MemberVO vo) throws Exception;
	// ȸ������

	public MemberVO memberRead(MemberVO vo)throws Exception;

	public List<MemberVO> memberList()throws Exception;

	public void updateMember(MemberVO vo)throws Exception;
	
	public void deleteMember(MemberVO vo)throws Exception;


	public MemberVO memberRead(String userid) throws Exception;

	public MemberVO readMember(String userid) throws Exception;

	public MemberVO readWithPW(String userid, String userpw) throws Exception;
	
	public MemberVO login(MemberVO vo)throws Exception;

	public String idCheck(MemberVO vo) throws Exception;
	
	
}
