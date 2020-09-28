package org.zerock.Exam;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		String str = "안녕하세요 home.jsp 에 오신걸 환영합니다.";
		model.addAttribute("str", str);

		return "home";
	}
	
	@RequestMapping(value="/doA",method=RequestMethod.GET)
	public void doA(Locale local,Model model ) {
		System.out.println("doA................");

	}
	
	@RequestMapping(value="/doB",method=RequestMethod.GET)
	public void doB(Locale local,Model model) {
		System.out.println("doB................");
		model.addAttribute("result","DOB RESULT");
	}
	
}
