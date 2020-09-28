package org.zerock.test;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReplyMapper remapper;

	@Test
	public void create() throws Exception {

			for (int j = 0; j < 55; j++) {

				ReplyVO vo = new ReplyVO();
				vo.setBno(2);
				vo.setReplytext("´ñ±Û³»¿ë" + j);
				vo.setReplyer("´ñ±Û¾´»ç¶÷" + j);

				remapper.create(vo);
			}

	}
//	
//	@Test
//	public void listTest() throws Exception{
//		Criteria cri = new Criteria();
//		cri.setPageNum(1);
//		cri.setAmount(10);
//		Integer bno = 2;
//		System.out.println(bno+""+cri);
//		remapper.list(bno,cri).forEach(board->logger.info(""+board));
//	}

//	@Test
//	public void testListPage() throws Exception{
//		Criteria cri =new Criteria();
//		cri.setPageNum(1);
//		cri.setAmount(10);
//		bomapper.listPage(cri).forEach(board->logger.info(""+board));
//	}

//	@Test
//	public void list() throws Exception{
//	ReplyVO vo = new ReplyVO();
//	vo.setRno(16);
//	vo.setReplytext("´ñ±Û¼öÁ¤³»¿ë");
//
//	remapper.update(vo);
//	}

//	@Test
//	public void list() throws Exception{
//	ReplyVO vo = new ReplyVO();
//	vo.setRno(16);
//
//	remapper.delete(vo);
//	}
//	
//	

}
