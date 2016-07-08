package com.netease.marketOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteProductController {

	@RequestMapping("/delete")
	public void deleteProduct(@RequestParam("id") int productId) {
		
	}
}
