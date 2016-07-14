package com.netease.marketOnline.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.marketOnline.meta.Product;
import com.netease.marketOnline.meta.User;

@Controller
public class PublicSubmit {
	@RequestMapping(value="/publicSubmit", method=RequestMethod.POST)
	public String publicSubmit(@RequestParam("title") String title, @RequestParam("image") String image,
			@RequestParam("detail") String detail, @RequestParam("price") int price,
			@RequestParam("summary") String summary, HttpSession session, Model model) {
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		User user = null;
		if(userName!=null && usertype==1){//判断是seller
			user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
		}
		
		Product product = new Product();
		System.out.println("title:"+title+";image:"+image+";detail:"+detail+";price:"+price+";summary:"+summary);
		if (true) {//提交成功则有product数据,失败则没有
			product.setId(777);
			product.setTitle(title);
			product.setSummary(summary);
			product.setDetail(detail);
			product.setImage(image);
			product.setPrice(price);
			model.addAttribute("product",product);
		}
		model.addAttribute("user", user);
		return "publicSubmit";
	}
}
