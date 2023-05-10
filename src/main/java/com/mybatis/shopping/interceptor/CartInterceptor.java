package com.mybatis.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.mybatis.shopping.model.MemberVo;

public class CartInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//로그인 여부 확인 메서드 
		HttpSession session = request.getSession();
		MemberVo mvo =  (MemberVo) session.getAttribute("member");
		if(mvo == null) {
			response.sendRedirect("/member/login");
			return false;
		}else {
			return true;
		}

	}

	
}
