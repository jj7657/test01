package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;


public interface BoardAttachMapper {
	//���� ���ε带 tbl_attach���̺� insert �Ѱ�
	public void insert(BoardAttachVO vo);
	//���� ���ε带 tbl_attach���̺� delete �Ѱ�
	public void delete(BoardVO vo);
	//���� ���ε带 tbl_attach���̺� select �Ѱ�
	public List<BoardAttachVO> select(int bno);

}
