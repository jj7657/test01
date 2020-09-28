package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;


public interface BoardAttachMapper {
	//파일 업로드를 tbl_attach테이블에 insert 한것
	public void insert(BoardAttachVO vo);
	//파일 업로드를 tbl_attach테이블에 delete 한것
	public void delete(BoardVO vo);
	//파일 업로드를 tbl_attach테이블에 select 한것
	public List<BoardAttachVO> select(int bno);

}
