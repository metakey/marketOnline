package com.netease.marketOnline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.marketOnline.dao.ProductDAO;
import com.netease.marketOnline.dao.TrxDAO;
import com.netease.marketOnline.meta.BuyingRecord;
import com.netease.marketOnline.meta.ProductBuyed;
import com.netease.marketOnline.meta.Trx;
import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.service.TrxService;

@Service
public class TrxServiceImpl implements TrxService{

	@Autowired
	private TrxDAO trxDAO;
	@Autowired
	private ProductDAO productDAO;
	
	public boolean judgeBuyed(int userId, int productId) {
		List<Trx> trxList = trxDAO.getTrxBuyed(userId, productId);
		if (trxList.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean judgeSold(int productId) {
		List<Trx> trxList = trxDAO.getTrxOfProduct(productId);
		if (trxList.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}

	public boolean buyProducts(User user, List<ProductBuyed> buyList) {
		int result;
		for (ProductBuyed product : buyList){
			Trx trx = new Trx();
			trx.setPersonId(user.getId());
			trx.setContentId(product.getId());
			trx.setNum(product.getNumber());
			trx.setPrice(productDAO.getProductPrice(product.getId()));
			trx.setTime(System.currentTimeMillis());//添加交易时间
			result=trxDAO.insertTrx(trx);
			if (result == 0) {//此处应使用事务？
				return false;
			}
			System.out.println(trx.getId());
		}
		return true;
	}

	public List<BuyingRecord> getBuyList(int userId) {
		List<BuyingRecord> buyList = null;
		buyList = trxDAO.getBuyList(userId);
 		return buyList;
	}

}
