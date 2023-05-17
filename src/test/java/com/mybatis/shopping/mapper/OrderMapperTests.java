package com.mybatis.shopping.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.shopping.model.OrderDto;
import com.mybatis.shopping.model.OrderItemDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class OrderMapperTests {

	@Autowired
	private OrderMapper mapper;
	
	
	/* 상품 정보 (주문처리) */
//	@Test
//	public void getOrderInfoTest() {
//		OrderItemDto orderInfo = mapper.getOrderInfo(61);
//		System.out.println("result : " + orderInfo);
//	}
	
	/* orders 테이블에 등록 */
//	@Test
//	public void enrollOrderTest() {
//		OrderDto ord = new OrderDto();
//		List<OrderItemDto> orders = new ArrayList();
//		
//		OrderItemDto order1 = new OrderItemDto();
//		
//		order1.setBookId(1);
//		order1.setBookCount(5);
//		order1.setBookPrice(70000);
//		order1.setBookDiscount(0.1);
//		order1.initSaleTotal();
//	
//		ord.setOrders(orders);
//		
//		ord.setOrderId("2023_테스트");
//		ord.setAddressee("test");
//		ord.setMemberId("admin");
//		ord.setMemberAddr1("test");
//		ord.setMemberAddr2("test");
//		ord.setMemberAddr3("test");
//		ord.setOrderState("배송준비");
//		ord.getOrderPriceInfo();
//		ord.setUsePoint(1000);
//		
//		mapper.enrollOrder(ord);
//		
//	}
	
	
	/* orderItem 테이블에 등록 */
	@Test
	public void enrollOrderItemTest() {
		
		OrderItemDto oid = new OrderItemDto();
		oid.setOrderId("2023_테스트");
		oid.setBookId(1);
		oid.setBookCount(1);
		oid.setBookPrice(70000);
		oid.setBookDiscount(0.1);
		
		oid.initSaleTotal();
		mapper.enrollOrderItem(oid);
		
	}
	
	
	
}
