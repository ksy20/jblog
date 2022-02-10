package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int setBlog(BlogVo blogVo) {
		System.out.println("[BlogDao.insertBlog()]");
		
		return sqlSession.insert("blog.insertBlog", blogVo);
	}
	
	//블로그메인
	public BlogVo getBlog(String id) {
		System.out.println("[BlogDao.selectBlog()]");
		
		return sqlSession.selectOne("blog.selectBlog",id);
	}
	
	public void insertBlog(BlogVo blogVo) {
		sqlSession.insert("blog.insertBlog", blogVo);
	}
	
	

}
