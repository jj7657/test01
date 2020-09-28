package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.domain.replyPageVO;

public interface ReplyService {
	
	public replyPageVO list(Integer bno,Criteria cri)throws Exception;

	
	public void create(ReplyVO vo) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;
	
	public int getCountByBno(Integer bno) throws Exception;
}
