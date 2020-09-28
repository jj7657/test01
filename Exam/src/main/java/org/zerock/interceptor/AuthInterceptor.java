package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		session에 로그인 정보가 없으면 - 로그인 하지 않았으면;
		HttpSession session = request.getSession();
//		글쓰기 권한이 없음으로 로그인 화면으로 페이지로 이동
		if(session.getAttribute("login")==null) {
			response.sendRedirect("/Exam/member/login");
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
