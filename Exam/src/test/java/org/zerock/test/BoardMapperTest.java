package org.zerock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BoardMapper bomapper;

//	@Test
//	public void testSearch() throws Exception {
//		Criteria cri = new Criteria();
//		cri.setKeyword("80");
//		cri.setType("t");
//		bomapper.listPage(cri).forEach(board -> logger.info("" + board));
//	}

//	@Test
//	public void testListPage() throws Exception{
//		Criteria cri =new Criteria();
//		cri.setPageNum(1);
//		cri.setAmount(10);
//		bomapper.listPage(cri).forEach(board->logger.info(""+board));
//	}

//	@Test
//	public void testCreat() {
//		for (int i =0; i < 120; i++) {
//			BoardVO board = new BoardVO();
//			board.setTitle("자동생성 제목"+(i));
//			board.setContent("내용"+(i));
//			board.setWriter("작성자"+(i));
//			
//			bomapper.create(board);			
//		}
//	}
	@Test
	public void testRead()throws Exception  {
		BoardVO board = new BoardVO();
		board.setBno(1);
		
		bomapper.read(board);
	}
//	
//	
//	@Test
//	public void testUpdate() throws Exception {
//		BoardVO board = new BoardVO();
//		board.setTitle("제목수정");
//		board.setContent("내용수정");
//		board.setBno(1);
//		
//		bomapper.update(board);
//	}
//	@Test
//	public void testDelete() throws Exception{
//		BoardVO board = new BoardVO();
//		board.setBno(1);
//		
//		bomapper.delete(board);
//	}
//	@Test
//	public void testList() throws Exception{
//		bomapper.listAll().forEach(board->logger.info(""+board));
//	}
//	

}
