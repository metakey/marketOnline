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
public class EditSubmit {
	@Autowired
	private ProductService productServiceImpl;
	
	@RequestMapping(value="/editSubmit", method=RequestMethod.POST)
	public String editSubmit(@RequestParam("id") int id, @RequestParam("title") String title,
			@RequestParam("summary") String summary, @RequestParam("detail") String detail,
			@RequestParam("image") String image, @RequestParam("price") int price,
			 HttpSession session, Model model) {
		
		String userName=(String)session.getAttribute("username");
		Integer usertype=(Integer)session.getAttribute("usertype");
		User user = null;
		if(userName!=null && usertype==1){
			user=new User();
			user.setUsername(userName);
			user.setUsertype(usertype);
			model.addAttribute("user", user);
		}
		
		//提交数据，提交成功则返回product
		Product product = new Product();
		product.setId(id);
		product.setTitle(title);
		product.setSummary(summary);
		product.setDetail(detail);
		product.setImage(image);
		product.setPrice(price);
		
		if (productServiceImpl.updateProduct(product)) {
			model.addAttribute("product", product);
		}
		
		return "editSubmit";
	}
}
