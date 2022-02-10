package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	
	//블로그 유저 가져오기
	@ModelAttribute("blogUser")
	public UserVo blogUser(@PathVariable("id") String id) {
		System.out.println("여기가 오나");
		return blogService.getBlogUser(id);
	}
	
	//블로그 아이디 가져오기
	@ModelAttribute("blogVo")
	public BlogVo blogVo(@PathVariable("id") String id) {
		System.out.println("여기가 오나");
		return blogService.getBlog(id);
	}
		
	@ModelAttribute(value="/blog/${authUser.id}")
	public String blogMain(@PathVariable("id") String id) {
		System.out.println("여기가 오나");
		return "blog/blog-main";
	}

}
