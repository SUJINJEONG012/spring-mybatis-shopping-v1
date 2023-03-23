package com.mybatis.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.mybatis.shopping.model.MemberVo;

public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		MemberVo lvo = (MemberVo) session.getAttribute("member");
		if(lvo == null || lvo.getAdminCk() == 0) {
			response.sendRedirect("/");
			return false;
		}
		
		return true; //관리자 계정인 경우 true
	}
	
}
