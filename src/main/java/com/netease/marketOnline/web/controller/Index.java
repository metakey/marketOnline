package com.netease.marketOnline.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netease.marketOnline.meta.Product;
import com.netease.marketOnline.meta.User;
import com.netease.marketOnline.service.ProductService;
import com.netease.marketOnline.service.TrxService;



@Controller
public class Index {
	@Autowired
	private ProductService productServiceImpl;
	@Autowired
	private TrxService trxServiceImpl;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String indexPage(HttpSession session,Model model) {
		
		User user=null;
		if (!session.isNew()) {
			int id = (Integer) session.getAttribute("userid");
			String userName=(String)session.getAttribute("username");
			Integer usertype=(Integer)session.getAttribute("usertype");
			
			if(userName!=null&&usertype!=null){
				user=new User();
				user.setId(id);
				user.setUsername(userName);
				user.setUsertype(usertype);
				model.addAttribute("user", user);
			}
		}
		
		List<Product> productList = productServiceImpl.getAllProducts();
		for (Product product:productList ) {
			System.out.println(product.getIsBuy());
		}
		for (Product product:productList) {
			product.setBuy(false);
			product.setSell(false);
			if (user!=null && user.getUsertype()==0 && trxServiceImpl.judgeBuyed(user.getId(), product.getId())){
				product.setBuy(true);
			}else if (user!=null && user.getUsertype()==1 && trxServiceImpl.judgeSold(product.getId())){
				product.setSell(true);
			}
		}

		
		model.addAttribute("productList", productList);
		return "index";
	}
}

