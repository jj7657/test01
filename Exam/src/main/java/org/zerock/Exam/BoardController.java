package org.zerock.Exam;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.pageDTO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
//@RequestMapping(value="register" method = RequestMethod.GET)
//@RequestMapping(value="register" method = RequestMethod.POST)

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardService service;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		logger.info("register get......");
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, RedirectAttributes ra) throws Exception {
		System.out.println(vo);
		service.crete(vo);

//		model.addAttribute("result","글등록 success<br>"+vo); 
		ra.addFlashAttribute("result", "글등록 success\\n"+vo);
		return "redirect:/board/list";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void listGet(Model model,Criteria cri) throws Exception {
		
	
		model.addAttribute("list", service.listPage(cri));		
		model.addAttribute("pageMaker", new pageDTO(cri, service.getTotalCount(cri)));		
		logger.info("list get....\n"+cri+"===========================");
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public void readGet(BoardVO vo, Model model, @ModelAttribute("cri")Criteria cri) throws Exception {
//		service.listCount(vo);
		model.addAttribute("read", service.read(vo));
		logger.info("read get....\n" + vo +"\n"+cri);
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyGet(BoardVO vo, Model model,@ModelAttribute("cri")Criteria cri) throws Exception {
		model.addAttribute("modify", service.read(vo));
		logger.info("modify get....\n" + vo);
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO vo, RedirectAttributes ra, Criteria cri) throws Exception {
		logger.info("modify post....\n" + vo);
		service.update(vo);
		ra.addAttribute("pageNum",cri.getPageNum());
		ra.addFlashAttribute("result", "글수정 success\\n" + vo);
//		return "redirect:/board/list?pageNum="+cri.getPageNum();
		return "redirect:/board/list";
	}

	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String removePost(BoardVO vo, RedirectAttributes ra, Criteria cri) throws Exception {
		logger.info("remove post....\n" + vo);
		service.delete(vo);
		ra.addAttribute("pageNum",cri.getPageNum());
		ra.addFlashAttribute("result", "글삭제 success\\n" + vo);
		return "redirect:/board/list";
	}
	@RequestMapping(value="getAttachList", method=RequestMethod.GET)
	public ResponseEntity<List<BoardAttachVO>> getAttachList(int bno) throws Exception {
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}

}
