package com.netease.marketOnline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.marketOnline.dao.ProductDAO;
import com.netease.marketOnline.meta.Product;
import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.service.ProductService;
import com.netease.marketOnline.service.TrxService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private TrxService trxServiceImpl;

	//增
	public boolean insertProduct(Product product) {
		boolean result = false;
		if (productDAO.insertProduct(product)>0){
			result = true; 
		}
		return result;
	}
	
	//删
	public boolean deleteProduct(int id) {
		boolean result = false;
		if (productDAO.deleteProduct(id)>0) {
			result = true; 
		}
		return result;
	}

	//改
	public boolean updateProduct(Product product) {
		boolean result = false;
		if (productDAO.updateProduct(product)>0){
			result = true; 
		}
		return result;
	}
	
	
	
	//查
	@SuppressWarnings("finally")
	public List<Product> getAllProducts() {
		List<Product> productList = null;
		try {
			productList = productDAO.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return productList;
		}
	}
	
	@SuppressWarnings("finally")
	public Product getProductById(int id) {
		Product product = null;
		try {
			product = productDAO.getProductById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return product;
		}
	}
	
	public Product getProduct(User user, int productid) {
		Product product = null;
		if (user.getUsertype()==0 && trxServiceImpl.judgeBuyed(user.getId(), productid)) {//已购买
			product =  productDAO.getProductForBuyer(user.getId(), productid);
			System.out.println("product="+product);
			product.setBuy(true);
		} else { //用户未购买或用户未登录
			product = getProductById(productid);
		} 
		
		return product;
	}

}
