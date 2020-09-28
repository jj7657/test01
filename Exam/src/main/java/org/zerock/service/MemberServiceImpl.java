package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memapper;
	
	@Override
	public MemberVO login(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("¸É¹ö¼­ºñ½º"+member.getUserid());
		
		return  memapper.login(member);
	}

	@Override
	public void createMember(MemberVO vo) throws Exception {
		
		memapper.createMember(vo);
		
	}

	@Override
	public String idCheck(MemberVO vo) throws Exception {
		return memapper.idCheck(vo);
	}

}
