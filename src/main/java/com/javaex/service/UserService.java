package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	
	//회원가입
	public void join(UserVo userVo) {
		System.out.println("[UserService.join()]");
		
		userDao.insertUser(userVo);
		
		//블로그 생성
		BlogVo blogVo = new BlogVo();
		
		blogVo.setId(userVo.getId());
		blogVo.setBlogTitle(userVo.getUserName() +"의 블로그입니다. ");
		blogVo.setLogoFile("spring-logo.jpg");
		
		blogDao.setBlog(blogVo);
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("[UserService.login()]");
		
		UserVo authUser = userDao.selectUser(userVo);
		return authUser;
	}
	
}
