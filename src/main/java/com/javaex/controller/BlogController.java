package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	
	//블로그 유저 가져오기
	@ModelAttribute("blogUser")
	public UserVo blogUser(@PathVariable("id") String id) {
		System.out.println("[BlogController.blogUser()]");
		return blogService.getBlogUser(id);
	}
	
	//블로그 아이디 가져오기
	@ModelAttribute("blogVo")
	public BlogVo blogVo(@PathVariable("id") String id) {
		System.out.println("[BlogController.blogVo()]");
		return blogService.getBlog(id);
		
	}
		
	//블로그 메인
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String main(@PathVariable("id") String id,
					   @ModelAttribute BlogVo blogVo) {
		System.out.println("[BlogController.Main()]");
		
		BlogVo authBlog = blogService.getbUser(blogVo);
		System.out.println(authBlog);
		
		return "blog/blog-main";
	}
	
	

}
