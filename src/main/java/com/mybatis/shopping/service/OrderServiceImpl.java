package com.mybatis.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.OrderMapper;
import com.mybatis.shopping.model.OrderPageItemDto;

@Service
public class OrderServiceImpl implements OrderService {
 
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<OrderPageItemDto> getGoodsInfo(List<OrderPageItemDto> orders) {
		
		List<OrderPageItemDto> result = new ArrayList<OrderPageItemDto>();
		
		for(OrderPageItemDto ord : orders) {
			
			OrderPageItemDto goodsInfo = orderMapper.getGoodsInfo(ord.getBookId());
			
			goodsInfo.setBookCount(ord.getBookCount());
			
			goodsInfo.initSaleTotal();
			
			result.add(goodsInfo);
			System.out.println("ggg@@@@@ : " +goodsInfo);
			
		}
		return result;
	}
}
