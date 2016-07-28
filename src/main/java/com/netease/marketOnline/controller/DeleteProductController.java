package com.netease.marketOnline.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.marketOnline.service.ProductService;

@Controller
public class DeleteProductController {
	@Autowired
	private ProductService productServiceImpl;

	@RequestMapping(value="/api/delete", method=RequestMethod.POST)
	public Object deleteProduct(@RequestParam("id") int id, HttpSession session) {
		Map<String, Object> result=new HashMap<String, Object>();
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		if (!judgeSeller(userName,usertype)) {
			result.put("code", 400);
			result.put("message", "bad seller");
			result.put("result", false);
		} else if (productServiceImpl.deleteProduct(id)) {//假定上传成功
			System.out.println("id:"+id);
			result.put("code", 200);
			result.put("result", true);
		} else { //上传失败时
			result.put("code", 400);
			result.put("message", "上传失败");
			result.put("result", false);
		}
		
		return result;
	}
	
	private boolean judgeSeller(String userName,int usertype){
		boolean isSeller = false;
		if (usertype==1 && userName.equals("seller")) {
			isSeller = true;
		}
		return isSeller;
	}
}
