package org.zerock.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler, ModelAndView modelAndView) throws Exception{
		System.out.println("login post handle....postHandle.......");
		
		HttpSession session = request.getSession();
		
		Object userVO = modelAndView.getModel().get("userVO");
		System.out.println(userVO);
		
		session.setMaxInactiveInterval(60*30);//30분 세션 유지
		
		if (userVO!=null) {
			
			
			
			System.out.println("new login success");
			session.setAttribute("login", userVO);
//			
			if (request.getParameter("useCookie")!=null) {
				
		
			Cookie loginCookie = new Cookie("loginCookie",session.getId());
			loginCookie.setPath("/");
			loginCookie.setMaxAge(60*60*24*7);
			response.addCookie(loginCookie);
			}
			
			
			response.sendRedirect("/Exam");
			return;
		}
		response.sendRedirect("/Exam/member/login");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		System.out.println("login post handle.......preHandle..........=");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login")!=null) {
			System.out.println("기존 로그인 세션 삭제");
			session.removeAttribute("login");
		}
		
		
		return true;
	}
}
