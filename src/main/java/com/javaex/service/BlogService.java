package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private UserDao userDao;

	//블로그 유저 가져오기
	public UserVo getBlogUser(String id) {
		
		return userDao.selectbUser(id);
	}
	
	//블로그 가져오기
	public BlogVo getBlog(String id) {
		return blogDao.getBlog(id);
		
	}
	

}