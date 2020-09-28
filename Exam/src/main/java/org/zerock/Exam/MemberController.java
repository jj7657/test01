package org.zerock.Exam;

import java.util.ArrayList;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MemberService meservice;

	@RequestMapping(value = "member", method = RequestMethod.GET)
	public void memberGet() throws Exception {
		System.out.println("ȸ������ ��");

	}

	@RequestMapping(value = "member", method = RequestMethod.POST)
	public void memberPost(MemberVO vo) throws Exception {
		System.out.println("ȸ������ ó��");
		meservice.createMember(vo);
	}

	@RequestMapping(value = "checkId/{userid}", method = RequestMethod.GET,produces="application/JSON;charset=utf-8")
	public  ResponseEntity<String> checkId(@PathVariable("userid") String userid) throws Exception {
		System.out.println("���̵� Ȯ�� StringŸ��");
		
//		List<String> list = new ArrayList<String>();
//		list.add("sss");
//		ResponseEntity<String> entity = null;
//		try {
//			entity= new ResponseEntity<String>("success",HttpStatus.OK);
//		} catch (Exception e) {
//			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
//			e.printStackTrace();
//		}
//		return entity;
		return new ResponseEntity<>("sss" , HttpStatus.OK);
	}
//	@RequestMapping(value = "checkId/{userid}", method = RequestMethod.GET)
//	public ResponseEntity<String> checkId(@PathVariable("userid") String userid) throws Exception {
//		MemberVO vo = new MemberVO();
//		vo.setUserid(userid);
//		System.out.println("���̵� üũ" + userid + "    " + vo + " \n" + meservice.idCheck(vo));
//			return new ResponseEntity<>(meservice.idCheck(vo), HttpStatus.OK);			
//	}
//	@RequestMapping(value = "checkId/{userid}", method = RequestMethod.GET)
//	public ResponseEntity<Integer> checkId(@PathVariable("userid") String userid) throws Exception {
//		MemberVO vo = new MemberVO();
//		vo.setUserid(userid);
//		System.out.println("���̵� üũ" + userid + "    " + vo + " \n" + meservice.idCheck(vo));
//		String result = meservice.idCheck(vo);
//		ResponseEntity<Integer> entity = null;
//		if (result == null) {
//			result = "null";
//			entity = new ResponseEntity<>(0, HttpStatus.OK);
//		} else {
//			entity = new ResponseEntity<>(1, HttpStatus.OK);
//		}
//		return entity;
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGet() throws Exception {
		System.out.println("login info");

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPost(MemberVO member, Model model /* ,HttpServletRequest request */ ) throws Exception {
		System.out.println("login post info");
		MemberVO vo = meservice.login(member);
		if (vo == null) {
			return;
		}
		;
		// ���ͼ��� ���ҋ� ���� ó����
		// HttpServletRequest request ����������
		// �ٷ� �Ʒ� ���� �� �߰� ���ָ��
//		HttpSession session= request.getSession();
//		session.setAttribute("login", vo);

		model.addAttribute("userVO", vo);
	}
//	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
//	public String loginPost(MemberVO member, Model model, HttpServletRequest request) throws Exception {
//		HttpSession session = request.getSession();
//		System.out.println("login post info");
//		
//		MemberVO vo = meservice.login(member);
//		if (vo != null) {
//			session.setAttribute("login", vo);
//			model.addAttribute("userVO",vo);
//			return "redirect:/";
//		} else {
//			return "redirect:/Exam/member/login";
//		}
//
//	}

}
