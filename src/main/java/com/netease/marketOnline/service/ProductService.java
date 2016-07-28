package com.netease.marketOnline.service;

import java.util.List;

import com.netease.marketOnline.meta.Product;
import com.netease.marketOnline.meta.User;

public interface ProductService {
	
	public boolean insertProduct(Product product);
	public boolean deleteProduct(int id);
	public boolean updateProduct(Product product);
	public Product getProduct(User user,int productid);
	public Product getProductById(int id);
	public List<Product> getAllProducts();
}
