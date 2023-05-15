package com.mybatis.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.AttachMapper;
import com.mybatis.shopping.mapper.BookMapper;
import com.mybatis.shopping.mapper.CartMapper;
import com.mybatis.shopping.mapper.MemberMapper;
import com.mybatis.shopping.mapper.OrderMapper;
import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.OrderPageItemDto;

@Service
public class OrderServiceImpl implements OrderService {
 
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private AttachMapper attachMapper;
	
	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private BookMapper bookMapper;
	
	
	@Override
	public List<OrderPageItemDto> getGoodsInfo(List<OrderPageItemDto> orders) {
		
		List<OrderPageItemDto> result = new ArrayList<OrderPageItemDto>();
		
		for(OrderPageItemDto ord : orders) {
			
			OrderPageItemDto goodsInfo = orderMapper.getGoodsInfo(ord.getBookId());
			
			goodsInfo.setBookCount(ord.getBookCount());
			
			goodsInfo.initSaleTotal();
			
			List<AttachImageVo> imageList = attachMapper.getAttachList(goodsInfo.getBookId());
			goodsInfo.setImageList(imageList);
			
			result.add(goodsInfo);
			System.out.println("ggg@@@@@ : " + result);
			
		}
		return result;
	}
}
