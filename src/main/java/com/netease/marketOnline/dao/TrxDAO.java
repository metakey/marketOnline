package com.netease.marketOnline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.netease.marketOnline.meta.BuyingRecord;
import com.netease.marketOnline.meta.Trx;

public interface TrxDAO {
	//增
	@Insert("INSERT INTO trx(contentId,personId,price,num,time) "
			+ "VALUES(#{contentId},#{personId},#{price},#{num},#{time})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	public int insertTrx(Trx trx);
	
	
	//查
	@Select("select * from trx where personId=#{userId} and contentId=#{productId}")
	//多个参数要么用@param声明变量，要么像 #{0}#{1}#{param1}#{param2}一样引用
	public List<Trx> getTrxBuyed(@Param("userId")int userId,@Param("productId")int productId); 
	
	@Select("select * from trx where contentId=#{productId}")
	public List<Trx> getTrxOfProduct(int productId);
	
	@Select("select contentId, title, icon, t.price as buyPrice, num, time "
			+ "from trx t left join content c on t.contentId=c.id where personId=#{userId}")
	@Results({
		@Result(property="id", column="contentId"),
		@Result(property="image", column="icon"),
//		@Result(property="buyPrice", column="buyPrice"),
		@Result(property="buyNum", column="num"),
		@Result(property="buyTime", column="time")
	})
	public List<BuyingRecord> getBuyList(int userId);
}
