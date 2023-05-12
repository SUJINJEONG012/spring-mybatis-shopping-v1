package com.mybatis.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.shopping.mapper.AttachMapper;
import com.mybatis.shopping.mapper.BookMapper;
import com.mybatis.shopping.mapper.CartMapper;
import com.mybatis.shopping.model.AttachImageVo;
import com.mybatis.shopping.model.CartDto;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	 
	@Autowired
	private AttachMapper attachMapper;
	
	@Autowired
	private BookMapper bookMapper;
	
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

	/* 장바구니 정보 리스트 */
	@Override
	public List<CartDto> getCartList(String memberId) {
		/* List <CartDTO> 타입의 cart 변수를 선언하고 장바구니 정보를 모두 가져오는
		 * getCart() Mapper 메서드를 호출하여 반환받은 값을 대입
		 * */
		
		
		List<CartDto> cart = cartMapper.getCart(memberId);
		
		/* 
		 *  CartDTO객체의 'salePrice', 'totalPrice', 'point', 'totalPoint' 속성들은 값이 없다.
		 *  따로 initSaleTotal()메서드를 호출해주어야 된다.
		 *  */
		for(CartDto dto : cart) {
			/* 종합정보 초기화 */
			dto.initSaleTotal();
			/* 이미지 정보 얻기 */
			int bookId = dto.getBookId();
			
			List<AttachImageVo> imageList = attachMapper.getAttachList(bookId);
			
			dto.setImageList(imageList);
		}
		//반환해주기
		return cart;
	}

	/* 카트 수량 수정 */
	@Override
	public int modifyCount(CartDto cart) {
		
		return cartMapper.modifyCount(cart);
	}

	/* 카트 삭제 */
	@Override
	public int deleteCart(int cartId) {
		
		return cartMapper.deleteCart(cartId);
	}


}


