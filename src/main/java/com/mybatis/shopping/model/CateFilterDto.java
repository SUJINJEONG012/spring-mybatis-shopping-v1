package com.mybatis.shopping.model;


public class CateFilterDto {

	/* 카테고리 이름 */
	private String cateName;
	/* 카테고리 코드 */
	private String cateCode;
	/* 카테고리 상품 수 */
	private int cateCount;
	/* 카테고리 국내,국외 분류*/
	private String cateGroup;
	
	
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
		this.cateGroup = cateCode.split("")[0];
	}
	public int getCateCount() {
		return cateCount;
	}
	public void setCateCount(int cateCount) {
		this.cateCount = cateCount;
	}
	public String getCateGroup() {
		return cateGroup;
	}
	public void setCateGroup(String cateGroup) {
		this.cateGroup = cateGroup;
	}
	
	@Override
	public String toString() {
		return "CateFilterDto [cateName=" + cateName + ", cateCode=" + cateCode + ", cateCount=" + cateCount
				+ ", cateGroup=" + cateGroup + "]";
	}
	
	
	
}
