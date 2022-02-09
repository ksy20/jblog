package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;

public class BlogController {
	
	@Autowired
	private BlogService blogService;

	//블로그 메인 가져오기
	@RequestMapping(value="/blog/${authUser.id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("[BlogController.Blog()]");
		
		return "blog/blog-main";
	}
		
	@RequestMapping("")
	public String blogMain(@PathVariable("id") String id, Model model) {
		Map<String, Object> blogMap = blogService.blogMain(id);
		//System.out.println(blogMap);
		model.addAttribute("map",blogMap);
			
		return "blog/blog-main";
	}


}
