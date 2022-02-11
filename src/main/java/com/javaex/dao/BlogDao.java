package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.CateVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//블로그 만들기
	public int setBlog(BlogVo blogVo) {
		System.out.println("[BlogDao.insertBlog()]");
		
		return sqlSession.insert("blog.insertBlog", blogVo);
	}
	
	//블로그 유저 정보
	public BlogVo selectBlog (BlogVo blogVo) {
		System.out.println("[BlogDao.selectBlog()]");
		
		BlogVo authBlog = sqlSession.selectOne("blog.selectbUser", blogVo);
		return authBlog;
	}
	
	//블로그메인
	public BlogVo getBlog(String id) {
		System.out.println("[BlogDao.selectBlog()]");
		
		return sqlSession.selectOne("blog.selectBlog",id);
	}
	
	//카테고리 만들기
	public int setCate (CateVo cateVo) {
		System.out.println("[BlogDao.setCate()]");
		
		System.out.println("여기?");
		return sqlSession.insert("cate.insertCate", cateVo);
	}

	
	

}
