package org.zerock.Exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

@Controller
public class SampleController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("doA")
	public String doA() {
		
		logger.info("@RequestMappin doA�� ȣ��Ǿ����ϴ�.");
		
		
		return "do";
	}
	@RequestMapping(value="doW",method = RequestMethod.GET)
	public void doW(@RequestParam("id") String name,@RequestParam("pw") String password) {
		logger.info("doW");
	}
	@RequestMapping(value="doM",method = RequestMethod.GET)
	public String doM(SampleDTO sd) {
		logger.info("doM");
		return "aaa";
	}
	@RequestMapping(value="doD",method = RequestMethod.GET)
	public String doD(SampleDTOList list,Model model) {
		
		logger.info("SampleDTOList"+list);
		logger.info("doD");
		
//		/*model.addAttribute(����,������ ������)*/
		
		model.addAttribute("abc","doD�κ��� ���޹��� ������<br>"+list);
		
		return "bbb";
	}
	@RequestMapping(value="doR",method = RequestMethod.GET)
	public void doR() {
		logger.info("doR");
	}
	@RequestMapping(value="doE")
	public String doE(RedirectAttributes ra) {
		
		logger.info("doE�����");
		ra.addFlashAttribute("msg", "�̰� ��������");
		
		
		return "redirect:/board/doF";
	}
	@RequestMapping("/doF")
	public void doF(String msg) {
		logger.info("doF call  "+msg);
	}
	@RequestMapping(value="doJSON", method= RequestMethod.GET)
	public SampleDTO doJson() {
		SampleDTO dto = new SampleDTO();
		dto.setName("name");
		dto.setName("pw");
		return dto;
	}
	
	
}
