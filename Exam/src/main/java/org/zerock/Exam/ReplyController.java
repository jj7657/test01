package org.zerock.Exam;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.domain.pageDTO;
import org.zerock.domain.replyPageVO;
import org.zerock.service.ReplyService;

@RestController
@RequestMapping("replies")
public class ReplyController {
	
	@Autowired
	private ReplyService reservice;
	
	@RequestMapping(value="/all/{bno}/{page}",method=RequestMethod.GET)
	public ResponseEntity<replyPageVO> list(@PathVariable("bno") Integer bno,@PathVariable("page") int page) throws Exception{

		Criteria cri = new Criteria(page, 10);
		
		return new ResponseEntity<replyPageVO>(reservice.list(bno,cri),HttpStatus.OK);
	}
	

	
	@RequestMapping(value="" , method= RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) throws Exception{
		ResponseEntity<String> entity = null;
		try {
			reservice.create(vo);
			entity= new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	
	
	@RequestMapping(value="{rno}" , method= RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("rno") int rno,@RequestBody ReplyVO vo) throws Exception{
		ResponseEntity<String> entity = null;
		try {
			vo.setRno(rno);
			reservice.update(vo);
			System.out.println(vo);
			entity= new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="{rno}" , method= RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno")Integer rno) throws Exception{

		ResponseEntity<String> entity = null;
		try {
			reservice.delete(rno);
			entity= new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
