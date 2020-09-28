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
//		session�� �α��� ������ ������ - �α��� ���� �ʾ�����;
		HttpSession session = request.getSession();
//		�۾��� ������ �������� �α��� ȭ������ �������� �̵�
		if(session.getAttribute("login")==null) {
			response.sendRedirect("/Exam/member/login");
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
