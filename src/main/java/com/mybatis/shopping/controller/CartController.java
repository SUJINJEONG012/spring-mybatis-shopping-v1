package com.mybatis.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.shopping.model.CartDto;
import com.mybatis.shopping.model.MemberVo;
import com.mybatis.shopping.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/add")
	@ResponseBody
	public String addCartPost(CartDto cart, HttpServletRequest request) {
	 //로그인 체크
	 HttpSession session = request.getSession();
	 MemberVo mvo = (MemberVo) session.getAttribute("member");
	 if(mvo== null) {
		 return "5"; //로그인 되지않을  경우 5 반환
	 }
	 
	 //카트 등록
	 int result = cartService.addCart(cart);
	 return result + " ";
	}
	
	
}
