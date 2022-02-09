package com.javaex.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	//회원가입 insert 하기
	public int insertUser (UserVo userVo) {
		System.out.println("[UserDao.insertUser()]");
		
		return sqlSession.insert("user.insertUser", userVo);
	}
	
	//로그인 하기
	public UserVo selectUser(UserVo userVo) {
		System.out.println("[UserDao.selectUser()]");
		
		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);
		return authUser;
	}
	
}
