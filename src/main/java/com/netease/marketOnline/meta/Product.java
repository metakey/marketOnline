package com.netease.marketOnline.meta;

public class Product {
	private int id;			//产品id
	private String title;	//标题
	private String summary;	//摘要
	private String detail;	//全文
	private String image;	//图片地址
	private double price;	//价格
	private double buyPrice;//购买时价格
	private int buyNum;		//购买数量
	private int saleNum;	//销售数量
	private boolean isBuy;	//当前用户是否已经购买
	private boolean isSell; //是否已经卖出
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getIsBuy() {
		return isBuy;
	}
	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	public boolean getIsSell() {
		return isSell;
	}
	public void setSell(boolean isSell) {
		this.isSell = isSell;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
	
}
