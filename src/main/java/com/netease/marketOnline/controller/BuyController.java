package com.netease.marketOnline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.marketOnline.meta.ProductBuyed;
import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.service.TrxService;

@Controller
@RequestMapping("/api")
public class BuyController {

	//读取数据
	@Autowired
	private TrxService trxServiceImpl;
	
	@RequestMapping(value="/buy", method=RequestMethod.POST)
	@ResponseBody
	public Object buy(@RequestBody List<ProductBuyed> buyList, HttpSession session) {
		Map<String, Object> result=new HashMap<String, Object>();

		
		if (session.isNew()) {
			result.put("code", 400);
			result.put("message", "请登录");
			result.put("result", false);
			return result;
		} 
			
		User user=getUserFromSession(session);
		boolean success = false;
		success = trxServiceImpl.buyProducts(user, buyList);
		if (success) {//购买成功
			result.put("code", 200);
			result.put("result", true);
		} else { //购买失败
			result.put("code", 400);
			result.put("message", "购买失败");
			result.put("result", false);
		}
		
		return result;
	}
	private User getUserFromSession(HttpSession session){
		User user = null;
		int userId= (Integer) session.getAttribute("userid");
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		if(userName!=null&&usertype!=null){
			user=new User();
			user.setId(userId);
			user.setUsername(userName);
			user.setUsertype(usertype);
		}
		return user;
	}
	
}
