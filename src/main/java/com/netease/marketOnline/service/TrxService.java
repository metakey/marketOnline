package com.netease.marketOnline.service;

import java.util.List;

import com.netease.marketOnline.meta.BuyingRecord;
import com.netease.marketOnline.meta.ProductBuyed;
import com.netease.marketOnline.meta.User;


public interface TrxService {

	public boolean judgeBuyed(int userId,int productId);
	public boolean judgeSold(int productId);
	public boolean buyProducts(User user, List<ProductBuyed> buyList);
	public List<BuyingRecord> getBuyList(int userId);

}
