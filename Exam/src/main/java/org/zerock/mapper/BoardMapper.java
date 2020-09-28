package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	public void create(BoardVO vo);
	
	public BoardVO read(BoardVO vo) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public void delete(BoardVO vo) throws Exception;
	
	//∆‰¿Ã¬° §§§§
	public List<BoardVO> listAll(Criteria cri) throws Exception;
	
	//∆‰¿Ã¬° §∑§∑
	public List<BoardVO> listPage(Criteria cri) throws Exception;
	
	public int getTotalCount(Criteria cri) throws Exception;
	
	public void listCount(BoardVO vo) throws Exception; 
	
	
}
