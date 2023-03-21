package com.mybatis.shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	//@GetMapping("/")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		logger.info("메인페이지 진입 ");
		return "main";
	}

}
