package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BoardAttachMapper attachmapper;
	
	@Transactional
	@Override
	public void crete(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.create(vo);
		
		System.out.println("====create-bno===="+vo.getBno());
		System.out.println(vo.getAttachList());
		vo.getAttachList().forEach(attach->{
			attach.setBno(vo.getBno());
			System.out.println(attach+"-=="+vo.getBno());
			attachmapper.insert(attach);
		});
	}
	
	@Transactional
	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.listCount(vo);
		System.out.println("============viewcnt");
		return mapper.read(vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(vo);
	}
	
	@Transactional
	@Override
	public void delete(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		mapper.delete(vo);
	}

	@Override
	public List<BoardVO> listAll(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return mapper.listAll(cri);
	}

	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return mapper.listPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}
	@Override
	public List<BoardAttachVO> getAttachList(int bno) throws Exception {
		
		return attachmapper.select(bno);
	}

	
}
