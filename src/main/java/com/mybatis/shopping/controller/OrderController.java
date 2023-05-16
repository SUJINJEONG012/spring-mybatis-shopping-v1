package com.mybatis.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import com.mybatis.shopping.model.OrderDto;
import com.mybatis.shopping.model.OrderPageDto;
import com.mybatis.shopping.service.MemberService;
import com.mybatis.shopping.service.OrderService;


@Controller
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private  OrderService orderService;

	@Autowired
	private  MemberService memberService;
	
	
	@GetMapping("/order/{memberId}")
	public String orderPageGet(@PathVariable("memberId") String memberId, OrderPageDto opd, Model model) {
		
		System.out.println("memberId : "+ memberId);
		System.out.println("orders : " + opd.getOrders());
		
		model.addAttribute("orderList", orderService.getGoodsInfo(opd.getOrders()));
		model.addAttribute("memberInfo", memberService.getMemberInfo(memberId));
		
		return "/order";
	}
	
	
	@PostMapping("/order")
	public String orderPagePost(OrderDto od, HttpServletRequest request) {
		
		System.out.println(od);		
		logger.info("orderController 적용 여부 ");
		System.out.println("addressee: " + od.getAddressee());
		return "redirect:/";
	
    }
}
