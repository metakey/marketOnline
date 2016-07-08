package com.netease.marketOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UploadPictureController {
	@RequestMapping("upload")
	public void uploadPicture(@RequestParam("id") String url) {
		
	}
}
