package com.netease.marketOnline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.netease.marketOnline.meta.Product;

public interface ProductDAO {
	@Select("select * from content where id=#{id}")
	public List<Product> getProductById(int id);
}
