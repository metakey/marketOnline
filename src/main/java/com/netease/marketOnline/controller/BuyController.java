package com.netease.marketOnline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.marketOnline.meta.ProductBuyed;

@Controller
@RequestMapping("/api")
public class BuyController {

	private static Map<String,Object> users=new HashMap<String, Object>();
	static {
		users.put("buyer", "37254660e226ea65ce6f1efd54233424");
		users.put("seller", "981c57a5cfb0f868e064904b8745766f");
	}
	@RequestMapping(value="/buy", method=RequestMethod.POST)
	@ResponseBody
	public Object buy(ArrayList<ProductBuyed> buylist, HttpSession session, Model model) {
		Map<String, Object> result=new HashMap<String, Object>();
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		if (!judgeBuyer(userName,usertype)) {
			result.put("code", 400);
			result.put("message", "bad buyer");
			result.put("result", false);
		} else if (true) {//购买成功
			for (ProductBuyed tmp : buylist) {
				
				System.out.println("id"+tmp.getId()+":number"+tmp.getNumber());
			}
			System.out.println(buylist);
			
			result.put("code", 200);
			result.put("result", true);
//		} else { //购买失败
//			result.put("code", 400);
//			result.put("message", "购买失败");
//			result.put("result", false);
		}
		
		return result;
	}
	
	private boolean judgeBuyer(String userName,int usertype){
		boolean isBuyer = false;
		if (usertype==0 && userName.equals("buyer")) {
			isBuyer = true;
		}
		return isBuyer;
	}
}
