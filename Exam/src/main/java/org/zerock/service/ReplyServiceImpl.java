package org.zerock.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.domain.replyPageVO;
import org.zerock.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper remapper;

	@Override
	public replyPageVO list(Integer bno,Criteria cri) throws Exception {
		return new replyPageVO(remapper.list(bno,cri), getCountByBno(bno)) ;
	}


	@Override
	public void create(ReplyVO vo) throws Exception {
		remapper.create(vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		remapper.update(vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		remapper.delete(rno);
	}

	@Override
	public int getCountByBno(Integer bno) throws Exception {
		return remapper.getCountByBno(bno);
	}

}
