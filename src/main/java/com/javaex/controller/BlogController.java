package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	
	//블로그 유저 가져오기
	@ModelAttribute("blogUser")
	public UserVo blogUser(@PathVariable("id") String id) {
		return blogService.getBlogUser(id);
	}
	
	//블로그 아이디 가져오기
	@ModelAttribute("blogVo")
	public BlogVo blogVo(@PathVariable("id") String id) {
		return blogService.getBlog(id);
	}
		
	@RequestMapping("")
	public String blogMain(@PathVariable("id") String id) {
		return "blog/blog-main";
	}


}
