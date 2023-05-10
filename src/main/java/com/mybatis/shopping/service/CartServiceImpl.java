package com.mybatis.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.CartMapper;
import com.mybatis.shopping.model.CartDto;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	 
	@Override
	public int addCart(CartDto cart) {
		// 장바구니 데이터 체크 
		CartDto checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		//장바구니 등록 & 에러시 0 반환 
		try {
			return cartMapper.addCart(cart);
		}catch(Exception e) {
			return 0;
		}
		
	}


}


