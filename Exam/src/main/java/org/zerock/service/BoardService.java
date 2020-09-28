package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void crete(BoardVO vo) throws Exception; 
	
	public BoardVO read(BoardVO vo)  throws Exception; 
	
	public void update(BoardVO vo) throws Exception; 
	
	public void delete(BoardVO vo) throws Exception; 
	
	public List<BoardVO> listAll(Criteria cri) throws Exception; 
	
	public List<BoardVO> listPage(Criteria cri) throws Exception; 
	
	public int getTotalCount(Criteria cri) throws Exception;
	
	public List<BoardAttachVO> getAttachList(int bno) throws Exception;
	
	
}
