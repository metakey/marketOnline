package com.netease.marketOnline.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netease.marketOnline.meta.User;

/*
 * 购物车按钮
 * 页面中列出购物车中所有内容的标题、价格、数量
 * 有“退出”和“购买”2个按钮
 * 查看js，“退出”指向window.history.back()
 * 购买调用'post'：'/api/buy'以及./account.html
 */
@Controller
public class SettleAccount {
	@RequestMapping(value="/settleAccount", method=RequestMethod.GET)
	public String settleAccount(HttpSession session, Model model) {
		User user=null;
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		if(userName!=null&&usertype!=null){
			user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
		}
		
		model.addAttribute("user", user);
		return "settleAccount";
	}
	
}
