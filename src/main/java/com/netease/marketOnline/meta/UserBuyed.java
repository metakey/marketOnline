package com.netease.marketOnline.meta;


public class UserBuyed {
	private int id;
	private String title;
	private String image;
	private int buyPrice;
	private int buyNum;
	private Long buyTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public Long getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Long buyTime) {
		this.buyTime = buyTime;
	}
	
}
