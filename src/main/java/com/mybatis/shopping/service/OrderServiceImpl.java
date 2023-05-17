package com.mybatis.shopping.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.shopping.mapper.AttachMapper;
import com.mybatis.shopping.mapper.BookMapper;
import com.mybatis.shopping.mapper.CartMapper;
import com.mybatis.shopping.mapper.MemberMapper;
import com.mybatis.shopping.mapper.OrderMapper;
import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.BookVo;
import com.mybatis.shopping.model.CartDto;
import com.mybatis.shopping.model.MemberVo;
import com.mybatis.shopping.model.OrderDto;
import com.mybatis.shopping.model.OrderItemDto;
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


	/* 주문 */
	@Override
	@Transactional
	public void order(OrderDto ord) {
		//주문  정보가 담긴 객체를 세팅 
		
		//1. 회원정보가져오기
		MemberVo memberVo = memberMapper.getMemberInfo(ord.getMemberId());
		
		//2. 주문정보 가져오기
		List<OrderItemDto> ords = new ArrayList<>();
		
		for(OrderItemDto oit : ord.getOrders()) {
			OrderItemDto orderItem = orderMapper.getOrderInfo(oit.getBookId());
			//수량 세팅
			orderItem.setBookCount(oit.getBookCount());
			//기본정보 세팅
			orderItem.initSaleTotal();
			//List 객체
			ords.add(orderItem);
		}
		
		/* OrderDto 세팅 */
		ord.setOrders(ords);
		ord.getOrderPriceInfo();
		
		/* DB 주문, 주문상품, 넣기 */
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
		String orderId = memberVo.getMemberId() + format.format(date);
		ord.setOrderId(orderId);
		
		/* db 넣기 */
		orderMapper.enrollOrder(ord); // orders  등록
		for(OrderItemDto oit : ord.getOrders()) { // orderItem 등록
			oit.setOrderId(orderId);
			orderMapper.enrollOrderItem(oit);
		}
		
		
		/* 비용 포인트 변동 적용 */
		
		/* 비용 차감 & 변동 돈 (money)  Member 객체 적용 */
		int calMoney = memberVo.getMoney();
		calMoney -= ord.getOrderFinalSalePrice();
		memberVo.setMoney(calMoney);
		
		/* 포인트 차감, 포인트 증가  & 변동 포인트 Member객체 적용 */
		int calPoint = memberVo.getPoint();
		calPoint = calPoint - ord.getUsePoint() + ord.getOrderSavePoint();
		memberVo.setPoint(calPoint);
		
		/* 변동 돈, 포인트 DB 적용 */
		orderMapper.deductMoney(memberVo);
		
		/* 재고 변동 적용 */
		for(OrderItemDto oit: ord.getOrders()) {
			/* 변동 재고값 */
			BookVo bookVo = bookMapper.getGoodsInfo(oit.getBookId());
			bookVo.setBookStock(bookVo.getBookStock() - oit.getBookCount());
			/* 변동 값 DB 적용 */
			orderMapper.deductStock(bookVo);
		}
		/* 장바구니 제거 */
		for(OrderItemDto oit : ord.getOrders()) {
			CartDto cartDto = new CartDto();
			cartDto.setMemberId(ord.getMemberId());
			cartDto.setBookId(oit.getBookId());
			cartMapper.deleteOrderCart(cartDto);
		}
		
	
	}
}
