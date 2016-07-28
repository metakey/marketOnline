package com.netease.marketOnline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.netease.marketOnline.meta.Product;

public interface ProductDAO {
	//增
	@Insert("INSERT INTO content(price,title,icon,abstract,text) "
			+ "VALUES(#{price},#{title},#{image},#{summary},#{detail})")
	@SelectKey(statement = "select last_insert_id() as id", keyProperty = "id", 
				keyColumn = "id", before = false, resultType = Integer.class) 
//	@Options(useGeneratedKeys=true, keyProperty="id")
	public int insertProduct(Product product);
	
	//删
	@Delete("delete from content where id=#{id}")
	public int deleteProduct(int id);
	
	//改
	@Update("update content set price=#{price},title=#{title},icon=#{image},"
			+ "abstract=#{summary}, text=#{detail} where id=#{id}")
	public int updateProduct(Product product);

	//查
	@Results({
		@Result(property = "id", column="id"),
		@Result(property = "title", column="title"),
		@Result(property = "summary", column="abstract"),
		@Result(property = "detail", column="text"),
		@Result(property = "image", column="icon"),
		@Result(property = "price", column="price")//buyprice buynum salenum isbuy issell
		}
	)
	@Select("select * from content where id=#{id}")
	public Product getProductById(int id);
	
	@Results({
//		@Result(property = "id", column="id"),
//		@Result(property = "title", column="title"),
		@Result(property = "summary", column="abstract"),
		@Result(property = "detail", column="text"),
		@Result(property = "image", column="icon"),
//		@Result(property = "price", column="price")
		}
	)
	@Select("select * from content")
	public List<Product> getAllProducts();
	
	@Select("select c.id, title, abstract, text, icon, c.price, t.price as buyPrice, num"
			+ " from content c left join trx t on c.id=t.contentId where personId=#{userId} and contentId=#{productId}")
	@Results({
		@Result(property="summary", column="abstract"),
		@Result(property="detail", column="text"),
		@Result(property="image", column="icon"),
		@Result(property="price", column="price"),
		@Result(property="buyPrice", column="buyPrice"),
		@Result(property="buyNum",column="num")
		}
	)
	public Product getProductForBuyer(@Param("userId")int userId, @Param("productId")int productId);
	
	@Select("select price from content where id=#{productId}")
	public long getProductPrice(int productId);
	
}
