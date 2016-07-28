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
public class Show {
	@Autowired
	private ProductService productServiceImpl;
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String show(@RequestParam("id") int productId, HttpSession session, Model model) {
		
		User user=null;
		if (!session.isNew()) {
			int userId= (Integer) session.getAttribute("userid");
			String userName=(String)session.getAttribute("username");
			Integer usertype=(Integer)session.getAttribute("usertype");
			if(userName!=null&&usertype!=null){
				user=new User();
				user.setId(userId);
				user.setUsername(userName);
				user.setUsertype(usertype);
				model.addAttribute("user", user);
			}
		}
		//根据user的类型(是buyer还是seller)，返回Product，判断逻辑在service中进行
		Product product = productServiceImpl.getProduct(user,productId);
//		
//		p1.setId(productId);
//		p1.setTitle("标题");
//		p1.setSummary("摘要");
//		p1.setDetail("全文");
//		p1.setImage("http://nec.netease.com/img/s/1.jpg");
//		p1.setPrice(1);
//		p1.setBuyPrice(3);
//		p1.setBuyNum(4);
//		p1.setSaleNum(5);
//		p1.setBuy(true);
//		p1.setSell(true);
		
		System.out.println(product.getBuyPrice());
		
		model.addAttribute("product", product);
		return "show";
	}
}
