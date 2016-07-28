package com.netease.marketOnline.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.marketOnline.meta.Product;
import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.service.ProductService;

@Controller
public class PublicSubmit {
	@Autowired
	private ProductService productServiceImpl;
	
	@RequestMapping(value="/publicSubmit", method=RequestMethod.POST)
	public String publicSubmit(@RequestParam("title") String title, @RequestParam("image") String image,
			@RequestParam("detail") String detail, @RequestParam("price") int price,
			@RequestParam("summary") String summary, HttpSession session, Model model) {
		
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
//		User user = null;
		if(userName!=null && usertype==1){//判断是seller
			User user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
			model.addAttribute("user", user);
		}
		
//		System.out.println("title:"+title+";image:"+image+";detail:"+detail+";price:"+price+";summary:"+summary);
		Product product = new Product();
		product.setTitle(title);
		product.setSummary(summary);
		product.setDetail(detail);
		product.setImage(image);
		product.setPrice(price);
		if (productServiceImpl.insertProduct(product)) {//提交成功则有product数据,失败则没有
//			Product product = new Product();
//			product.setId(777);
//			product.setTitle(title);
//			product.setSummary(summary);
//			product.setDetail(detail);
//			product.setImage(image);
//			product.setPrice(price);
//			System.out.println(product.getId());
//			System.out.println("title:"+product.getTitle()+";image:"+product.getImage()+
//					";detail:"+product.getDetail()+";price:"+product.getPrice()+";summary:"+product.getSummary());
			model.addAttribute("product",product);
		}
		
		return "publicSubmit";
	}
}
