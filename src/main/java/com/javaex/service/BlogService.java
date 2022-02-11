package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private UserDao userDao;

	//블로그 유저 정보 가져오기
	public UserVo getBlogUser(String id) {
		System.out.println("[BlogService.getBlogUser()]");
		
		return userDao.selectbUser(id);
	}
	
	//블로그 가져오기
	public BlogVo getBlog(String id) {
		System.out.println("[BlogService.getBlog()]");
		return blogDao.getBlog(id);
		
	}
	
	//블로그 유저 정보 가져오기
	public BlogVo getbUser(BlogVo blogVo) {
		System.out.println("[BlogService.getBlogUser()]");
			
		BlogVo authBlog = blogDao.selectBlog(blogVo);
		return authBlog;
	}

}