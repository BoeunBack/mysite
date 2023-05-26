package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlsession;
	
//	회원가입
	public void insertUser(UserVo userVo) {
		sqlsession.insert("user.insert", userVo);
		
	}
	
	public UserVo selectUser(UserVo userVo) {
		System.out.println("UserDao.selectUser()");
		UserVo authUser= sqlsession.selectOne("user.selectUser", userVo);
				System.out.println(authUser);
		return authUser;
	}
	
	//수정에 회원정보 가져오기
	public UserVo selectUser(int no) {
		System.out.println("UserDao.selectUser()");
		UserVo userVo = sqlsession.selectOne("user.modifyUser", no);
		System.out.println(userVo);
		return userVo;
		
	}
	
	//수정
	public void updateUser(UserVo userVo) {
		System.out.println("UserDao.uadateUser()");
		
		System.out.println(userVo);
		sqlsession.update("user.updateVo", userVo);
		System.out.println(userVo);
		
	}

}
//public int insertUser(UserVo userVo) {
//		System.out.println("UserDao.insertUser()");
//		System.out.println(userVo);
//		
//		int count = sqlsession.insert("user.insert", userVo);
//		return count;		
//	}