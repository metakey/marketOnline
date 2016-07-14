package com.netease.marketOnline.web.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.meta.UserBuyed;
/*
 * 当前用户已购买的商品列表
 */
@Controller
public class Account {
	@RequestMapping(value="/account", method=RequestMethod.GET)
	public String account(HttpSession session, Model model) {
		User user=null;
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		if(userName!=null&&usertype!=null){
			user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
		}
		
		List<UserBuyed> buyList = new LinkedList<UserBuyed>();
		UserBuyed p1 = new UserBuyed();
		p1.setId(3);
		p1.setTitle("已购买1");
		p1.setImage("http://nec.netease.com/img/s/1.jpg");
		p1.setBuyPrice(3);
		p1.setBuyNum(3);
		p1.setBuyTime(1407499055617L);
		buyList.add(p1);
		
		UserBuyed p2 = new UserBuyed();
		p2.setId(4);
		p2.setTitle("已购买2");
		p2.setImage("http://nec.netease.com/img/s/1.jpg");
		p2.setBuyPrice(4);
		p2.setBuyNum(4);
		p2.setBuyTime(1407499055617L);
		buyList.add(p2);
		
		
		model.addAttribute("user", user);
		model.addAttribute("buyList", buyList);
		return "account";
	}
}
